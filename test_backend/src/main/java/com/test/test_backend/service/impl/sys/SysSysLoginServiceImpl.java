package com.test.test_backend.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.test_backend.common.enums.CodeEnum;
import com.test.test_backend.common.utils.EncryptUtil;
import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.common.utils.PrecompiledPattern;
import com.test.test_backend.common.utils.TokenUtil;
import com.test.test_backend.dto.LoginDto;
import com.test.test_backend.dto.RegisterDto;
import com.test.test_backend.entity.SysUser;
import com.test.test_backend.mapper.SysUserMapper;
import com.test.test_backend.service.sys.SysLoginService;
import com.test.test_backend.vo.LoginVo;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class SysSysLoginServiceImpl implements SysLoginService {
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 登录
     *
     * @param: loginDto
     * @author: ymxl
     * @date: 2025-08-26
     * TODO
     */
    @Override
    public JsonResult<LoginVo> login(LoginDto loginDto) {
        LoginVo loginVo = new LoginVo();
        // 判断参数
        if (StringUtils.isEmpty(loginDto.getAccount()) || StringUtils.isEmpty(loginDto.getPassword())) {
            return JsonResult.fail("传参为空");
        }
        // 查询用户信息
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", loginDto.getAccount());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        // 用户信息为空，未拥有账户
        if (sysUser == null) {
            return JsonResult.fail("未拥有账户");
        }
        // 判断密码
        if (!EncryptUtil.checkPassword(loginDto.getPassword(), sysUser.getPassword())) {
            return JsonResult.fail("密码错误");
        }
        // 获取token
        String token = TokenUtil.getToken(sysUser.getUserId(), sysUser.getAccount(), sysUser.getUserRole());
        log.info("token:{}", token);
        loginVo.setToken(token);
        return JsonResult.success(loginVo);
    }

    /**
     * 注册
     *
     * @author: ymxl
     * @date: 2026/3/2
    */
    @Override
    public JsonResult<String> register(RegisterDto registerDto) {
        // 1.校验信息
        // 2.校验账户是否存在
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", registerDto.getAccount());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        if (sysUser != null) {
            return JsonResult.fail("账户已存在！");
        }
        // 3.校验密码是否符合规范
        Boolean r = Pattern.matches(PrecompiledPattern.PASSWORD_PATTERN.toString(), registerDto.getPassword());
        // 4.进行加密存入数据库
        SysUser user = new SysUser();
        BeanUtils.copyProperties(registerDto, user);
        user.setPassword(EncryptUtil.getEncryptPassword(registerDto.getPassword()));
//        sysUserMapper.insert(user);
        return JsonResult.success();
    }
}

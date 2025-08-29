package com.test.test_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.test_backend.common.enums.CodeEnum;
import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.common.utils.TokenUtil;
import com.test.test_backend.dto.LoginDto;
import com.test.test_backend.entity.SysUser;
import com.test.test_backend.mapper.SysUserMapper;
import com.test.test_backend.service.LoginService;
import com.test.test_backend.vo.LoginVo;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private TokenUtil tokenUtil;


    /**
     * 登录
     *
     * @return
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
            return new JsonResult<>(null, "传参为空", CodeEnum.SUCCESS.getCode());
        }
        // 查询用户信息
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", loginDto.getAccount());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);
        // 用户信息为空，未拥有账户
        if (sysUser == null) {
            return new JsonResult<>(null, "未拥有账户", CodeEnum.SUCCESS.getCode());
        }
        // 判断密码
        if (!loginDto.getPassword().equals(sysUser.getPassword())) {
            return new JsonResult<>(null, "密码错误", CodeEnum.SUCCESS.getCode());
        }
        // 获取token
        String token = tokenUtil.getToken(sysUser.getUserId(), sysUser.getAccount(), sysUser.getUserRole());
        log.info("token:{}", token);
        loginVo.setToken(token);
        return new JsonResult<>(loginVo);
    }
}

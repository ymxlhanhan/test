package com.test.test_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.test_backend.common.utils.JsonResult;
import com.test.test_backend.common.utils.TokenUtil;
import com.test.test_backend.dto.LoginDto;
import com.test.test_backend.entity.SysUser;
import com.test.test_backend.mapper.SysUserMapper;
import com.test.test_backend.service.LoginService;
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
    public JsonResult<Boolean> login(LoginDto loginDto) {
        JsonResult<Boolean> result = new JsonResult<>();

        if (StringUtils.isEmpty(loginDto.getAccount()) || StringUtils.isEmpty(loginDto.getPassword())) {
            return new JsonResult<>(Boolean.TRUE, "传参为空", "200");
        }

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", loginDto.getAccount());
        SysUser sysUser = sysUserMapper.selectOne(wrapper);

        if (sysUser == null) {
            return new JsonResult<>(Boolean.TRUE, "未拥有账户", "200");
        }
        String token = tokenUtil.getToken(sysUser.getUserId(), sysUser.getAccount(), sysUser.getUserRole());

        return new JsonResult<>( );
    }
}

package com.test.test_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.test_backend.entity.SysUser;
import com.test.test_backend.mapper.SysUserMapper;
import com.test.test_backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getList(String keyword) {
        return sysUserMapper.getListByKeyword(keyword);
    }
}

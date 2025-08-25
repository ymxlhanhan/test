package com.test.test_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.test_backend.entity.SysUser;

import java.util.List;

public interface SysUserService extends IService<SysUser> {
    List<SysUser> getList(String keyword);
}

package com.test.test_backend.controller;

import com.test.test_backend.entity.SysUser;
import com.test.test_backend.service.SysUserService;
import com.test.test_backend.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/list")
    public JsonResult<List<SysUser>> getUserList(@RequestBody String keyword) {
        JsonResult<List<SysUser>> result = new JsonResult<>();
        try {
            result.setData(sysUserService.getList(keyword));
        } catch (Exception e) {
            result.setSuccess(false);
            log.error("查询系统用户列表失败", e.getMessage());
        }
        return result;
    }

    @PostMapping("/update")
    public JsonResult updateUsers(@RequestBody SysUser users) {
        JsonResult result = new JsonResult();
        try{
//            sysUserService.updateUsers();
        } catch (Exception e) {
            log.error("更新系统用户信息失败", e.getMessage());
        }
        return result;
    }

}

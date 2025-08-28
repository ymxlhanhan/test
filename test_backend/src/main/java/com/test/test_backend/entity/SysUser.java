package com.test.test_backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.test.test_backend.common.dao.BaseDao;
import lombok.Data;

@Data
@TableName("sys_user")
public class SysUser {
    @TableId
    private String userId;
    private String account;
    private String password;
    private String user_name;
    private String deleted;
    private String userRole;
    private String remark;
}

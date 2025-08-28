package com.test.test_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.test_backend.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> getListByKeyword(@Param("keyword") String keyword);
}

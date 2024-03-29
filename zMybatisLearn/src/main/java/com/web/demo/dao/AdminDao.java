package com.web.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web.demo.bo.Admin;
import com.web.demo.bo.Test01;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface AdminDao extends BaseMapper<Admin> {
//    int deleteByPrimaryKey(Long pokid);
//
//    int insert(Admin record);
//
//    int insertSelective(Admin record);
//
    Admin selectByPrimaryKey(Long pokid);
    
    int insertAdmin(Admin admin);
    int insertAdminByBatch(List<Test01> test01s);

    Admin selectAdmin(Admin admin);
//
//    int updateByPrimaryKeySelective(Admin record);
//
//    int updateByPrimaryKey(Admin record);
}
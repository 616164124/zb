package com.demo.web.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DemoDao  {
    @Select("select * from admin where pokid=#{id}")
    Map<String, String> getDemoById(@Param("id") String id);

    List<Map<String, String>> getDemoByName(@Param("username") String username);

    @Insert("insert into admin (pokid,username, password) values(#{pokid},#{username},#{password}) ")
    int setAdmin(Map<String, String> paramsMap);
}

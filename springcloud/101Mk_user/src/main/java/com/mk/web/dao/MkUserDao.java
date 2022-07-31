package com.mk.web.dao;


import com.mk.web.bo.MkUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MkUserDao {
    int deleteByPrimaryKey(String userid);

    int insert(MkUser record);

    int insertSelective(MkUser record);

    MkUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(MkUser record);

    int updateByPrimaryKey(MkUser record);

    int selectOne(MkUser record);
}
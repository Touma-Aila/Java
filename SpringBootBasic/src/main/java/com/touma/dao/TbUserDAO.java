package com.touma.dao;

import org.apache.ibatis.annotations.Mapper;

import com.touma.entity.TbUser;

/**
 * TbUser的DAO
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface TbUserDAO {
  /**
   * login 用户登录
   * 
   * @param user 登录用户信息
   * @return 正确就返回用户完整信息 否则返回null
   * @throws Exception
   */
  TbUser login(TbUser user) throws Exception;
}

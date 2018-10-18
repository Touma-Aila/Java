package com.touma.dao;

import org.apache.ibatis.annotations.Mapper;

import com.touma.entity.TbToken;

/**
 * Token追踪 如果客户端没有提供Token 创建新的Token添加到数据库中 返回到Token给客户端 <br>
 * 如果客户端提供Token 就判断Token是否在数据库中存在且没有过期(lastupdate) <br>
 * 不存在或者过期就回到新建的流程 存在就更新过期时间(lastupdate) <br>
 * 如果Token对应的客户端长期不向服务器发起数据 会造成数据库资源浪费 所以要开启定时任务检查Token的lastupdate <br>
 * 超过一定的时间就会自动清理 <br>
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface TbTokenDAO {
  /**
   * addToken-添加Token
   * 
   * @param touken
   * @return
   */
  int addToken(TbToken token) throws Exception;

  /**
   * updateToken-更新Token时间
   * 
   * @param touken
   * @return
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * queryToken-查询Token是否存在
   * 
   * @param touken
   * @return
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * deleteTokens-删除Token任务
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;
}

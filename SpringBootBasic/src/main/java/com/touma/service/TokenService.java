package com.touma.service;

import com.touma.entity.JsonMessage;
import com.touma.entity.TbToken;

/**
 * Token的服务
 * @author 1329321290
 *
 */
public interface TokenService {
  
  /**
   * 更新或者返回新的Token
   * @param token 客户端的Token
   * @return
   * @throws Exception
   */
  JsonMessage createToken(TbToken token) throws Exception;

}

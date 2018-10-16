package com.touma.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touma.dao.TbTokenDAO;
import com.touma.entity.JsonMessage;
import com.touma.entity.TbToken;
import com.touma.service.TokenService;

/**
 * TbToken的服务器 Transactional表示开启事务处理 表示类中的方法调用dao处理数据会在事务中 <br>
 * 要么全部成功 要么全部失败 所以一定要service层处理业务 <br>
 * rollbackFor表示要回滚事务的类型 Exception.class表示方法抛出Exception或者它的子类就会事务回滚
 * 
 * @author 1329321290
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService {

  @Autowired
  public TbTokenDAO tbTokenDAO;

  /**
   * 创建一个新的Token
   * 
   * @return
   * @throws Exception
   */
  public JsonMessage makeNewToken() throws Exception {
    // 通过UUID生产随机的Token
    String t = UUID.randomUUID().toString();
    TbToken stoken = new TbToken();
    stoken.setToken(t);
    // 保存到数据库
    tbTokenDAO.addToken(stoken);
    JsonMessage message = JsonMessage.getSuccess("");
    message.getDatas().put("token", stoken.getToken());
    return message;
  }

  @Override
  public JsonMessage createToken(TbToken token) throws Exception {
    // 查询Token是否存在
    // 不存在要创建
    // 传入token基本效验
    if (token == null || token.getToken()== null) {
      return makeNewToken();
    }
    // 数据库校验
    // 不存在要创建
    TbToken stoken = tbTokenDAO.queryToken(token);
    if (stoken == null ) {
      return makeNewToken();
    }
    // TbToken stoken
    // 存在就更新
    tbTokenDAO.updateToken(stoken);
    // 返回Token
    JsonMessage message=JsonMessage.getSuccess("");
    message.getDatas().put("token", stoken.getToken());
    return message;
  }
}

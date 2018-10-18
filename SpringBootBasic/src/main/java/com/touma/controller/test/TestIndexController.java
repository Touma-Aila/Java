package com.touma.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.touma.AppException;
import com.touma.entity.JsonMessage;
import com.touma.entity.TbToken;
import com.touma.service.TokenService;

/**
 * 测试用的controller
 * 
 * @author 1329321290
 *
 */
@RestController
@ResponseBody
@RequestMapping("/test")
public class TestIndexController {
  
  // 日志的配置在application.yml里面 error>info>debug
  // 尽可能都用debug 如果是异常信息用error 程序关键可以用info
  // 发布到服务器的时候需要开启file日志 级别可以升到error

  @Autowired
  public TokenService tokenService;

  @RequestMapping("/createToken")
  public JsonMessage createToken(TbToken token) throws Exception {
    return tokenService.createToken(token);
  }
@RequestMapping("/exception")
  public JsonMessage exception(String type) throws Exception {
    if ("One".equals(type)) {
      throw AppException.getaAppException(1000, "第一种异常");
    } else if ("Two".equals(type)) {
      throw AppException.getaAppException(1001, "第二种异常");
    } else if ("OK".equals(type)) {
      return JsonMessage.getSuccess("没有错误");
    } else {
      throw new Exception("标准异常");
    }
  }
}

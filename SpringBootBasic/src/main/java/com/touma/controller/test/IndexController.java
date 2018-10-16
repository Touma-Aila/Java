package com.touma.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
public class IndexController {

  @Autowired
  public TokenService tokenService;

  @RequestMapping("/createToken")
  public JsonMessage createToken(TbToken token) throws Exception {
    return tokenService.createToken(token);
  }
}

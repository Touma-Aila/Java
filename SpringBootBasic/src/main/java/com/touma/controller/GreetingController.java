package com.touma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.touma.config.MyConfig;
import com.touma.entity.Greeting;
import com.touma.entity.JsonMessage;

/**
 * greeting控制器
 * 
 * @author 1329321290
 *
 */
@RestController
@ResponseBody
@RequestMapping("/touma")
public class GreetingController {
  @Autowired
  private MyConfig myConfig;

  @RequestMapping(name = "/index")
  public JsonMessage index() {
    // 127.0.0.1:20000
    String m = String.format("欢迎使用springboot服务,%s,%s", myConfig.appName, myConfig.reload);
    JsonMessage message = JsonMessage.getSuccess(m);
    return message;
  }
  
  /**
   * jsonmessag-返回登录信息
   * @param greeting
   * @return
   */
  @RequestMapping("/greeting")
  // Http://127.0.0.1/greeting?id=xxx&content=xxxx
  public JsonMessage greeting(Greeting greeting) {
    JsonMessage message = JsonMessage.getSuccess("");
    message.getDatas().put("greeting", greeting);
    return message;
  }
}

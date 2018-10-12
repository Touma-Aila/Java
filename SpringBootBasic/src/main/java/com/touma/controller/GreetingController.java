package com.touma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.touma.config.MyConfig;
import com.touma.entity.Greeting;

/**
 * greeting控制器
 * 
 * @author 1329321290
 *
 */
@RestController
public class GreetingController {
  @Autowired
  private MyConfig myConfig;

  @RequestMapping(name = "")
  public String index() {
    // 127.0.0.1:20000
    return String.format("欢迎使用springboot服务,%s,%s", myConfig.appName, myConfig.reload);
  }

  @RequestMapping("/greeting")
  @ResponseBody
  // Http://127.0.0.1/greeting?id=xxx&content=xxxx
  public Greeting greeting(Greeting greeting) {
    return greeting;
  }
}

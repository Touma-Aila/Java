package com.touma.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.touma.entity.Greeting;

/**
 * greeting控制器
 * 
 * @author 1329321290
 *
 */
@RestController
public class GreetingController {
  @RequestMapping(name = "")
  public String index() {
    return "欢迎使用springboot!";
  }

  @RequestMapping("/greeting")
  @ResponseBody
  // Http://127.0.0.1/greeting?id=xxx&content=xxxx
  public Greeting greeting(Greeting greeting) {
    return greeting;
  }
}

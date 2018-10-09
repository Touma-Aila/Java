package com.touma.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * MyApi单元测试
 * @author 1329321290
 *
 */
public class MyApiTest {
  public MyApi api=new MyApi();
  
  @Test
  public void getNow() {
    String now=api.getNow();
    //相同测试断言 getNow返回值得长度是19
    assertEquals(now.length(),19);
  }
}

package com.touma.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * mvc配置
 * 
 * @author 1329321290
 *
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    // 跨域配置
    WebMvcConfigurer.super.addCorsMappings(registry);
    // addMapping表示添加的url映射 /**表示所有的页面都支持跨域
    // /**表示所有的页面都支持跨域 一般会配置业务处理的url 而非全部
    // allowedMethods表示允许的http事件(POST GET DELETE...)
    // 比如前端域名是huhuiyu.top 而springboot后端域名为api.huhuiyu.top
    // 那么应该允许的域名应该配置成huhuiyu.top 或者相对危险的*.huhuiyu.top
    registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowCredentials(false);
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    WebMvcConfigurer.super.configureMessageConverters(converters);
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    // TODO 这里需要配置json转换的细节
    converters.add(0, converter);
  }

}

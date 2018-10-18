package com.touma.service;

/**
 * 系统定时任务服务类 service层是dao层和controller层的中间层 负责处理业务逻辑
 * 
 * @author 1329321290
 *
 */
public interface TaskService {
  /**
   * 定时显示当前时间
   */
  void showTime();

  /**
   * 固定时间点执行
   */
  void showTimeOnce();

  /**
   * 删除Token任务
   */
  void deleteTokens();

}

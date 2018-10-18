package com.touma;

/**
 * AppException-应用程序自定义异常
 * 
 * @author 1329321290
 *
 */
public class AppException extends Exception {

  private static final long serialVersionUID = -7606128729873987032L;
  private int code = 500;

  public AppException(int code, String message) {
    super(message);
    this.code = code;
  }

  public static AppException getaAppException(int code, String message) {
    return new AppException(code, message);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

}

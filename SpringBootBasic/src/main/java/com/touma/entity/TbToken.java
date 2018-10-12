package com.touma.entity;

import java.io.Serializable;
import java.util.Date;

public class TbToken implements Serializable {
  private static final long serialVersionUID = 6448483160916127686L;

  private String token;
  private Integer uid;
  private Date lastupdate;

  public TbToken() {

  }

  public TbToken(String token, Integer uid, Date lastupdate) {
    super();
    this.token = token;
    this.uid = uid;
    this.lastupdate = lastupdate;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  @Override
  public String toString() {
    return "TbToken [token=" + token + ", uid=" + uid + ", lastupdate=" + lastupdate + "]";
  }

}

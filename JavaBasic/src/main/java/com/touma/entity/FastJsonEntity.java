package com.touma.entity;

import java.io.Serializable;

public class FastJsonEntity implements Serializable{
  private static final long serialVersionUID = 2902619064762315539L;
  private Integer eid;
  private String info;
  
  public FastJsonEntity() {
    
  }

  public Integer getEid() {
    return eid;
  }

  public void setEid(Integer eid) {
    this.eid = eid;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "FastJsonEntity [eid=" + eid + ", info=" + info + "]";
  }
   
}

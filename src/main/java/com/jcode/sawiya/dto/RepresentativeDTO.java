package com.jcode.sawiya.dto;

import java.io.Serializable;


public class RepresentativeDTO implements Serializable {

    private Integer repId;
    private String appointedOn;
    private String retiredOn;
    private String remarks;
    
	public Integer getRepId() {
		return repId;
	}
	public void setRepId(Integer repId) {
		this.repId = repId;
	}
	public String getAppointedOn() {
		return appointedOn;
	}
	public void setAppointedOn(String appointedOn) {
		this.appointedOn = appointedOn;
	}
	public String getRetiredOn() {
		return retiredOn;
	}
	public void setRetiredOn(String retiredOn) {
		this.retiredOn = retiredOn;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
    
}

package com.hbsi.pojo;

public class Atsstate {

	private Integer atsstate_id;
	private String atsstate_name;
	public Integer getAtsstate_id() {
		return atsstate_id;
	}
	public void setAtsstate_id(Integer atsstate_id) {
		this.atsstate_id = atsstate_id;
	}
	public String getAtsstate_name() {
		return atsstate_name;
	}
	public void setAtsstate_name(String atsstate_name) {
		this.atsstate_name = atsstate_name;
	}
	@Override
	public String toString() {
		return "Atsstate [atsstate_id=" + atsstate_id + ", atsstate_name=" + atsstate_name + "]";
	}
	
	
}

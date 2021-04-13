package com.hbsi.pojo;

public class Atstype {

	private Integer atstype_id;
	private String atstype_name;
	private String atstype_des;
	public Integer getAtstype_id() {
		return atstype_id;
	}
	public void setAtstype_id(Integer atstype_id) {
		this.atstype_id = atstype_id;
	}
	public String getAtstype_name() {
		return atstype_name;
	}
	public void setAtstype_name(String atstype_name) {
		this.atstype_name = atstype_name;
	}
	public String getAtstype_des() {
		return atstype_des;
	}
	public void setAtstype_des(String atstype_des) {
		this.atstype_des = atstype_des;
	}
	@Override
	public String toString() {
		return "Atstype [atstype_id=" + atstype_id + ", atstype_name=" + atstype_name + ", atstype_des=" + atstype_des
				+ "]";
	}
}

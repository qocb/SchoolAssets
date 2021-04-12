package com.hbsi.pojo;

public class Dep {

	private Integer dep_id;//部门id
	private String dep_name;//部门名称
	private String dep_des;//部门描述
	public Integer getDep_id() {
		return dep_id;
	}
	public void setDep_id(Integer dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public String getDep_des() {
		return dep_des;
	}
	public void setDep_des(String dep_des) {
		this.dep_des = dep_des;
	}
	@Override
	public String toString() {
		return "Dep [dep_id=" + dep_id + ", dep_name=" + dep_name + ", dep_des=" + dep_des + "]";
	}
}

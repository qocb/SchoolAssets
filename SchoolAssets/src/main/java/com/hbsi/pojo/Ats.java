package com.hbsi.pojo;

/**
 * @desc   资产管理的实体类
 * @author dell
 *@time 2021-04-12
 */
public class Ats {

	private Integer ats_id;
	private String ats_name;
	private Double ats_money;
	private String ats_date;
	private Emp emp;
	private Atstype atstype;
	private Atsstate atsstate;
	public Integer getAts_id() {
		return ats_id;
	}
	public void setAts_id(Integer ats_id) {
		this.ats_id = ats_id;
	}
	public String getAts_name() {
		return ats_name;
	}
	public void setAts_name(String ats_name) {
		this.ats_name = ats_name;
	}
	public Double getAts_money() {
		return ats_money;
	}
	public void setAts_money(Double ats_money) {
		this.ats_money = ats_money;
	}
	public String getAts_date() {
		return ats_date;
	}
	public void setAts_date(String ats_date) {
		this.ats_date = ats_date;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Atstype getAtstype() {
		return atstype;
	}
	public void setAtstype(Atstype atstype) {
		this.atstype = atstype;
	}
	public Atsstate getAtsstate() {
		return atsstate;
	}
	public void setAtsstate(Atsstate atsstate) {
		this.atsstate = atsstate;
	}
	@Override
	public String toString() {
		return "Ats [ats_id=" + ats_id + ", ats_name=" + ats_name + ", ats_money=" + ats_money + ", ats_date="
				+ ats_date + ", emp=" + emp + ", atstype=" + atstype + ", atsstate=" + atsstate + "]";
	}
	
}

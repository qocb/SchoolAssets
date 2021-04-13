package com.hbsi.pojo;

public class Atsrepair {

	private Integer atsrepair_id;
	private Ats ats;
	private String atsrepair_date;
	private String atsrepair_text;
	private Double atsrepair_money;
	private String atsrepair_des;
	public Integer getAtsrepair_id() {
		return atsrepair_id;
	}
	public void setAtsrepair_id(Integer atsrepair_id) {
		this.atsrepair_id = atsrepair_id;
	}
	public Ats getAts() {
		return ats;
	}
	public void setAts(Ats ats) {
		this.ats = ats;
	}
	public String getAtsrepair_date() {
		return atsrepair_date;
	}
	public void setAtsrepair_date(String atsrepair_date) {
		this.atsrepair_date = atsrepair_date;
	}
	public String getAtsrepair_text() {
		return atsrepair_text;
	}
	public void setAtsrepair_text(String atsrepair_text) {
		this.atsrepair_text = atsrepair_text;
	}
	public Double getAtsrepair_money() {
		return atsrepair_money;
	}
	public void setAtsrepair_money(Double atsrepair_money) {
		this.atsrepair_money = atsrepair_money;
	}
	public String getAtsrepair_des() {
		return atsrepair_des;
	}
	public void setAtsrepair_des(String atsrepair_des) {
		this.atsrepair_des = atsrepair_des;
	}
	@Override
	public String toString() {
		return "Atsrepair [atsrepair_id=" + atsrepair_id + ", ats=" + ats + ", atsrepair_date=" + atsrepair_date
				+ ", atsrepair_text=" + atsrepair_text + ", atsrepair_money=" + atsrepair_money + ", atsrepair_des="
				+ atsrepair_des + "]";
	}
}

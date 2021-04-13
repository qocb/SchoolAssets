package com.hbsi.pojo;

public class Scrap {

	private Integer scrap_id;
	private Ats ats;
	private String scrap_date;
	private String scrap_des;
	public Integer getScrap_id() {
		return scrap_id;
	}
	public void setScrap_id(Integer scrap_id) {
		this.scrap_id = scrap_id;
	}
	public Ats getAts() {
		return ats;
	}
	public void setAts(Ats ats) {
		this.ats = ats;
	}
	public String getScrap_date() {
		return scrap_date;
	}
	public void setScrap_date(String scrap_date) {
		this.scrap_date = scrap_date;
	}
	public String getScrap_des() {
		return scrap_des;
	}
	public void setScrap_des(String scrap_des) {
		this.scrap_des = scrap_des;
	}
	@Override
	public String toString() {
		return "Scrap [scrap_id=" + scrap_id + ", ats=" + ats + ", scrap_date=" + scrap_date + ", scrap_des="
				+ scrap_des + "]";
	}
	
}

package com.hbsi.dao.scrap;

import org.apache.ibatis.annotations.Insert;

import com.hbsi.pojo.Scrap;

public interface ScrapDao {

	@Insert("INSERT INTO scrap (scrap_id,ats_id,scrap_date,scrap_des) VALUES (0,#{ats.ats_id},#{scrap_date},#{scrap_des})")
	public void addScarp(Scrap scrap);
}

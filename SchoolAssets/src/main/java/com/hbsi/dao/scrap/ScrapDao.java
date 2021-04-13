package com.hbsi.dao.scrap;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hbsi.pojo.Ats;
import com.hbsi.pojo.Scrap;

public interface ScrapDao {

	@Insert("INSERT INTO scrap (scrap_id,ats_id,scrap_date,scrap_des) VALUES (0,#{ats.ats_id},#{scrap_date},#{scrap_des})")
	public void addScarp(Scrap scrap);

	@Select("SELECT scrap.*,ats.ats_name FROM scrap LEFT JOIN ats ON ats.ats_id = scrap.ats_id")
	@Results({
		@Result(id = true,property = "scrap_id" ,column = "scrap_id"),
		@Result(property = "scrap_date",column = "scrap_date"),
		@Result(property = "scrap_des",column = "scrap_des"),
		@Result(property = "ats",column = "ats_id",javaType = Ats.class,many = @Many(select = "com.hbsi.dao.ats.AtsDao.queryAtsById")),
	})
	public List<Scrap> queryAllScrap();
}

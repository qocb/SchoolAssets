package com.hbsi.dao.atsrepair;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hbsi.pojo.Ats;
import com.hbsi.pojo.Atsrepair;

public interface AtsrepairDao {

	@Select("SELECT atsrepair.*,ats.ats_name FROM atsrepair LEFT JOIN ats ON atsrepair.ats_id = ats.ats_id")
	@Results({
		@Result(id = true,property = "atsrepair_id",column = "atsrepair_id"),
		@Result(property = "atsrepair_date",column = "atsrepair_date"),
		@Result(property = "atsrepair_text",column = "atsrepair_text"),
		@Result(property = "atsrepair_money",column = "atsrepair_money"),
		@Result(property = "atsrepair_des",column = "atsrepair_des"),
		@Result(property = "ats",column = "ats_id",javaType= Ats.class,many = @Many(select = "com.hbsi.dao.ats.AtsDao.queryAtsById"))
	})
	public List<Atsrepair> queryAll();

	
	@Insert("INSERT INTO atsrepair (atsrepair_id,ats_id,atsrepair_date,atsrepair_text,atsrepair_money,atsrepair_des) VALUES (0,#{ats.ats_id},#{atsrepair_date},#{atsrepair_text},#{atsrepair_money},#{atsrepair_des})")
	public void addrepair(Atsrepair atsrepair);
	
	
	
}

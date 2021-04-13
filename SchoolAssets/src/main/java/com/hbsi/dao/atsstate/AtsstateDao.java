package com.hbsi.dao.atsstate;

import org.apache.ibatis.annotations.Select;

import com.hbsi.pojo.Atsstate;

public interface AtsstateDao {

	@Select("SELECT * FROM atsstate WHERE atsstate_id=#{atsstate_id} ")
	public Atsstate queryAtsstateByID(Integer atsstate_id);
}

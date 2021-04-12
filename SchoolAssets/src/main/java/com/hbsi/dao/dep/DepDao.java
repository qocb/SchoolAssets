package com.hbsi.dao.dep;

import org.apache.ibatis.annotations.Select;

import com.hbsi.pojo.Dep;

public interface DepDao {

	@Select("select * from dep where dep_id = #{dep_id}")
	public Dep queryDepById(Integer dep_id);
}

package com.hbsi.dao.atstype;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hbsi.pojo.Atstype;
import com.hbsi.pojo.Dep;

public interface AtstypeDao {

	@Select("SELECT * FROM atstype")
	public List<Atstype> queryAtstypeAll();
	
	@Select("SELECT * FROM atstype WHERE atstype_id = #{atstype_id}")
	public Atstype queryAtstypeById(Integer id);
	
	@Insert("INSERT INTO atstype (atstype_id,atstype_name,atstype_des) VALUES(0,#{atstype_name},#{atstype_des})")
	public void insertStstype(Atstype atstype);
	
	
	/**
	 * @desc  删除
	 * @param id
	 */
	@Delete("DELETE FROM atstype WHERE atstype_id = #{atstype_id};")
	public void deleteAtstypeById(Integer id);
	
	/**
	 * @desc 修改一条
	 * @param atstype
	 */
	@Update("UPDATE atstype SET atstype_name = #{atstype_name} ,atstype_des = #{atstype_des} WHERE atstype_id = #{atstype_id}")
	public void eiditAtstype(Atstype atstype);
}

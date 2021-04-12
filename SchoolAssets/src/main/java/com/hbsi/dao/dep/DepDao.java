package com.hbsi.dao.dep;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hbsi.pojo.Dep;

public interface DepDao {

	@Select("select * from dep where dep_id = #{dep_id}")
	public Dep queryDepById(Integer dep_id);

	@Select("SELECT * FROM dep")
	public List<Dep> queryAllDep();

	@Insert("INSERT INTO dep (dep_id,dep_name,dep_des) VALUES(0,#{dep_name},#{dep_des})")
	public void addDep(Dep dep);

	@Delete("DELETE FROM dep WHERE dep_id = #{dep_id}")
	public void delDepByID(Integer dep_id);

	@Select("SELECT * FROM dep WHERE dep.dep_id = #{dep_id}")
	public Dep getDepByID(Integer dep_id);

	@Update("UPDATE dep SET dep_name = #{dep_name} ,dep_des = #{dep_des} WHERE dep_id = #{dep_id}")
	public void eiditDepByID(Dep dep);
}

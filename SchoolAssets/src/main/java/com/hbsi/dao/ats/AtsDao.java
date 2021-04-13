package com.hbsi.dao.ats;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hbsi.pojo.Ats;
import com.hbsi.pojo.Atsstate;
import com.hbsi.pojo.Atstype;
import com.hbsi.pojo.Dep;
import com.hbsi.pojo.Emp;

/**
 * @desc   资产管理的Dao
 * @author dell
 * @time   2021-04-12
 */
public interface AtsDao {
	
	/**
	 * @desc  查询指定资产
	 * @param id
	 * @return
	 */
	@Select("SELECT ats.*,emp.emp_name,atstype.atstype_name,atsstate.atsstate_name FROM ats LEFT JOIN  emp ON emp.emp_id = ats.emp_id LEFT JOIN atstype ON atstype.atstype_id = ats.atstype_id LEFT JOIN atsstate ON atsstate.atsstate_id = ats.atsstate_id WHERE ats_id = #{ats_id}")
	@Results({
		@Result(id = true,column = "ats_id",property = "ats_id"),
		@Result(property = "ats_name",column = "ats_name"),
		@Result(property = "ats_money",column = "ats_money"),
		@Result(property = "ats_date",column = "ats_date"),
		@Result(property = "emp",column = "emp_id",javaType=Emp.class,many = @Many(select = "com.hbsi.dao.emp.EmpDao.queryEmpByID")),
		@Result(property = "atstype",column = "atstype_id",javaType=Atstype.class,many = @Many(select = "com.hbsi.dao.atstype.AtstypeDao.queryAtstypeById")),
		@Result(property = "atsstate",column = "atsstate_id",javaType=Atsstate.class,many = @Many(select = "com.hbsi.dao.atsstate.AtsstateDao.queryAtsstateByID"))
	})
	public Ats queryAtsById(Integer ats_id);
	
	/**
	 * @desc  增加
	 * @param ats
	 */
	@Insert("INSERT INTO ats (ats_id,ats_name,ats_money,ats_date,emp_id,atstype_id,atsstate_id) VALUES(0,#{ats_name},#{ats_money},#{ats_date},#{emp.emp_id},#{atstype.atstype_id},#{atsstate.atsstate_id})")
	public void insertAts(Ats ats);
	
	
	
	/**
	 * @desc 维修
	 * @param id
	 */
	@Update("UPDATE ats SET atsstate_id = 2 WHERE ats_id = #{ats_id}")
	public void updateAtsByWX(Integer id);
	
	
	
	/**
	 * @desc  修改指定资产类别
	 */
	@Update("UPDATE ats SET ats_name = #{ats_name},ats_money = #{ats_money},ats_date = #{ats_date},emp_id = 2,atstype_id = #{atstype_id} WHERE ats_id = #{ats_id}")
	public void eiditAts(Ats ats);
	
	
	
	
	

	@Select("SELECT ats.*,emp.emp_name,atstype.atstype_name,atsstate.atsstate_name FROM ats LEFT JOIN  emp ON emp.emp_id = ats.emp_id LEFT JOIN atstype ON atstype.atstype_id = ats.atstype_id LEFT JOIN atsstate ON atsstate.atsstate_id = ats.atsstate_id")
	@Results({
		@Result(id = true,column = "ats_id",property = "ats_id"),
		@Result(property = "ats_name",column = "ats_name"),
		@Result(property = "ats_money",column = "ats_money"),
		@Result(property = "ats_date",column = "ats_date"),
		@Result(property = "emp",column = "emp_id",javaType=Emp.class,many = @Many(select = "com.hbsi.dao.emp.EmpDao.queryEmpByID")),
		@Result(property = "atstype",column = "atstype_id",javaType=Atstype.class,many = @Many(select = "com.hbsi.dao.atstype.AtstypeDao.queryAtstypeById")),
		@Result(property = "atsstate",column = "atsstate_id",javaType=Atsstate.class,many = @Many(select = "com.hbsi.dao.atsstate.AtsstateDao.queryAtsstateByID"))
	})
	public List<Ats> queryAllAts();

	@Update("UPDATE ats SET ats_name = #{ats_name},ats_money = #{ats_money},ats_date = #{ats_date},emp_id = #{emp.emp_id},atstype_id = #{atstype.atstype_id} WHERE ats_id = #{ats_id}")
	public void eiditAtsByID(Ats ats);

	@Update("UPDATE ats SET atsstate_id = 2 WHERE ats_id = #{ats_id}")
	public void setAtsstateByID(Integer ats_id);

	@Update("UPDATE ats SET atsstate_id = 3 WHERE ats_id = #{ats_id}")
	public void scrapAtsById(Integer ats_id);

	@Select("SELECT ats.*,emp.emp_name,atstype.atstype_name,atsstate.atsstate_name FROM ats LEFT JOIN  emp ON emp.emp_id = ats.emp_id LEFT JOIN atstype ON atstype.atstype_id = ats.atstype_id LEFT JOIN atsstate ON atsstate.atsstate_id = ats.atsstate_id WHERE ats.atsstate_id = 1")
	@Results({
		@Result(id = true,column = "ats_id",property = "ats_id"),
		@Result(property = "ats_name",column = "ats_name"),
		@Result(property = "ats_money",column = "ats_money"),
		@Result(property = "ats_date",column = "ats_date"),
		@Result(property = "emp",column = "emp_id",javaType=Emp.class,many = @Many(select = "com.hbsi.dao.emp.EmpDao.queryEmpByID")),
		@Result(property = "atstype",column = "atstype_id",javaType=Atstype.class,many = @Many(select = "com.hbsi.dao.atstype.AtstypeDao.queryAtstypeById")),
		@Result(property = "atsstate",column = "atsstate_id",javaType=Atsstate.class,many = @Many(select = "com.hbsi.dao.atsstate.AtsstateDao.queryAtsstateByID"))
	})
	public List<Ats> normalAllats();

	@Select("SELECT ats.*,emp.emp_name,atstype.atstype_name,atsstate.atsstate_name FROM ats LEFT JOIN  emp ON emp.emp_id = ats.emp_id LEFT JOIN atstype ON atstype.atstype_id = ats.atstype_id LEFT JOIN atsstate ON atsstate.atsstate_id = ats.atsstate_id WHERE ats.atsstate_id IN(1,2)")
	@Results({
		@Result(id = true,column = "ats_id",property = "ats_id"),
		@Result(property = "ats_name",column = "ats_name"),
		@Result(property = "ats_money",column = "ats_money"),
		@Result(property = "ats_date",column = "ats_date"),
		@Result(property = "emp",column = "emp_id",javaType=Emp.class,many = @Many(select = "com.hbsi.dao.emp.EmpDao.queryEmpByID")),
		@Result(property = "atstype",column = "atstype_id",javaType=Atstype.class,many = @Many(select = "com.hbsi.dao.atstype.AtstypeDao.queryAtstypeById")),
		@Result(property = "atsstate",column = "atsstate_id",javaType=Atsstate.class,many = @Many(select = "com.hbsi.dao.atsstate.AtsstateDao.queryAtsstateByID"))
	})
	public List<Ats> notscrapAtsAll();

	@Select("SELECT ats.*,emp.emp_name,atstype.atstype_name,atsstate.atsstate_name FROM ats LEFT JOIN  emp ON emp.emp_id = ats.emp_id LEFT JOIN atstype ON atstype.atstype_id = ats.atstype_id LEFT JOIN atsstate ON atsstate.atsstate_id = ats.atsstate_id WHERE ats.atsstate_id = 2")
	@Results({
		@Result(id = true,column = "ats_id",property = "ats_id"),
		@Result(property = "ats_name",column = "ats_name"),
		@Result(property = "ats_money",column = "ats_money"),
		@Result(property = "ats_date",column = "ats_date"),
		@Result(property = "emp",column = "emp_id",javaType=Emp.class,many = @Many(select = "com.hbsi.dao.emp.EmpDao.queryEmpByID")),
		@Result(property = "atstype",column = "atstype_id",javaType=Atstype.class,many = @Many(select = "com.hbsi.dao.atstype.AtstypeDao.queryAtstypeById")),
		@Result(property = "atsstate",column = "atsstate_id",javaType=Atsstate.class,many = @Many(select = "com.hbsi.dao.atsstate.AtsstateDao.queryAtsstateByID"))
	})
	public List<Ats> needrepairAll();

	@Update("UPDATE ats SET atsstate_id = 1 WHERE ats_id = #{ats_id}")
	public void repairAtsByID(Integer ats_id);
	
}

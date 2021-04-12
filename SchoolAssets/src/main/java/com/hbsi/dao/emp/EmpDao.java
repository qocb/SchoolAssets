package com.hbsi.dao.emp;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hbsi.pojo.Dep;
import com.hbsi.pojo.Emp;

public interface EmpDao {

	@Select("select * from emp")
	@Results({
		@Result(id = true,property = "emp_id",column = "emp_id"),
		@Result(property = "emp_name",column = "emp_name"),
		@Result(property = "emp_age",column = "emp_age"),
		@Result(property = "emp_sex",column = "emp_sex"),
		@Result(property = "emp_address",column = "emp_address"),
		@Result(property = "emp_phone",column = "emp_phone"),
		@Result(column = "dep_id",property = "dep",javaType = Dep.class,many = @Many(select = "com.hbsi.dao.dep.DepDao.queryDepById"))
	})
	public List<Emp> queryAllEmp();

	@Select("select * from emp where emp_id = #{emp_id}")
	@Results({
		@Result(id = true,property = "emp_id",column = "emp_id"),
		@Result(property = "emp_name",column = "emp_name"),
		@Result(property = "emp_age",column = "emp_age"),
		@Result(property = "emp_sex",column = "emp_sex"),
		@Result(property = "emp_address",column = "emp_address"),
		@Result(property = "emp_phone",column = "emp_phone"),
		@Result(column = "dep_id",property = "dep",javaType = Dep.class,many = @Many(select = "com.hbsi.dao.dep.DepDao.queryDepById"))
	})
	public Emp queryEmpByID(Integer emp_id);

	@Select("SELECT emp.*,dep.dep_name FROM emp LEFT JOIN dep ON emp.dep_id = dep.dep_id WHERE emp_name LIKE #{emp_name}")
	@Results({
		@Result(id = true,property = "emp_id",column = "emp_id"),
		@Result(property = "emp_name",column = "emp_name"),
		@Result(property = "emp_age",column = "emp_age"),
		@Result(property = "emp_sex",column = "emp_sex"),
		@Result(property = "emp_address",column = "emp_address"),
		@Result(property = "emp_phone",column = "emp_phone"),
		@Result(column = "dep_id",property = "dep",javaType = Dep.class,many = @Many(select = "com.hbsi.dao.dep.DepDao.queryDepById"))
	})
	public List<Emp> queryEmpByName(String emp_name);

	@Delete("DELETE FROM emp WHERE emp_id = #{emp_id}")
	public void delEmpByID(Integer emp_id);

	
	@Update("UPDATE emp SET emp_name = #{emp_name},emp_age = #{emp_age},emp_sex = #{emp_sex},dep_id = #{dep.dep_id},emp_address = #{emp_address},emp_phone = #{emp_phone} WHERE emp_id = #{emp_id}")
	public void eiditEmp(Emp emp);

	@Insert("INSERT INTO `emp` (emp_id,emp_name,emp_age,emp_sex,dep_id,emp_address,emp_phone) VALUES (0,#{emp_name},#{emp_age},#{emp_sex},#{dep.dep_id},#{emp_address},#{emp_phone})")
	public void addEmp(Emp emp);

	@Update("UPDATE emp SET dep_id = 5 WHERE dep_id = #{dep_id}")
	public void updateEmpByDep_id(Integer dep_id);
}

package com.hbsi.service.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hbsi.dao.emp.EmpDao;
import com.hbsi.pojo.Emp;

@Service("empService")
public class EmpService {

	@Autowired
	EmpDao empDao;
	/**
	 * @desc  分页查询全部员工
	 * @param page
	 * @param size
	 * @return
	 */
	public List<Emp> queryAllEmp(Integer page, Integer size) {
		PageHelper.startPage(page, size);
		return empDao.queryAllEmp();
	}

	public Emp queryEmpByID(Integer emp_id) {
		return empDao.queryEmpByID(emp_id);
	}

	public List<Emp> queryEmpByName(String emp_name, Integer page, Integer size) {
		PageHelper.startPage(page, size);
		return empDao.queryEmpByName(emp_name);
	}

	public void delEmpByID(Integer emp_id) {
		empDao.delEmpByID(emp_id);
	}

	public void eiditEmp(Emp emp) {
		empDao.eiditEmp(emp);
	}

	public void addEmp(Emp emp) {
		empDao.addEmp(emp);
	}

	public void updateEmpByDep_id(Integer dep_id) {
		empDao.updateEmpByDep_id(dep_id);
	}
	
	
}

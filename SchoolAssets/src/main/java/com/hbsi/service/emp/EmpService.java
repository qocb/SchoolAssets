package com.hbsi.service.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbsi.dao.emp.EmpDao;
import com.hbsi.pojo.Emp;

@Service("empService")
public class EmpService {

	@Autowired
	EmpDao empDao;

	public List<Emp> queryAllEmp() {
		return empDao.queryAllEmp();
	}

	public Emp queryEmpByID(Integer emp_id) {
		return empDao.queryEmpByID(emp_id);
	}

	public List<Emp> queryEmpByName(String emp_name) {
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
	
	
}

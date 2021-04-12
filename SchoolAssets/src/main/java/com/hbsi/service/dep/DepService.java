package com.hbsi.service.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbsi.dao.dep.DepDao;
import com.hbsi.pojo.Dep;

@Service("depService")
public class DepService {

	@Autowired
	DepDao depDao;
	
	public List<Dep> queryAllDep() {
		return depDao.queryAllDep();
	}

	public void addDep(Dep dep) {
		depDao.addDep(dep);
	}

	public void delDepByID(Integer dep_id) {
		depDao.delDepByID(dep_id);
	}

	public Dep getDepByID(Integer dep_id) {
		return depDao.getDepByID(dep_id);
	}

	public void eiditDepByID(Dep dep) {
		depDao.eiditDepByID(dep);
	}

}

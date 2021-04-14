package com.hbsi.service.dep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hbsi.dao.dep.DepDao;
import com.hbsi.pojo.Dep;

@Service("depService")
public class DepService {

	@Autowired
	DepDao depDao;
	/**
	 * @desc  部门分页查询
	 * @return
	 */
	public List<Dep> queryAllDep(Integer page,Integer size) {
		PageHelper.startPage(page,size);
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

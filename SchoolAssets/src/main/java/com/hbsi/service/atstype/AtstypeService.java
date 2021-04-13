package com.hbsi.service.atstype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbsi.dao.atstype.AtstypeDao;
import com.hbsi.pojo.Atstype;

@Service("atstypeService")
public class AtstypeService {

	@Autowired
	AtstypeDao atstypeDao;
	
	/**
	 * @desc 查找全部
	 * @return
	 */
	public List<Atstype> queryAtstypeAll(){
		return atstypeDao.queryAtstypeAll();
	}
	
	/**
	 * @desc 查找一个
	 * @param id
	 * @return
	 */
	public Atstype queryAtstypeById(Integer id){
		return atstypeDao.queryAtstypeById(id);
	}
	
	/**
	 * @desc  删除
	 * @param id
	 */
	public void deleteAtstypeById(Integer id){
		 
	}
	
	/**
	 * @desc  修改
	 * @param atstype
	 */
	public void eiditAtstype(Atstype atstype){
		atstypeDao.eiditAtstype(atstype);
	}
	
	/**
	 * @desc  添加
	 */
	public void addAtstype(Atstype atstype){
		atstypeDao.insertStstype(atstype);
		
	}
}

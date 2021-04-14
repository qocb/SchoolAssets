package com.hbsi.service.ats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hbsi.dao.ats.AtsDao;
import com.hbsi.pojo.Ats;

@Service("atsService")
public class AtsService {

	@Autowired
	AtsDao atsDao;
	/**
	 * @desc  查询一个
	 * @param id
	 * @return
	 */
	public Ats queryAtsById(Integer ats_id){
		return atsDao.queryAtsById(ats_id);
	}
	
	/**
	 * @desc  添加
	 * @param ats
	 */
	public void insertAts(Ats ats){
		atsDao.insertAts(ats);
	}
	
	/**
	 * @desc  维修
	 * @param id
	 */
	public void updateAtsByWX(Integer id){
		atsDao.updateAtsByWX(id);
	}
	
	/**
	 * @desc  修改指定资产类别
	 * @param ats
	 */
	public void eiditAts(Ats ats){
		atsDao.eiditAts(ats);
	}
	
	/**
	 * @desc  报废资产(未将改报废记录添加至报废记录表中)
	 * @param id
	 */
	
	/**
	 * @desc  查询全部
	 * @param id
	 */
	public List<Ats> queryAllAts(Integer page,Integer size) {
		 //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
		PageHelper.startPage(page, size);
		return atsDao.queryAllAts();
	}

	public void eiditAtsByID(Ats ats) {
		atsDao.eiditAtsByID(ats);
	}

	public void setAtsstateByID(Integer ats_id) {
		atsDao.setAtsstateByID(ats_id);
	}

	public void scrapAtsById(Integer ats_id) {
		atsDao.scrapAtsById(ats_id);
	}

	public List<Ats> normalAllats(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return atsDao.normalAllats();
	}

	public List<Ats> notscrapAtsAll(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return atsDao.notscrapAtsAll();
	}

	public List<Ats> needrepairAtsAll(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return atsDao.needrepairAll();
	}

	public void repairAtsByID(Integer ats_id) {
		atsDao.repairAtsByID(ats_id);
	}
}

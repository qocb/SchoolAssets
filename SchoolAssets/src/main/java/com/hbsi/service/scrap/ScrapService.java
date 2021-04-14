package com.hbsi.service.scrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hbsi.dao.scrap.ScrapDao;
import com.hbsi.pojo.Scrap;
@Service("scrapService")
public class ScrapService {

	@Autowired
	ScrapDao scrapDao;
	
	public void addScarp(Scrap scrap) {
		scrapDao.addScarp(scrap);
	}

	public List<Scrap> queryAllScrap(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return scrapDao.queryAllScrap();
	} 
}

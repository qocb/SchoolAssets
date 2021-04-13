package com.hbsi.service.atsrepair;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbsi.dao.atsrepair.AtsrepairDao;
import com.hbsi.pojo.Atsrepair;

@Service("atsrepairService")
public class AtsrepairService {
	
	@Autowired
	AtsrepairDao atsrepairDao;
	
	/**
	 * @desc  查询全部
	 * @return
	 */
	public List<Atsrepair> queryAll(){
		return atsrepairDao.queryAll();
	}

	public void addrepair(Atsrepair atsrepair) {
		atsrepairDao.addrepair(atsrepair);
	}
	

}

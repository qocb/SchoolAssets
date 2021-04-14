package com.hbsi.service.root;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbsi.dao.root.RootDao;

@Service("rootService")
public class RootService {

	@Autowired
	RootDao rootDao;
	
	
	public List<Map<String, Object>> login(String root_uname, String root_pwd) {
		return rootDao.queryrootBypwdAndUname(root_uname,root_pwd);
	}


	public void setTokenByUnameAndPWD(String root_uname, String root_pwd, String token) {
		rootDao.setTokenByUnameAndPWD(root_uname,root_pwd,token);
	}

	
	
	
}

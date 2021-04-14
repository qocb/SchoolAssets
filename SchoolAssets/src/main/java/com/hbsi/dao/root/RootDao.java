package com.hbsi.dao.root;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RootDao {

	@Select("SELECT * FROM `root` WHERE root_pwd = #{1} AND root_uname = #{0}")
	List<Map<String, Object>> queryrootBypwdAndUname(String root_uname, String root_pwd);

	@Update("UPDATE `root` SET token = #{2} WHERE root_pwd = #{1} AND root_uname = #{0}")
	void setTokenByUnameAndPWD(String root_uname, String root_pwd, String token);
			
	@Select("SELECT * FROM `root` WHERE token = #{token}")
	Map<String, String> queryrootBtoken(String token);
}

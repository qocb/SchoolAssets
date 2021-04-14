package com.hbsi.controller.root;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbsi.service.root.RootService;
import com.hbsi.utils.Md5Utils;

@Controller("rootController")
@RequestMapping("/root")
@ResponseBody
public class RootController {

	@Autowired
	RootService rootService;
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Map<String, Object> login(String root_uname,String root_pwd,HttpSession session,HttpServletResponse response) {
		List<Map<String, Object>> root = rootService.login(root_uname,root_pwd);
		Map<String, Object> map=new HashMap<String, Object>();
		if (root != null && root.size() > 0) {
			
			map.put("code", 200);
			map.put("msg", "登录成功");
			
			
			//生成toekn
			String sessionid = session.getId();
			System.out.println(sessionid);
			String str = sessionid + root_pwd +root_uname;
			String token = Md5Utils.makeMd5(str);
			//将token存入到数据库中
			rootService.setTokenByUnameAndPWD(root_uname,root_pwd,token);
			//创建cookie
			Cookie cookie_token = new Cookie("token", token);
			Cookie cookie_uname = new Cookie("root_uname", root_uname);
			Cookie cookie_pwd = new Cookie("root_pwd", root_pwd);
			//设置cookie过期时间为一天
//			cookie_token.setMaxAge((24*60*60));
//			cookie_uname.setMaxAge((24*60*60));
//			cookie_pwd.setMaxAge((24*60*60));
			//一定要设置path不然不好使
			cookie_token.setPath("/");
			cookie_uname.setPath("/");
			cookie_pwd.setPath("/");
			response.addCookie(cookie_token);
			response.addCookie(cookie_uname);
			response.addCookie(cookie_pwd);
		}
		else {
			map.put("code", -1);
			map.put("msg", "用户名或密码错误");
		}
		return map;
	}
	
}

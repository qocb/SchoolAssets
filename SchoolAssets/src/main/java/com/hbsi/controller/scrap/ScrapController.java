package com.hbsi.controller.scrap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbsi.pojo.Scrap;
import com.hbsi.service.scrap.ScrapService;

@Controller("scrapController")
@RequestMapping("/scrap")
public class ScrapController {
	
	@Autowired
	ScrapService scrapService;

	
	/**
	 * 查询所有资产报废记录
	 * @return
	 */
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAllScrap() {
		List<Scrap> scraps = scrapService.queryAllScrap();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", scraps);
		return map;
	}
}

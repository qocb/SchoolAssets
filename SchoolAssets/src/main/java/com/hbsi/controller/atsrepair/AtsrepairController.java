package com.hbsi.controller.atsrepair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbsi.pojo.Atsrepair;
import com.hbsi.service.atsrepair.AtsrepairService;

@Controller("atsrepairController")
@RequestMapping("/atsrepair")
public class AtsrepairController {

	@Autowired
	AtsrepairService atsrepairService;
	
	/**
	 * @desc  查询全部
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAll(){
		List<Atsrepair> list=atsrepairService.queryAll();
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("code", 200);
		map.put("msg", "添加成功");
		map.put("data", list);
		return map;
	}

}

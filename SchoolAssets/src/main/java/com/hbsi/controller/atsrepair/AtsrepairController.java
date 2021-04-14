package com.hbsi.controller.atsrepair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
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
	@RequestMapping(value = "/all/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAll(@PathVariable(value = "page") Integer page,@PathVariable(value = "size") Integer size){
		List<Atsrepair> list=atsrepairService.queryAll(page,size);
		PageInfo pageInfo=new PageInfo(list);
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", pageInfo);
		return map;
	}

}

package com.hbsi.controller.ats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbsi.pojo.Ats;
import com.hbsi.pojo.Atsrepair;
import com.hbsi.pojo.Emp;
import com.hbsi.pojo.Scrap;
import com.hbsi.service.ats.AtsService;
import com.hbsi.service.atsrepair.AtsrepairService;
import com.hbsi.service.scrap.ScrapService;

@Controller("atsController")
@RequestMapping("/ats")
public class AtsController {

	@Autowired
	AtsService atsService;
	@Autowired
	ScrapService scrapService;
	@Autowired
	AtsrepairService atsrepairService;
	
	/**
	 * @desc  添加
	 * @param ats
	 * @return
	 */
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(Ats ats){
		System.out.println(ats);
		atsService.insertAts(ats);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "添加成功");
		return map;
	}

	/**
	 * 查询全部
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAllAts(){
		
		List<Ats> atss = atsService.queryAllAts();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", atss);
		return map;
	}
	
	/**
	 * 查询指定资产
	 * @param ats_id
	 * @return
	 */
	@RequestMapping(value = "{ats_id}",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAtsByID(@PathVariable("ats_id")Integer ats_id) {
		System.out.println(ats_id);
		Ats ats = atsService.queryAtsById(ats_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", ats);
		return map;
	}
	
	@RequestMapping(value ="/eidit", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> eiditAtsByID(Ats ats){
		System.out.println(ats);
		atsService.eiditAtsByID(ats);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "修改成功");
		return map;
	}
	
	
	
	/**
	 * @desc  设置资产为维修中
	 * @param ats_id
	 * @return
	 */
	@RequestMapping(value = "{ats_id}",method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> setAtsstateByID(@PathVariable("ats_id")Integer ats_id){
		
		atsService.setAtsstateByID(ats_id);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "修改成功");
		return map;
	}
	
	/**
	 * 设置资产为报废
	 * @param ats_id
	 * @param scrap_date
	 * @param scrap_des
	 * @return
	 */
	@RequestMapping(value ="/scrap", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> scrapAts(Integer ats_id,String scrap_date,String scrap_des){
		
		Scrap scrap = new Scrap();
		Ats ats = new Ats();
		ats.setAts_id(ats_id);
		scrap.setAts(ats);
		scrap.setScrap_date(scrap_date);
		scrap.setScrap_des(scrap_des);
		
		scrapService.addScarp(scrap);
		atsService.scrapAtsById(ats_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "修改成功");
		return map;
	}
	
	/**
	 * 查询所有正常资产
	 * @return
	 */
	@RequestMapping(value ="/normal", method = RequestMethod.GET)
	@ResponseBody
	public  Map<String, Object> normalAtsAll(){
		
		List<Ats> atss = atsService.normalAllats();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", atss);
		return map;
	}
	/**
	 * 查询所有没有报废的资产
	 * @return
	 */
	@RequestMapping(value ="/notscrap", method = RequestMethod.GET)
	@ResponseBody
	public  Map<String, Object> notscrap(){
		
		List<Ats> atss = atsService.notscrapAtsAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", atss);
		return map;
	}
	
	/**
	 * 查询所有需要维修的资产
	 * @return
	 */
	@RequestMapping(value ="/needrepair", method = RequestMethod.GET)
	@ResponseBody
	public  Map<String, Object> needrepair(){
		
		List<Ats> atss = atsService.needrepairAtsAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", atss);
		return map;
	}
	
	/**
	 * 维修指定资产
	 */
	@RequestMapping(value = "/repair",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> repairAts(Atsrepair atsrepair){
		
		
		atsService.repairAtsByID(atsrepair.getAts().getAts_id());
		atsrepairService.addrepair(atsrepair);
		
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "修改成功");
		return map;
	}
	
}

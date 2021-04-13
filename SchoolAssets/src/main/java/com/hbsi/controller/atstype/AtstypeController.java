package com.hbsi.controller.atstype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbsi.pojo.Atstype;
import com.hbsi.pojo.Emp;
import com.hbsi.service.atstype.AtstypeService;

/**
 * @desc 资产类别管理
 * @author 张鹏
 * @time 2021-4-12
 */
@Controller("AtstypeController")
@RequestMapping("/atstype")
public class AtstypeController {

	@Autowired
	AtstypeService atstypeService;
	
	/**
	 * @desc  查找全部
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Map getAtstypeAll(){
		List<Atstype> list=atstypeService.queryAtstypeAll();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", list);
		return map;
	}
	
	
	/**
	 * @desc  查找单个
	 * @param atstype_id
	 * @return
	 */
	@RequestMapping(value = "{atstype_id}",method = RequestMethod.GET)
	@ResponseBody
	public Atstype getAtstypeOne(@PathVariable(value = "atstype_id") Integer atstype_id) {
		System.out.println(atstype_id);
		Atstype map = atstypeService.queryAtstypeById(atstype_id);
		return map;
	}
	
	/**z
	 * @desc  修改
	 * @param atstype
	 * @return
	 */
	@RequestMapping(value = "/eidit", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> eiditEmp(Atstype atstype) {
		
		System.out.println(atstype);
		
		atstypeService.eiditAtstype(atstype);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "修改成功");
		return map;
	}
	
	/**
	 * @desc  删除
	 * @param atstype_id
	 * @return
	 */
	@RequestMapping(value = "{atstype_id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> delEmpByID(@PathVariable(value = "atstype_id")Integer atstype_id) {
		System.out.println(atstype_id);
		atstypeService.deleteAtstypeById(atstype_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "删除成功");
		return map;
	}
	
	
	/**
	 * @desc  添加
	 * @param atstype
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addEmp(Atstype atstype) {
		System.out.println(atstype);
		atstypeService.addAtstype(atstype);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "添加成功");
		return map;
	}
	
}

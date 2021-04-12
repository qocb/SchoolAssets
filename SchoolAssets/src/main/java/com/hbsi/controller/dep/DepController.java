package com.hbsi.controller.dep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbsi.pojo.Dep;
import com.hbsi.service.dep.DepService;
import com.hbsi.service.emp.EmpService;
@Controller("depController")
@RequestMapping("/dep")
public class DepController {


	@Autowired
	DepService depService;
	
	@Autowired
	EmpService empService;
	
	/**
	 * 获取全部部门
	 * @return
	 */
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAllDep() {
		List<Dep> deps = depService.queryAllDep();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", deps);
		return map;
	}
	
	
	/**
	 * 添加部门
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addDep(Dep dep) {
		depService.addDep(dep);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "添加成功");
		return map;
	}
	
	
	/**
	 * 删除指定部门
	 * @return
	 */
	@RequestMapping(value = "{dep_id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> delDepByID(@PathVariable(value = "dep_id")Integer dep_id) {
		System.out.println(dep_id);
		Map<String, Object> map = new HashMap<String, Object>();
		if (dep_id == 5) {
			map.put("code", -1);
			map.put("msg", "临时部门不可删除");
			return map;
		}
		empService.updateEmpByDep_id(dep_id);
		depService.delDepByID(dep_id);
		map.put("code", 200);
		map.put("msg", "删除成功");
		return map;
	}
	
	/**
	 * 获取指定部门
	 * @param dep_id
	 * @return
	 */
	@RequestMapping(value = "{dep_id}",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDepByID(@PathVariable(value = "dep_id")Integer dep_id) {
		System.out.println(dep_id);
		Map<String, Object> map = new HashMap<String, Object>();
		Dep dep = depService.getDepByID(dep_id);
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", dep);
		return map;
	}
	
	/**
	 * 修改指定部门
	 * @param dep
	 * @return
	 */
	@RequestMapping(value = "/eidit",method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> eiditDepByID(Dep dep) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (dep.getDep_id() == 5) {
			map.put("code", -1);
			map.put("msg", "临时部门不可修改");
			return map;
		}
		
		System.out.println(dep);
		depService.eiditDepByID(dep);
		map.put("code", 200);
		map.put("msg", "修改成功");
		return map;
	}
}

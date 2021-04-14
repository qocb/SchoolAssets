package com.hbsi.controller.emp;

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
import com.hbsi.pojo.Emp;
import com.hbsi.service.emp.EmpService;

@Controller("empController")
@RequestMapping("/emp")
/**
 * Emp员工模块
 * @author 孙雨桐
 *
 */
public class EmpController {

	@Autowired
	EmpService empService;
	
	/**
	 * 查询全部员工
	 * @return
	 */
	@RequestMapping(value = "/all/{page}/{size}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> empAll(@PathVariable(value = "page") Integer page,@PathVariable(value = "size") Integer size) {
		List<Emp> emps = empService.queryAllEmp(page,size);
		PageInfo pageInfo = new PageInfo(emps);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", pageInfo);
		return map;
	}
	
	/**
	 * 根据id查询指定员工
	 * @param emp_id
	 * @return
	 */
	@RequestMapping(value = "{emp_id}",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getEmp(@PathVariable(value = "emp_id") Integer emp_id) {
		System.out.println(emp_id);
		Emp emp = empService.queryEmpByID(emp_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "请求成功");
		map.put("data", emp);
		return map;
	}
	
	/**
	 * 根据姓名查询指定员工
	 * @param emp_name
	 * @return
	 */
	@RequestMapping(value = "/like",method = RequestMethod.GET)
	@ResponseBody
	public List<Emp> queryEmpByName(String emp_name) {
		emp_name = "%"+emp_name+"%";
		List<Emp> emps = empService.queryEmpByName(emp_name);
		return emps;
	}
	
	/**
	 * 删除指定员工
	 * @param emp_id
	 * @return
	 */
	@RequestMapping(value = "{emp_id}",method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> delEmpByID(@PathVariable(value = "emp_id")Integer emp_id) {
		System.out.println(emp_id);
		empService.delEmpByID(emp_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "删除成功");
		return map;
	}
	
	/**
	 * 修改指定员工
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/eidit", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> eiditEmp(Emp emp) {
		
		System.out.println(emp);
		
		empService.eiditEmp(emp);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "修改成功");
		return map;
	}
	
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addEmp(Emp emp) {
		System.out.println(emp);
		empService.addEmp(emp);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("msg", "添加成功");
		return map;
	}
}

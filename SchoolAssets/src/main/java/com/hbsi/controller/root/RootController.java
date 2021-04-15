package com.hbsi.controller.root;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(value="/upload")
    @ResponseBody
    public  Map<String, Object> upload(Integer root_id ,MultipartFile uploadFile) throws IOException {
		 String originalFilename = uploadFile.getOriginalFilename();
		 System.out.println("上传的文件名"+originalFilename);
		 int lastIndexOf = originalFilename.lastIndexOf(".");
	     //获取文件的后缀名 .jpg
	     String suffix = originalFilename.substring(lastIndexOf);
	     System.out.println("文件后缀"+suffix);
	     System.out.println(root_id);
	     //新的文件名
	     String imgname = UUID.randomUUID().toString() + suffix; 
	     uploadFile.transferTo(new File("C:\\Users\\孙雨桐\\Desktop\\SchoolAssetsBackground\\imgs\\"+imgname));
	     rootService.uploadImg(imgname,root_id);
	     Map<String, Object> map=new HashMap<String, Object>();
	     map.put("code", 200);
		 map.put("msg", "更换成功");
	     return map;
	}
	
	@RequestMapping(value="/{root_id}",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String, Object> queryRootById(@PathVariable("root_id")Integer root_id){
		
		
		 Map<String, Object> root = rootService.queryRootByID(root_id);
		
	     //获取文件的后缀名 .jpg
	     Map<String, Object> map=new HashMap<String, Object>();
	     map.put("code", 200);
		 map.put("msg", "请求成功");
		 map.put("data", root);
	     return map;
	}
	
	@RequestMapping(value = "/download.html", method = RequestMethod.GET)
	public void download(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();//Student是被导出数据的类型，一般是自己写的Model类

		XSSFWorkbook excelbook = new XSSFWorkbook(); //创建workBook
		XSSFSheet excelSheet = excelbook.createSheet();//创建sheet表
		XSSFRow excelRow = excelSheet.createRow(0);//创建行
		XSSFCellStyle headerStyle = excelbook.createCellStyle();//设置 居中
		//接下来是创建 列标题 ,cell的起始值是 0,可创建n个列标题  
		XSSFCell cell = excelRow.createCell(0);
		cell.setCellStyle(headerStyle);//居中
		cell.setCellValue("列标题 ");

		//接下来遍历List,并写入EXCEL中
//		for(int i = 0; i < list.size(); i++){
//			//创建行,行号应从1开始,因为表头行(列标题)占据了第0行
//			excelRow = excelSheet.createRow(i + 1); 
//			Student t = list.get(i); // List 的起始值是0
//			//将该行每一列的数据写入,可写n列
//			cell = excelRow.createCell(0);
//			cell.setCellValue(t.getName());
//		}
		
		try {
			String filePath = "EXCEL表格导出路径.xls";
			writeExcel(response, excelbook, filePath, "文件名");//具体导出的方法
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void writeExcel(HttpServletResponse response, Workbook work,
			String filePath, String fileName) throws IOException {
		OutputStream outputStream = new FileOutputStream(filePath);
		try {
			response.setContentType("application/ms-excel;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename="
					.concat(String.valueOf(URLEncoder.encode(fileName + ".xls",
							"UTF-8"))));
			work.write(outputStream);
		} catch (IOException e) {
			System.out.println("输出流错误");
			e.printStackTrace();
		} finally {
			outputStream.close();
		}
	}
}

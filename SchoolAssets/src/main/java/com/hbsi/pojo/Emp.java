package com.hbsi.pojo;

public class Emp {

	private Integer emp_id;//员工id
	private String emp_name;//员工姓名
	private Integer emp_age;//员工年龄
	private String emp_sex;//员工性别
	private String emp_address;//员工地址
	private String emp_phone;//员工手机号
	
	private Dep dep;//员工部门

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Integer getEmp_age() {
		return emp_age;
	}

	public void setEmp_age(Integer emp_age) {
		this.emp_age = emp_age;
	}

	public String getEmp_sex() {
		return emp_sex;
	}

	public void setEmp_sex(String emp_sex) {
		this.emp_sex = emp_sex;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Emp [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_age=" + emp_age + ", emp_sex=" + emp_sex
				+ ", emp_address=" + emp_address + ", emp_phone=" + emp_phone + ", dep=" + dep + "]";
	}
	
}

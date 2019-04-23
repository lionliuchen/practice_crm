package com.cherry.crm.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.cherry.crm.domain.Customer;
import com.cherry.crm.domain.PageBean;
import com.cherry.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	//模型驱动
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	//注入Service
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// 接收分页的数据:
	//接收当前页数，和每页的记录数，这两个值在easyui中已经有规定：page当前页数，rows每页显示记录数
	private Integer page=1;
	private Integer rows=3;
	
	public void setPage(Integer page) {
		this.page = page;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}


	public String findAll() throws IOException {
//		System.out.println("findAll方法执行了");
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Customer.class);
		
		//调用业务层
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria,page,rows);
		//使用jsonlib或者fastjson
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", pageBean.getTotalCount());
		map.put("rows", pageBean.getList());
		
		//JSONArray,JSONObject
		JSONObject jsonObject = JSONObject.fromObject(map);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
//		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;
	}
	
	public String save() throws IOException {
		Map<String, String> map = new HashMap<String,String>();
		try {
			customerService.save(customer);
			map.put("msg", "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "保存失败!");
		}
		//JSONArray,JSONObject
		JSONObject jsonObject = JSONObject.fromObject(map);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
//		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;
	}

}

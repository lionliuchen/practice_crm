package com.cherry.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.cherry.crm.domain.Customer;
import com.cherry.crm.domain.PageBean;

public interface CustomerService {

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);

	void save(Customer customer);

}

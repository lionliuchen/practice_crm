package com.cherry.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cherry.crm.domain.Customer;

public interface CustomerDao {

	List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);

	Integer findCount(DetachedCriteria detachedCriteria);

	void save(Customer customer);
	
}

package com.cherry.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.cherry.crm.domain.PageBean;
import com.cherry.crm.domain.SaleVisit;

/**
 * 客户拜访记录的业务层的接口
 * @author zhang
 *
 */
public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);

}

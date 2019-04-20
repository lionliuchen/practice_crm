package com.cherry.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.cherry.crm.domain.LinkMan;
import com.cherry.crm.domain.PageBean;

/**
 * 联系人的Service的接口
 * @author zhang
 *
 */
public interface LinkManService {

	PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

}

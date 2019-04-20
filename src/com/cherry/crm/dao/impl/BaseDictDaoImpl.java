package com.cherry.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cherry.crm.dao.BaseDictDao;
import com.cherry.crm.domain.BaseDict;
/**
 * 字典DAO的实现类
 * @author zhang
 *
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	//根据类型编码查询字典数据
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BaseDict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	
}

package com.cherry.crm.dao;

import java.util.List;

import com.cherry.crm.domain.BaseDict;

/**
 * 字典DAO的接口
 * @author zhang
 *
 */
public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

}

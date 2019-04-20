package com.cherry.crm.service;

import java.util.List;

import com.cherry.crm.domain.BaseDict;

/**
 * 字典的业务层的接口
 * @author zhang
 *
 */
public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}

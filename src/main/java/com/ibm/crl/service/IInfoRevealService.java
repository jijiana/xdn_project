package com.ibm.crl.service;

import java.util.List;

import com.ibm.crl.model.InfoRevealVo;
import com.ibm.crl.model.PageResult;

public interface IInfoRevealService {
	public List<InfoRevealVo> getRevealData(InfoRevealVo vo,PageResult<InfoRevealVo> pc);
}

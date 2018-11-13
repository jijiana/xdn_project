package com.ibm.crl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.crl.dao.InfoRevealDao;
import com.ibm.crl.model.InfoRevealVo;
import com.ibm.crl.model.PageResult;
import com.ibm.crl.service.IInfoRevealService;

@Service("infoRevealService")
public class InfoRevealServiceImpl implements IInfoRevealService{

	@Autowired
    private InfoRevealDao dao;
	
	@Override
	public List<InfoRevealVo> getRevealData(InfoRevealVo vo, PageResult<InfoRevealVo> pc) {
		//查询总条数
		int moduleCount=dao.getRevealDataCont(vo,pc);
		pc.setTotal(moduleCount);
		//查询数据
		List<InfoRevealVo> list=dao.getRevealData(vo,pc);
		return list;
	}

}

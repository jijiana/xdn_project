package com.ibm.crl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.crl.dao.FundRecordDao;
import com.ibm.crl.model.FundRecordVo;
import com.ibm.crl.model.PageResult;
import com.ibm.crl.service.IFundRecordService;

@Service("fundRecordService")
public class FundRecordServiceImpl implements IFundRecordService{

	@Autowired
	private FundRecordDao dao;
	
	@Override
	public List<FundRecordVo> getFundRecordData(FundRecordVo vo, PageResult<FundRecordVo> pc) {
		//查询总条数
		int moduleCount=dao.getRecordDataCont(vo,pc);
		pc.setTotal(moduleCount);
		//查询数据
		List<FundRecordVo> list=dao.getRecordData(vo,pc);
		return list;
	}

}

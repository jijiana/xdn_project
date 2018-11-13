package com.ibm.crl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.crl.dao.FundAllocationDao;
import com.ibm.crl.model.FundAllocationVo;
import com.ibm.crl.model.PageResult;
import com.ibm.crl.service.IFundAllocationService;

@Service("fundAllocationService")
public class FundAllocationServiceImpl implements IFundAllocationService{

	@Autowired
    private FundAllocationDao dao;
	
	@Override
	public List<FundAllocationVo> getAllocationData(FundAllocationVo vo,PageResult<FundAllocationVo> pc) {
		//查询总条数
		int moduleCount=dao.getAllocationDataCont(vo,pc);
		pc.setTotal(moduleCount);
		//查询数据
		List<FundAllocationVo> list=dao.getAllocationData(vo,pc);
		return list;
	}

	@Override
	public double getAllocationTotal() {
		return dao.getAllocationTotal();
	}

}

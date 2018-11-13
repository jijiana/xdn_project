package com.ibm.crl.service;

import java.util.List;

import com.ibm.crl.model.FundAllocationVo;
import com.ibm.crl.model.PageResult;

public interface IFundAllocationService {
	public List<FundAllocationVo> getAllocationData(FundAllocationVo vo,PageResult<FundAllocationVo> pc);
	public double getAllocationTotal();
}

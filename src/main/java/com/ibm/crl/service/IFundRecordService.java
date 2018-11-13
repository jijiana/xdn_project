package com.ibm.crl.service;

import java.util.List;

import com.ibm.crl.model.FundRecordVo;
import com.ibm.crl.model.PageResult;

public interface IFundRecordService {

	public List<FundRecordVo> getFundRecordData(FundRecordVo vo,PageResult<FundRecordVo> pc);
}

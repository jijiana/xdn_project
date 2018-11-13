package com.ibm.crl.service;

import java.util.List;

import com.ibm.crl.model.CompanyInfoVo;
import com.ibm.crl.model.PageResult;

public interface ICompanyInfoService {
	public List<CompanyInfoVo> getCompanyData(CompanyInfoVo vo,PageResult<CompanyInfoVo> pc);
	public int addCompanyInfo(CompanyInfoVo vo);
	public CompanyInfoVo selectCompanyInfoById(String id);
	public int editCompanyInfo(CompanyInfoVo vo);
	public int deleteCompanyInfoById(String id);
}

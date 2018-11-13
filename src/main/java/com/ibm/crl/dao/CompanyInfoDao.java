package com.ibm.crl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ibm.crl.model.CompanyInfoVo;
import com.ibm.crl.model.PageResult;

public interface CompanyInfoDao {
	public int getCompanyDataCont(@Param("vo")CompanyInfoVo vo,@Param("pc")PageResult<CompanyInfoVo> pc);
	public List<CompanyInfoVo> getCompanyData(@Param("vo")CompanyInfoVo vo,@Param("pc")PageResult<CompanyInfoVo> pc);
	public void addCompanyInfo(CompanyInfoVo vo);
	public CompanyInfoVo selectCompanyInfoById(String id);
	public void editCompanyInfo(CompanyInfoVo vo);
	public int deleteCompanyInfoById(String id);
	
	public List<CompanyInfoVo> getCompanyNames(String name);
}

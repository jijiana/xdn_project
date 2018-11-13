package com.ibm.crl.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.crl.dao.CompanyInfoDao;
import com.ibm.crl.model.CompanyInfoVo;
import com.ibm.crl.model.PageResult;
import com.ibm.crl.service.ICompanyInfoService;

@Service("service")
public class CompanyInfoImpl implements ICompanyInfoService{
	@Autowired
    private CompanyInfoDao dao;
	
	@Override
	public List<CompanyInfoVo> getCompanyData(CompanyInfoVo vo,PageResult<CompanyInfoVo> pc){
        //查询总条数
		int moduleCount=dao.getCompanyDataCont(vo,pc);
		pc.setTotal(moduleCount);
		//查询数据
		List<CompanyInfoVo> moduleList=dao.getCompanyData(vo,pc);
		return moduleList;
   }

	@Override
	public int addCompanyInfo(CompanyInfoVo vo) {
		int retflag=0;
		String name = vo.getName();
		List<CompanyInfoVo> companyNames = getCompanyNames(name);
		if(companyNames != null &&companyNames.size()>0){
			retflag = 2;
			return retflag;
		}
		try{
			String uuid = UUID.randomUUID().toString();
			vo.setId(uuid);
			dao.addCompanyInfo(vo);
			retflag = 1;
		}catch(Exception e){
			e.printStackTrace();
			retflag=0;
		}
		return retflag;
	}

	public List<CompanyInfoVo> getCompanyNames(String name) {
		return dao.getCompanyNames(name);
	}
	
	@Override
	public CompanyInfoVo selectCompanyInfoById(String id) {
		CompanyInfoVo vo = dao.selectCompanyInfoById(id);
		return vo;
	}

	@Override
	public int editCompanyInfo(CompanyInfoVo vo) {
		int retflag=0;
		String name = vo.getName();
		List<CompanyInfoVo> companyNames = getCompanyNames(name);
		if(companyNames != null &&companyNames.size()>0){
			for(CompanyInfoVo ns : companyNames){
				if(!vo.getId().equals(ns.getId())){
					retflag = 2;
					return retflag;
				}
			}
		}
		try{
			dao.editCompanyInfo(vo);
			retflag = 1;
		}catch(Exception e){
			e.printStackTrace();
			retflag=0;
		}
		return retflag;
	}

	@Override
	public int deleteCompanyInfoById(String id) {
		int retflag=0;
		try{
			dao.deleteCompanyInfoById(id);
			retflag = 1;
		}catch(Exception e){
			e.printStackTrace();
			retflag=0;
		}
		return retflag;
	}

   
}

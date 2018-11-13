package com.ibm.crl.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.crl.model.FundAllocationVo;
import com.ibm.crl.model.PageResult;
import com.ibm.crl.service.IFundAllocationService;

@Controller
public class FundAllocationController {
	
	@Autowired
	private IFundAllocationService fundAllocationService;
	
	
	@RequestMapping("/fund_allocation")
    public String investmentCompanyIndex(Model m){
        return "fundAllocation";
    }
	
	@RequestMapping(value="/fundAllocationData",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> fundAllocationData(FundAllocationVo vo,Integer page,Integer rows){
		Map<String,Object> map = new HashMap<String,Object>();
		//设置分页 
		PageResult<FundAllocationVo> pc=new PageResult<FundAllocationVo>();
		if(page!=0&&page!=null){
			pc.setPage(page);
		}
		if(rows!=0&&rows!=null){
			pc.setRecords(rows);
			pc.setRows(rows);
		}
		List<FundAllocationVo> list = fundAllocationService.getAllocationData(vo,pc); 
		int totalPage = pc.getTotal() % rows == 0 ? pc.getTotal()/rows : pc.getTotal() / rows+ 1;
		//返回分页
		map.put("total",totalPage);
		map.put("page",pc.getPage());
		map.put("records",pc.getTotal());
		map.put("rows", list);
        return map;
    }
	
	@RequestMapping(value="/getAllocationTotal",method=RequestMethod.POST)
	@ResponseBody
	public String getAllocationTotal(){
		DecimalFormat df=new DecimalFormat("0.00");
		double total = fundAllocationService.getAllocationTotal();
		BigDecimal bg = new BigDecimal(total);
        double totalBd = bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        String format = df.format(totalBd);
		return format;
	}
}

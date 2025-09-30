package com.semi.cm.controller;

import java.util.List;

import com.semi.cm.model.vo.EmpVo;
import com.semi.cm.service.CommonService;

public class CommonController {

	private CommonService cms = new CommonService();

	public CommonController() {
		super();
	}
	
	/**
	 * 권한 체크
	 * @param list
	 * @return
	 */
	public boolean checkRole(EmpVo emp,String deptCode, String jobCode) {
		boolean result = false;
		
		result = cms.checkRole(emp,deptCode,jobCode);
		
		
		return result;
	}
	
}

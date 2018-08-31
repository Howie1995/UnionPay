package com.howie.pay.service;

import java.util.Map;

import com.howie.pay.dto.InfoDTO;


public interface IUnionPayService {
	/**
	 * 银联支付
	 * @author hongyang.jiang
	 */
	String unionPay(InfoDTO infoDTO);
	
	/**
	 * @author hongyang.jiang
	 */
	String validate(Map<String, String> valideData, String encoding);
	/**
	 * 对账单下载
	 * @author hongyang.jiang
	 */
	void fileTransfer();
}

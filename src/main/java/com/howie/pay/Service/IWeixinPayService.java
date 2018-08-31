package com.howie.pay.service;

import com.howie.pay.dto.InfoDTO;

public interface IWeixinPayService {
	/**
	 * 微信支付下单(模式二) 扫码支付 还有模式一 适合固定商品ID 有兴趣的同学可以自行研究
	 * @author hongyang.jiang
	 */
	String weixinPay2(InfoDTO infoDTO);

	/**
	 * 微信支付下单(模式一)
	 * @author hongyang.jiang
	 */
	void weixinPay1(InfoDTO infoDTO);

	/**
	 * 微信支付退款
	 * @author hongyang.jiang
	 */
	String weixinRefund(InfoDTO infoDTO);

	/**
	 * 关闭订单
	 * @author hongyang.jiang
	 */
	String weixinCloseorder(InfoDTO infoDTO);

	/**
	 * 下载微信账单
	 * @author hongyang.jiang
	 */
	void saveBill();

	/**
	 * 微信公众号支付返回一个url地址
	 * @author hongyang.jiang
	 */
	String weixinPayMobile(InfoDTO infoDTO);

	/**
	 * H5支付 唤醒 微信APP 进行支付 申请入口：登录商户平台-->产品中心-->我的产品-->支付产品-->H5支付
	 * @author hongyang.jiang
	 */
	String weixinPayH5(InfoDTO infoDTO);
}

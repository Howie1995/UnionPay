package com.howie.pay.aliUtils;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
/**
 * 配置公共参数
 * @author hongyang.jiang
 */
public final class AliPayConfig {
	
	 /**
     * 私有的默认构造子，保证外界无法直接实例化
     */
    private AliPayConfig(){};
	 /**
     * 参数类型
     */
    public static String PARAM_TYPE = "json";
    /**
     * 编码
     */
    public static String CHARSET = "UTF-8";
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
		private  static AlipayClient alipayClient = new DefaultAlipayClient(
													Configs.getOpenApiDomain(), Configs.getAppid(),
													Configs.getPrivateKey(), PARAM_TYPE, CHARSET,
													Configs.getAlipayPublicKey(),"RSA2");
		
		private  static AlipayTradeService tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
    }
    /**
     * 支付宝APP请求客户端实例
     * @author hongyang.jiang
     */
    public static AlipayClient getAlipayClient(){
        return SingletonHolder.alipayClient;
    }
    /**
     * 电脑端预下单
     * @author hongyang.jiang
     */
    public static AlipayTradeService getAlipayTradeService(){
        return SingletonHolder.tradeService;
    }
}

package cn.onekit.x2x.cloud.toutiao_alipay;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
@PropertySource(value = {"classpath:config.properties"},ignoreResourceNotFound = true)
public class AlipayAccount implements ApplicationContextAware {

    static String alipay_appId;
    static String alipay_signType;
    static String alipay_version;
    static String alipay_fromat;
    static String alipay_charset;
    static String alipay_secretKey;
    static String alipay_privateKey;
    static String alipay_notifyUrl;
    static String alipay_shopId;
    static String alipay_domain;
    static String alipay_partnerId;
    static String alipay_pay_notify;
    static String alipay_refund_notify;



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        alipay_appId = applicationContext.getEnvironment().getProperty("alipay.appId");
        alipay_signType = applicationContext.getEnvironment().getProperty("alipay.signType");
        alipay_version = applicationContext.getEnvironment().getProperty("alipay.version");
        alipay_fromat = applicationContext.getEnvironment().getProperty("alipay.fromat");
        alipay_charset = applicationContext.getEnvironment().getProperty("alipay.charset");
        alipay_secretKey = applicationContext.getEnvironment().getProperty("alipay.secretKey");
        alipay_privateKey = applicationContext.getEnvironment().getProperty("alipay.privateKey");
        alipay_notifyUrl = applicationContext.getEnvironment().getProperty("alipay.notifyUrl");
        alipay_shopId = applicationContext.getEnvironment().getProperty("alipay.shopId");
        alipay_domain = applicationContext.getEnvironment().getProperty("alipay.domain");
        alipay_partnerId = applicationContext.getEnvironment().getProperty("alipay.partnerId");
        alipay_pay_notify = applicationContext.getEnvironment().getProperty("alipay.pay_notify");
        alipay_refund_notify = applicationContext.getEnvironment().getProperty("alipay.refund_notify");
    }
    

    
    static {
    	String path = System.getProperty("user.home")+"\\AlipayApp\\alipay\\";
    	File file = new File(path);
    	if(!file.exists()) {
    		file.mkdir();
    	}
    }
    
 }

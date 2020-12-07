package cn.onekit.x2x.cloud.toutiao_alipay;

import java.io.File;

public class AlipayAccount {

    public static String webId        = "2018030502321064";
    public static String webPublickey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhiPs1yTNvI3ekHgE8mrfxAXskEjy3J2KYGEJk/IBLJikCgVusf29lHiYHfIr2s/sSpgVOSYzaV1oezNpxto5vTaGZsmPxlsYAvbj2wSaA3L0CW/0u2HjinfxUBFCG6KT82ZhVJpLUkIR7rMRwfRngzI/flLdRHqkSO3chq1H6H5StLsvyMD07eI2oLGnNLG54DZkuaopqXoTqBioAL+DKeAFlQ3se/fSgBGcpZP8pFhSp3sAYiup8jZHEpeKZJQgo9cTQu3bD6lappyvPdL+4zkBiGkgyGZv96ITIfZqMIaJiuakkIu5lhQYJ3a/gZ9QNeUAEmRBSKT6qu95dksAzwIDAQAB";
    public static String webScrectKey = "YF8dWxcIXgvoRuPMNTYH+g==";
    public static String webPrivateKey = "MIIEowIBAAKCAQEAvF4y6winMXjSSpv1zbgEGD9E2dZfvRs7HFluG/gJYRwIe4BmXnJOOa6YbvSlREA2MP00C9/S8lzpPycr2VJHfvy23hocX/wEvMczYsaMjkxViRtXRnSv/ljBjWVDIIHJRbDChaaXL70ASRqiQ/v7/96LJg3Q3+oCoFvnaHG54RjZcf2XdrK7/Khb1ANOFYTX5ug0e2wIfB3132v4Z312omXWvPn9gtUrh+YJguOsmERqyQFOmCdVJM/FBCvxmYL5xrOQDD9rLdFVKzj0bxMd9J0/FkN3MlQL5WVwc/q7z9r/Cl+MZjE6rt4oau3/Usa1CfM93CHN06JYe0M43NBvcQIDAQABAoIBACdaltC70hJn56dmxgfgthpKvZu1SfM8STE3DeYSAAOl06/Zt4lr4CP08ivcONr1f1zkyYbhkDTKbIChMmwI4J8LNTlZwyvafzLhez7btGnWUNiAOc+ieVJuQKHF0ixscRx6PWmm0FdM6U5cniIN9ywR1ohwwn7FaR8PlF0hxW/dYWHdzFP4tgRlOh88m/4jSz9a52L/y9CyU5MbOLQsOJS4ZUnofHcPdDTdH+gFKmxcmC+/OuqnfWK1NFaXjCLeXHokqokznMV+YPFWJ2oU3j3JctgFY8RmRheu+6oTxWMKGKe3OEiOxAeuHqrNahLWYA9viDAB+XDRHLoBikuWc3ECgYEA4viLFpaDM0F9frGXlDD9vSLiJqJY7GKdpjiul3iSUCuxK6KMU1KvTjaQ4CPoze4JFusKrGr8x33NTvEgEHBA/xF0yu1wpX4CenPZo+j3yeT4w0+KxZtfuNWDe7hnOPHdcH9RenF+60Kt89BEaH3pROnpJtfcacpEqc7XdcAvmacCgYEA1HW5IyIN/edOfZ8Kqlwzw7zNwxlVPqR+D/rS/vjZHLk/vKKoxyO8DYzW1HcKrd/fjV9uxLF/EDEFK+NokN5F9JDgcwry26dfcv2KYOXnt+2xyLSxcXZ1SZolWjNSmuV6m78vRq+JBCPT8p+r90223i31KACQ5lcZEptm0gxioScCgYEAvinZdvJiOIaNW6H1yu6FGXtpmU76TAuP5F2nQjd99ve0eEe3ZHRpdpFXLsRHYIooSXBiP/VfltD7PEHgSIWUn2CDxyXK9I0wDGKWHbOqMBjMp+8z6L52I8mYYQcuTNKwYnn5zSncWcZDMnzzY8zirZ+Bfc7r2CLlBpTLhtefyg8CgYB1TxMMXQ9QtFjYb+pZqlNCrosGQISa9ARPGnVKJ2jpvTd+FmoOmqKI8Mzlv1z8KHKtApaMsFyyOf7a/tOLuc7yfNQRcWgq9D11ppyzZ/4Lxoi1g1++gGO+Yghhx5jCwhZyzJtz8hQ7XvT2MEepYxWnk8Sbc8SOCmVjqr6ZGBGVXQKBgHGpqMcgg6Qf/dcaJEk8RJFJgcDIys6omTTJZAHLChZYrFCoYARggnP5MQWMJYD7zGZ5lWmhalq2bYhMjoH4LmlAFdJBazPWgcFruZHYz5imWiVOvm9fO3L1P+H75VkNSr6lGLtFj+HH13vOe4l4kS4HPSDn0xaDJgfjspFyt5p8";
   ////////////////////////////////////////////
    //回调验签公钥
    public static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgGJor6tuy3GLdejVlwFw56xKrUsTY/krVn8qoFiDlP36wIM7VgDqW7YOp3WKODGiv1sTM5j/cGlURk7pOawYTYgldfpOoZowoFv2wfVW7v6ecMj+vJQcjcogEaPiJRnQN2EnC020rRQjZs43Cpurpd5kusNa/wWdeBFhH/X5v9/G28aIT+1PK1ApmWZBHUVzQn8T42QHiV/n8VotSeiFwdIzDhqTyTclt4FDFcC5m/ga1Exf4nPeLG+02GYEAI1YXrVzYrrR6Nc1YTFAlyODo7opNk0faW78FYrw78Xgp91KMO/bO6BI+WHqHcpkRtpT5cQFoR9OyDlUgk9JQRsnIwIDAQAB";
    
///////////////////////////////////////////////////////////////////////////
    public static  String appId       = "2019112969519656";
    public  static String secretKey   = "vMlHC/RpkNqL7axIkhhUsg==+mirdQ==";
    public static  String privateKey  = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCmTJVMom6J6C1GBGL12JFTaNheE6sLoD0o90Ry6ab3ZRfaK8fluevw91+suaqY/GcYS81XEn5pu6YN1PGko0pjHTw9JTNmDvK1cQ/sre0/WQiIKb0OCzACJEBDJJ/BKcKFw4RWhiKhXIKAwmn6MjsSXMHDY/eXwnEdXQc6hbnfhSBviQoyN2uiLUmC55zVpsU2eLksITu0arBlWfiioaDsUz+sa8dWxW3OEdSpwPBRxpXlQnOLuoP/OMdauZlsopnudmQMh9jtI/GTpLX13UExaZhonJCYbT0H69WabWy19XOfp6vET5mXJbMabzswmv8ywzF/FlkMwwxiRTlfCCxPAgMBAAECggEAWyYkuwFY1wvELNlgqGGQnggcd8wN92xXuWl2QgnhMz5cyX8vrLGwKb5c2V5WrE3D8CQ0I2KGmUt546Dw5Y1+yz6N8vG971WIIH0c/lwCarNRItjFv7nQEYxvEJ41VfmenhShJ4+T0Z/UA+ELl1AK4rCmn4LehXbU6wQ/XwtG6sS519Ndw21eYJWafNI9JeTeWbOWMc83kg1+KOFRRGUEEeQqd5Nj+f/ezjOTPYSEPr2ZjpCHrrd2MzAX4Ih9hLucwDPYJTcAzDqKafmnEkIR+IlRx4u3AbEYaD3TFH6nJ478weBeCybb2yUow/4rtjcclJMl8qDfUJDeHT86m3vSSQKBgQDTTJUUwr9POR+DWIy4GSAgBpFtDJ2Nlgt0E0jeqq33gGxlkHb2N/LL44Une723GE56S6Ofals1aaS51/elxM7IpXARegGrP2K0gH24RazSgndUdZbT7UV2sCkxBmoNkV+DQ6fGAhFA51J27BJViD3k/TlT4pnNNymNNSF66aSTYwKBgQDJeuq9WXCAQahCmHGkbknS5rKuaZRrDdLAaYgjdNFM6OkQ29aEYkdQIuBrdpt+0LxNM3quFDGjrE2uyrMVwzqU8cKxv+ukUr5rPs9wQi3+TfEsO4FL8R4yGqAat06GloUhvAZInDdE/t4pOQ2vdLtMT/sQMQCMXaI6tXUpOCVVJQKBgQCJVAKohZIVCUlD8m8yz5GjfuFRgJt9hAFZpZb8sO10KJFKyUOn7uDsRqkp6jB5KWEH9tUXLOaupkSbTJP1tx22Jl/Z2/PturqKGeCbvRz/jC/GQs6OWm2FICUFaefPfaYYCAaomHtiNXXROMkJsgyYIUP7ExFm4O0ui1OBMQz3hQKBgCfSRH0CJWskDvaCnMtsBOlLMXupYG08QTBIa2DeoNN7oTz0xlRJ/GBJVGPJAHizFtSHXTL0yM7ZqkzmwTiG6pgvpFRvY0qKFBqsQmGkouSFUSp15Fs3H8m1W3mMS1fsfgmp2PAW+BGJ8izhmuPXxYESucN8e+hCRWMnJC3ua+qFAoGAJjpSYx6cmanBdwRmlVBaSEIQAf9A5MLWt9dNOMk2ilfp6z6OEw3OOS4chLpMmQuXc2IYFMXLG+9k8U39VD5wg/2invICoYAVXotZcwLP5kACMGf7EuPUUwxOVRvTwP5+NsM2LcJq3IOnhGa93x5ltF8qELvKJyS/6zJx8qSLGJY=";
//  public static String publicKey    		= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApkyVTKJuiegtRgRi9diRU2jYXhOrC6A9KPdEcumm92UX2ivH5bnr8PdfrLmqmPxnGEvNVxJ+abumDdTxpKNKYx08PSUzZg7ytXEP7K3tP1kIiCm9DgswAiRAQySfwSnChcOEVoYioVyCgMJp+jI7ElzBw2P3l8JxHV0HOoW534Ugb4kKMjdroi1Jguec1abFNni5LCE7tGqwZVn4oqGg7FM/rGvHVsVtzhHUqcDwUcaV5UJzi7qD/zjHWrmZbKKZ7nZkDIfY7SPxk6S19d1BMWmYaJyQmG09B+vVmm1stfVzn6erxE+ZlyWzGm87MJr/MsMxfxZZDMMMYkU5XwgsTwIDAQAB";
//  public static String alipayPublicKey    = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvlQqavNOXy3Y5E1uiChB8Dqi6hod6Ezj+uGs2Xa05uXPX9H8y97xbO/4Tf4Klmb61LGZBMEzBxC/GyK/HqOZHOhnCWZ6rK7EHzicNqH/KOAj/4CH0mG+PILDgdQSsQu31fJ1vu2Qlx7zGA4tM0Ds0xV+fHQXjtEX33mL2QvJy2KexM2/OvUne8EJ//f6ZcD2XONhlD0n6/qWVuN5USspw4CKvEtEg3Qqt8d1Esqj9beG0EtPKM5ZtBMRIagWGLCbVHSnel7Vup7tq3zKhB8mfNDaq/EkYl2CJmmhBVXIHPOCPblPJnn+My4Pz7KP9sYmJ5JAybz63R1DnjZGEtuvZQIDAQAB";
    public  static String signType    = "RSA2";
    public static  String version     = "1.0";
    public static  String fromat      = "json";
    public static String charset      = "UTF-8";
    public static String notifyUrl    = "https://www.onekitwx.com/alipay/alipaynotify.jsp";
    public static String shopId       = "2018030600077000000047967582";
    public static String domain       = "https://www.onekitwx.com/";
    public static String partnerId    = "2088821308046303";
	
    public static String pay_notify = "https://www.onekitwx.com/AlipayApp/alipay/paynotify.jsp";
    public static String refund_notify = "https://www.onekitwx.com/AlipayApp/alipay/refundnotify.jsp";
    
    static {
    	String path = System.getProperty("user.home")+"\\AlipayApp\\alipay\\";
    	File file = new File(path);
    	if(!file.exists()) {
    		file.mkdir();
    	}
    }
    
 }

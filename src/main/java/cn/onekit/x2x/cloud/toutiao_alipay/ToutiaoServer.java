package cn.onekit.x2x.cloud.toutiao_alipay;



import cn.onekit.thekit.AJAX;
import cn.onekit.thekit.FileDB;
import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayOpenAppMessageTopicSubscribeResponse;
import com.alipay.api.response.AlipayOpenAppQrcodeCreateResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.developer.AlipaySellSDK;
import com.alipay.developer.AlipayToolSDK;
import com.alipay.openapi.entity.alipay_open_app_message_topic_subscribe_body;
import com.alipay.openapi.entity.alipay_open_app_qrcode_create_body;
import com.toutiao.developer.ToutiaoAPI;
import com.toutiao.developer.entity.*;

import java.util.UUID;

public abstract class ToutiaoServer implements ToutiaoAPI {


    private AlipayToolSDK alipayToolSDK=new AlipayToolSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.alipay_appId,"",AlipayAccount.alipay_fromat,AlipayAccount.alipay_charset,AlipayAccount.alipay_signType,
            "","",AlipayAccount.alipay_version,"");

    private AlipaySellSDK alipaySellSDK=new AlipaySellSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.alipay_appId,"",AlipayAccount.alipay_fromat,AlipayAccount.alipay_charset,AlipayAccount.alipay_signType,
            "","",AlipayAccount.alipay_version,"");



    abstract protected void _code_openid(String tt_code, String tt_openid);
    abstract protected FileDB.Data _code_openid(String tt_code);
    abstract protected void _openid_sessionkey(String tt_openid, String tt_sessionkey);
    abstract protected FileDB.Data _openid_sessionkey(String tt_openid);
    abstract protected void _token_token(String wx_token,String tt_token);
    abstract protected boolean _token_token(String wx_token);
    //////////////////////////////////////

    @Override
    public apps__token_response apps__token(String tt_appid, String tt_secret, String tt_grant_type)  {
        String token = String.valueOf(UUID.randomUUID());
        apps__token_response tt_response = new apps__token_response();
        tt_response.setAccess_token(token);
        tt_response.setExpires_in(7200);
        _token_token(token,token);
        return tt_response;
    }

    @Override
    public apps__jscode2session_response apps__jscode2session(String tt_appid, String tt_secret, String tt_code, String tt_anonymous_code) throws ToutiaoError {
        if(tt_appid == null || tt_secret == null || (tt_code == null && tt_anonymous_code ==null)) {
            ToutiaoError toutiaoError = new ToutiaoError();
            toutiaoError.setError(1);
            toutiaoError.setErrcode(40014);
            toutiaoError.setErrmsg("bad params");
            toutiaoError.setMessage("bad parameters");
            throw toutiaoError;
        }
        boolean isCode =  tt_code!=null;
        final String code = isCode?tt_code:tt_anonymous_code;
        FileDB.Data user_id_data = _code_openid(code);
        FileDB.Data al_session_key_data = null;
        if(user_id_data!=null){
            al_session_key_data = _openid_sessionkey(user_id_data.value);
            apps__jscode2session_response tt_response = new apps__jscode2session_response();
            tt_response.setAnonymous_openid(user_id_data.value);
            tt_response.setOpenid(user_id_data.value);
            tt_response.setSession_key(al_session_key_data.value);
            return tt_response;
        }
        ///////////////////////////////////////////////////
        final String al_grant_type = "authorization_code";
        AlipaySystemOauthTokenResponse al_response ;
        try {
            al_response = alipayToolSDK.alipay_system_oauth_token(al_grant_type,tt_code,null);
        } catch (AlipayApiException e) {
            ToutiaoError tt_error = new ToutiaoError();
            tt_error.setError(74077);
            tt_error.setErrcode(Integer.parseInt(e.getErrCode()));
            tt_error.setErrmsg(e.getErrMsg());
            throw tt_error;
        }
        //////////
        assert false;
        user_id_data.value = al_response.getUserId();
        al_session_key_data.value = al_response.getAccessToken();
        ///////////////
        _code_openid(code,user_id_data.value);
        _openid_sessionkey(user_id_data.value,al_session_key_data.value);
        ////////////
        apps__jscode2session_response tt_response = new apps__jscode2session_response();
        tt_response.setAnonymous_openid(user_id_data.value);
        tt_response.setOpenid(user_id_data.value);
        tt_response.setSession_key(al_session_key_data.value);
        return tt_response;
    }

//    @Override
//    public apps__set_user_storage_response apps__set_user_storage(String tt_access_token, String tt_openid, String tt_signature, String tt_sig_method, apps__set_user_storage_body tt_body) throws ToutiaoError {
//        return null;
//    }
//
//    @Override
//    public apps__remove_user_storage_response apps__remove_user_storage(String tt_access_token, String tt_openid, String tt_signature, String tt_sig_method, apps__remove_user_storage_body tt_body) throws ToutiaoError {
//        return null;
//    }

    @Override
    public byte[] apps__qrcode(apps__qrcode_body tt_body) throws ToutiaoError {
        AlipayOpenAppQrcodeCreateResponse al_response ;
        try {
            alipay_open_app_qrcode_create_body al_body = new alipay_open_app_qrcode_create_body();
            al_body.setUrl_param(tt_body.getPath());
            al_body.setQuery_param("x=2");
            al_body.setDescribe("二维码描述");
            al_response = alipaySellSDK.alipay_open_app_qrcode_create(al_body);
        } catch (AlipayApiException e) {
            ToutiaoError tt_error = new ToutiaoError();
            tt_error.setError(74077);
            tt_error.setErrcode(Integer.parseInt(e.getErrCode()));
            tt_error.setErrmsg(e.getErrMsg());
            throw tt_error;
        }

        try {
            //noinspection ConstantConditions
            return AJAX.download(al_response.getQrCodeUrl(),"get",null) ;
        } catch (Exception e) {
            return null;
        }
    }

//    @Override
//    public apps__game__template__send_response apps__game__template__send(apps__game__template__send_body tt_body) throws ToutiaoError {
//        return null;
//    }

    @Override
    public apps__subscribe_notification__developer__notify_response apps__subscribe_notification__developer__notify(apps__subscribe_notification__developer__notify_body tt_body) throws ToutiaoError {
        apps__subscribe_notification__developer__notify_response tt_response = new apps__subscribe_notification__developer__notify_response();

        alipay_open_app_message_topic_subscribe_body al_body = new alipay_open_app_message_topic_subscribe_body();

        if(!_token_token(tt_body.getAccess_token())){
            ToutiaoError tt_error = new ToutiaoError();
            tt_error.setError(1);
            tt_error.setErrcode(40002);
            tt_error.setErrmsg("bad access_token");
            tt_error.setMessage("bad access_token");
            throw tt_error;
        }

        al_body.setAuth_token(tt_body.getAccess_token());
        al_body.setComm_type("HTTP");
        al_body.setAuth_type("app_auth");
        al_body.setTopic("alipay.open.auth.appauth.cancelled");
        al_body.setTag("BIZ_TAG");
        try {
            AlipayOpenAppMessageTopicSubscribeResponse al_response = alipayToolSDK.alipay_open_app_message_topic_subscribe(al_body);
            tt_response.setErr_no(Integer.parseInt(al_response.getCode()));
            tt_response.setErr_tips(al_response.getMsg());
        } catch (AlipayApiException e) {
            ToutiaoError tt_error = new ToutiaoError();
            tt_error.setError(74077);
            tt_error.setErrcode(Integer.parseInt(e.getErrCode()));
            tt_error.setErrmsg(e.getErrMsg());
            throw tt_error;
        }
        return tt_response;
    }





}

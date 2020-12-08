package cn.onekit.x2x.cloud.toutiao_alipay.web;


import cn.onekit.thekit.DB;
import cn.onekit.thekit.JSON;
import cn.onekit.x2x.cloud.toutiao_alipay.ToutiaoServer;
import com.toutiao.developer.entity.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class ToutiaoServerWeb {
    private ToutiaoServer _toutiaoServer;
    private ToutiaoServer toutiaoServer() {
        if(_toutiaoServer==null){
            _toutiaoServer = new ToutiaoServer() {
                @Override
                protected void _code_openid(String tt_code, String tt_openid) {
                    DB.set("[toutiao-alipay] code_openid",tt_code,tt_openid);
                }

                @Override
                protected String _code_openid(String tt_code) {
                    return DB.get("[toutiao-alipay] code_openid",tt_code);
                }

                @Override
                protected void _openid_sessionkey(String tt_openid, String tt_sessionkey) {
                    DB.set("[toutiao-alipay] openid_sessionkey",tt_openid,tt_sessionkey);
                }

                @Override
                protected String _openid_sessionkey(String tt_openid) {
                    return DB.get("[toutiao-alipay] openid_sessionkey",tt_openid);
                }

                @Override
                protected void _token_token(String wx_token, String tt_token) {
                    DB.set("[toutiao-alipay] token_token",wx_token,tt_token);
                }

                @Override
                protected boolean _token_token(String wx_token) {
                    return Boolean.parseBoolean(DB.get("[toutiao-alipay] token_token",wx_token));
                }
            };
        }
        return _toutiaoServer;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/apps/token")
    public String getAccessToken(
            @RequestParam(required = false) String appid,
            @RequestParam(required = false) String secret,
            @RequestParam(required = false) String grant_type
    )  {
        try {
            return JSON.object2string(toutiaoServer().apps__token(appid, secret, grant_type));
        } catch (ToutiaoError toutiaoError) {
            return JSON.object2string(toutiaoError);
        }catch (Exception error){
            ToutiaoError toutiaoError = new ToutiaoError();
            toutiaoError.setError(500);
            toutiaoError.setErrcode(500);
            toutiaoError.setErrmsg(error.getMessage());
            return JSON.object2string(toutiaoError);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/apps/jscode2session")
    public String code2Session(
            @RequestParam(required=false) String appid,
            @RequestParam(required=false) String secret,
            @RequestParam(required=false) String code,
            @RequestParam(required=false)  String anonymous_code
    )  {
        try {
            return JSON.object2string(toutiaoServer().apps__jscode2session(appid, secret, code, anonymous_code));
        }catch (ToutiaoError toutiaoError) {
            return JSON.object2string(toutiaoError);
        }catch (Exception error){
            ToutiaoError toutiaoError = new ToutiaoError();
            toutiaoError.setError(500);
            toutiaoError.setErrcode(500);
            toutiaoError.setErrmsg(error.getMessage());
            return JSON.object2string(toutiaoError);
        }
    }



    @RequestMapping(method = RequestMethod.POST, value = "/api/apps/qrcode",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] qrcode(
            @RequestBody String tt_body
    ) {
        try {
            return toutiaoServer().apps__qrcode(JSON.string2object(tt_body, apps__qrcode_body.class));
        } catch (ToutiaoError toutiaoError) {
            return JSON.object2string(toutiaoError).getBytes();
        } catch (Exception error) {
            ToutiaoError toutiaoError = new ToutiaoError();
            toutiaoError.setError(500);
            toutiaoError.setErrcode(500);
            toutiaoError.setErrmsg(error.getMessage());
            return JSON.object2string(toutiaoError).getBytes();
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "api/apps/subscribe_notification/developer/v1/notify")
    public String subscribe(
            @RequestBody String body
    ){
        try {
            return JSON.object2string(toutiaoServer().apps__subscribe_notification__developer__notify(JSON.string2object(body, apps__subscribe_notification__developer__notify_body.class)));
        } catch (ToutiaoError toutiaoError) {
            return JSON.object2string(toutiaoError);
        }catch (Exception error) {
            ToutiaoError toutiaoError = new ToutiaoError();
            toutiaoError.setError(500);
            toutiaoError.setErrcode(500);
            toutiaoError.setErrmsg(error.getMessage());
            return JSON.object2string(toutiaoError);
        }

    }



}
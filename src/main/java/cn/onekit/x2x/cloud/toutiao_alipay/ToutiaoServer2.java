package cn.onekit.x2x.cloud.toutiao_alipay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipaySecurityRiskContentDetectResponse;
import com.alipay.developer.AlipayMiniSDK;
import com.alipay.openapi.entity.alipay_security_risk_content_detect_body;
import com.aliyun.developer.AliyunSDK;
import com.aliyuncs.entity.ImageSyncScanRequest_body;
import com.aliyuncs.http.HttpResponse;
import com.toutiao.developer.ToutiaoAPI2;
import com.toutiao.developer.entity.Predict;
import com.toutiao.developer.entity.v2.*;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ToutiaoServer2 implements ToutiaoAPI2 {


    private AlipayMiniSDK alipayMiniSDK=new AlipayMiniSDK("https://openapi.alipay.com/gateway.do",AlipayAccount.alipay_appId,"",AlipayAccount.alipay_fromat,AlipayAccount.alipay_charset,AlipayAccount.alipay_signType,
            "","",AlipayAccount.alipay_version,"");

    private AliyunSDK aliyunSDK = new AliyunSDK();


    abstract protected void _code_openid(String tt_code, String tt_openid);
    abstract protected String _code_openid(String tt_code);
    abstract protected void _openid_sessionkey(String tt_openid, String tt_sessionkey);
    abstract protected String _openid_sessionkey(String tt_openid);
    abstract protected void _token_token(String wx_token,String tt_token);
    abstract protected boolean _token_token(String wx_token);

    @Override
    public tags__text__antidirt_response tags__text__antidirt(String tt_X_Token, tags__text__antidirt_body tt_body) throws ToutiaoError2 {

        tags__text__antidirt_response tt_response = new tags__text__antidirt_response();
        try {
            alipay_security_risk_content_detect_body al_body = new alipay_security_risk_content_detect_body();
            for (tags__text__antidirt_body.Task task : tt_body.getTasks()) {
                al_body.setContent(task.getContent());
            }
            AlipaySecurityRiskContentDetectResponse al_response = alipayMiniSDK.alipay_security_risk_content_detect(al_body);
            tt_response.setLog_id(al_response.getUniqueId());
            ArrayList<tags__text__antidirt_response.Data> datas = new ArrayList<>();
            tags__text__antidirt_response.Data data = new tags__text__antidirt_response.Data();
            data.setCode(Integer.parseInt(al_response.getCode()));
            data.setMsg(al_response.getMsg());
            data.setTask_id("");
            data.setData_id(null);

            Predict predict =new Predict();
            if (Integer.parseInt(al_response.getCode()) == 10000) {
                predict.setProb(1);
                predict.setHit(true);
            }else {
                predict.setProb(0);
                predict.setHit(false);
            }
            predict.setTarget(null);
            predict.setModel_name("short_content_antidirt");
            ArrayList<Predict> predicts = new ArrayList<>();
            predicts.add(predict);

            data.setPredicts(predicts);
            datas.add(data);
            tt_response.setData(datas);
        } catch (AlipayApiException e) {
            ToutiaoError2 tt_error2 = new ToutiaoError2();
            tt_error2.setCode(74077);
            tt_error2.setError_id(e.getErrCode());
            tt_error2.setMessage(e.getErrMsg());
            throw tt_error2;
        }
        return tt_response;
    }

    @Override
    public tags__image_response tags__image(String tt_X_Token, tags__image_body tt_body) throws ToutiaoError2 {
        tags__image_response tt_response = new tags__image_response();
        ImageSyncScanRequest_body al_body = new ImageSyncScanRequest_body();
        ArrayList<ImageSyncScanRequest_body.Scene> scenes = new ArrayList<>();
        scenes.add(ImageSyncScanRequest_body.Scene.porn);
        scenes.add(ImageSyncScanRequest_body.Scene.qrcode);
        scenes.add(ImageSyncScanRequest_body.Scene.live);
        scenes.add(ImageSyncScanRequest_body.Scene.ad);
        scenes.add(ImageSyncScanRequest_body.Scene.logo);
        scenes.add(ImageSyncScanRequest_body.Scene.terrorism);

        al_body.setScenes(scenes);
        al_body.setBizType(null);

        HashMap<String, ImageSyncScanRequest_body.Task> al_tasks = new HashMap<>();

        ImageSyncScanRequest_body.Task al_task = new ImageSyncScanRequest_body.Task();

        for (tags__image_body.Task tt_task : tt_body.getTasks()) {
            al_task.setUrl(tt_task.getImage());
        }
        al_tasks.put("url",al_task);

        HttpResponse al_response = aliyunSDK.ImageSyncScanRequest(al_body);
        tt_response.setLog_id(null);

        ArrayList<tags__image_response.Data> datas = new ArrayList<>();
        tags__image_response.Data data = new tags__image_response.Data();
        data.setCode(200);
        data.setMsg("success");
        data.setTask_id("");
        data.setData_id(null);

        Predict predict =new Predict();
        if (al_response.isSuccess()) {
            predict.setProb(1);
            predict.setHit(true);
        }else {
            predict.setProb(0);
            predict.setHit(false);
        }
        predict.setTarget(null);
        predict.setModel_name(null);
        ArrayList<Predict> predicts = new ArrayList<>();
        predicts.add(predict);

        data.setPredicts(predicts);
        datas.add(data);
        tt_response.setData(datas);


        return tt_response;
    }
}

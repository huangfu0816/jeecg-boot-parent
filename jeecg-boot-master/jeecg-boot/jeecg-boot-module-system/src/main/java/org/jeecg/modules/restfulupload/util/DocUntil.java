package org.jeecg.modules.restfulupload.util;

import org.jeecg.modules.restfulupload.entity.DocUpload;
import org.jeecg.modules.restfulupload.model.DocUploadModel;

import java.io.File;

public class DocUntil {
    public static String docVerification(DocUploadModel docUploadModel){
        String problem="trues";
        String appid=docUploadModel.getAppid();
        String sign=docUploadModel.getSign();
        File file=docUploadModel.getFile();
        if(null==appid|| "".equals(appid)|| "null".equals(appid)){
            return "appid 不允许为空";
        }
        if(null==sign|| "".equals(sign)|| "null".equals(sign)){
            return "签名 不允许为空";
        }
        if(null==file|| "".equals(file)|| "null".equals(file)){
            return "上传文件为空";
        }

        return problem;
    }
}

package org.jeecg.modules.restfulupload.util;

import org.jeecg.modules.restfulupload.model.AudioUploadModel;
import org.jeecg.modules.restfulupload.model.DocUploadModel;

import java.io.File;

public class AudioUntil {

    public static String audioUntil(AudioUploadModel audioUploadModel){
        String problem="trues";
        String appid=audioUploadModel.getAppid();
        String sign=audioUploadModel.getSign();
        File file=audioUploadModel.getFile();
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

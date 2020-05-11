package org.jeecg.modules.restfulupload.util;

import org.jeecg.modules.restfulupload.model.DocUploadModel;
import org.jeecg.modules.restfulupload.model.PictureUploadModel;

import java.io.File;

public class PictureUntil {
    public static String pictureUntil(PictureUploadModel pictureUploadModel){
        String problem="trues";
        String appid=pictureUploadModel.getAppid();
        String sign=pictureUploadModel.getSign();
        File file=pictureUploadModel.getFile();
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

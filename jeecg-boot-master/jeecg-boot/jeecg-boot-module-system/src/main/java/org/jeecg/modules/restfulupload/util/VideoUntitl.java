package org.jeecg.modules.restfulupload.util;

import org.jeecg.modules.restfulupload.model.DocUploadModel;
import org.jeecg.modules.restfulupload.model.VideoUploadModel;

import java.io.File;

public class VideoUntitl {
    public static String videoUntitl(VideoUploadModel VideoUploadModel){
        String problem="trues";
        String appid=VideoUploadModel.getAppid();
        String sign=VideoUploadModel.getSign();
        File file=VideoUploadModel.getFile();
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

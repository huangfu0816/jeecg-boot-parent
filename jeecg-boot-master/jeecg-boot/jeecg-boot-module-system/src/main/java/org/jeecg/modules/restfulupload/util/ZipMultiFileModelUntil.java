package org.jeecg.modules.restfulupload.util;

import org.jeecg.modules.restfulupload.model.VideoUploadModel;
import org.jeecg.modules.restfulupload.model.ZipMultiFileModel;

import java.io.File;

/**
 * 必填校验
 */
public class ZipMultiFileModelUntil {
    public static String zipMultiFileModelUntitl(ZipMultiFileModel zipMultiFileModel){
        String problem="trues";
        String appid=zipMultiFileModel.getAppid();
        String sign=zipMultiFileModel.getSign();
        String file=zipMultiFileModel.getFileId();
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

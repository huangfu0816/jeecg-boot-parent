package org.jeecg.modules.restfulupload.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.restfulupload.entity.AudioUpload;
import org.jeecg.modules.restfulupload.entity.DocUpload;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

/**
 * @Description: 文档上传
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
public interface IDocUploadService extends IService<DocUpload> {
    public void saveDocUpload(DocUpload docUpload);

}

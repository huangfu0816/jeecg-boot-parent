package org.jeecg.modules.restfulupload.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.restfulupload.entity.PictureUpload;

/**
 * @Description: 图片上传
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
public interface IPictureUploadService extends IService<PictureUpload> {
    public void savePictureUpload(PictureUpload pictureUpload);

}

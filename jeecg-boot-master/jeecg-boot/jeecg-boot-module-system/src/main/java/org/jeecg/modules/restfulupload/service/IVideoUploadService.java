package org.jeecg.modules.restfulupload.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.restfulupload.entity.VideoUpload;

/**
 * @Description: 视频文件参数
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
public interface IVideoUploadService extends IService<VideoUpload> {
    public void saveVideoUpload(VideoUpload videoUpload);

}

package org.jeecg.modules.restfulupload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.restfulupload.entity.VideoUpload;
import org.jeecg.modules.restfulupload.mapper.PictureUploadMapper;
import org.jeecg.modules.restfulupload.mapper.VideoUploadMapper;
import org.jeecg.modules.restfulupload.service.IVideoUploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 视频文件参数
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
@Service
public class VideoUploadServiceImpl extends ServiceImpl<VideoUploadMapper, VideoUpload> implements IVideoUploadService {
    @Resource
    VideoUploadMapper videoUploadMapper;
    @Override
    public void saveVideoUpload(VideoUpload videoUpload) {
        videoUploadMapper.insert(videoUpload);
    }
}

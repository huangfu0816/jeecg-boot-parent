package org.jeecg.modules.restfulupload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.restfulupload.entity.AudioUpload;
import org.jeecg.modules.restfulupload.mapper.AudioUploadMapper;
import org.jeecg.modules.restfulupload.service.IAudioUploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 音频文件参数
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
@Service
public class AudioUploadServiceImpl extends ServiceImpl<AudioUploadMapper, AudioUpload> implements IAudioUploadService {
    @Resource
    AudioUploadMapper audioUploadMapper;

    @Override
    public void saveAudioUpload(AudioUpload audioUpload) {
        audioUploadMapper.insert(audioUpload);
    }
}

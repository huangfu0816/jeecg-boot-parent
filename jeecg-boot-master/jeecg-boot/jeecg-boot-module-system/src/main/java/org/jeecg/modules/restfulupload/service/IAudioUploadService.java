package org.jeecg.modules.restfulupload.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.restfulupload.entity.AudioUpload;
import org.jeecg.modules.system.entity.SysAnnouncement;

/**
 * @Description: 音频文件参数
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
public interface IAudioUploadService extends IService<AudioUpload> {
    public void saveAudioUpload(AudioUpload audioUpload);

}

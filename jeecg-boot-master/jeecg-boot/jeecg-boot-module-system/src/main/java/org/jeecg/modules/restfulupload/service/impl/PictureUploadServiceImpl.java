package org.jeecg.modules.restfulupload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.restfulupload.entity.PictureUpload;
import org.jeecg.modules.restfulupload.mapper.DocUploadMapper;
import org.jeecg.modules.restfulupload.mapper.PictureUploadMapper;
import org.jeecg.modules.restfulupload.service.IPictureUploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 图片上传
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
@Service
public class PictureUploadServiceImpl extends ServiceImpl<PictureUploadMapper, PictureUpload> implements IPictureUploadService {
    @Resource
    PictureUploadMapper pictureUploadMapper;
    @Override
    public void savePictureUpload(PictureUpload pictureUpload) {
        pictureUploadMapper.insert(pictureUpload);
    }
}

package org.jeecg.modules.restfulupload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.restfulupload.entity.DocUpload;
import org.jeecg.modules.restfulupload.mapper.AudioUploadMapper;
import org.jeecg.modules.restfulupload.mapper.DocUploadMapper;
import org.jeecg.modules.restfulupload.service.IDocUploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.ArrayList;

/**
 * @Description: 文档上传
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
@Service
public class DocUploadServiceImpl extends ServiceImpl<DocUploadMapper, DocUpload> implements IDocUploadService {
    @Resource
    DocUploadMapper docUploadMapper;

    @Override
    public void saveDocUpload(DocUpload docUpload) {
        docUploadMapper.insert(docUpload);
    }
}

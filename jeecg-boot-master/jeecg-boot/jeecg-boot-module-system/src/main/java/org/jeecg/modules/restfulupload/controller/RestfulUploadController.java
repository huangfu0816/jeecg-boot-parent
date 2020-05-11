package org.jeecg.modules.restfulupload.controller;

import com.google.api.client.util.Value;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.ftp.entity.Ftp;
import org.jeecg.modules.ftp.until.Test;
import org.jeecg.modules.restfulupload.entity.AudioUpload;
import org.jeecg.modules.restfulupload.entity.DocUpload;
import org.jeecg.modules.restfulupload.entity.PictureUpload;
import org.jeecg.modules.restfulupload.entity.VideoUpload;
import org.jeecg.modules.restfulupload.model.*;
import org.jeecg.modules.restfulupload.service.IAudioUploadService;
import org.jeecg.modules.restfulupload.service.IDocUploadService;
import org.jeecg.modules.restfulupload.service.IPictureUploadService;
import org.jeecg.modules.restfulupload.service.IVideoUploadService;
import org.jeecg.modules.restfulupload.util.AudioUntil;
import org.jeecg.modules.restfulupload.util.DocUntil;
import org.jeecg.modules.restfulupload.util.PictureUntil;
import org.jeecg.modules.restfulupload.util.VideoUntitl;
import org.jeecg.modules.system.service.ISysDepartService;
import org.jeecg.modules.system.service.ISysUserDepartService;
import org.jeecg.modules.system.service.ISysUserRoleService;
import org.jeecg.modules.system.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;

/**
 * <p>
 * 用于数据上传
 * </p>
 *
 * @Author scott
 * @since 2018-12-20
 */
@Slf4j
@RestController
@RequestMapping("/restful/upload")
public class RestfulUploadController {
    @Autowired
    private IAudioUploadService audioUploadService;

    @Autowired
    private IDocUploadService docUploadService;

    @Autowired
    private IPictureUploadService pictureUploadService;

    @Autowired
    private IVideoUploadService videoUploadService;

    /**
     * 测试接口
     * @param testModel
     * @return
     */
    @RequestMapping(value = "/testModel", method = RequestMethod.POST)
    public Result<TestModel> testModel(@RequestBody TestModel testModel) {
        Result<TestModel> result = new Result<TestModel>();
        String createname=  testModel.getCreateBy();
        Date createDate=  testModel.getCreateDate();
        String updatename= testModel.getUpdateBy();
        Date updateDate= testModel.getUpdateDate();
        return result;
    }
    /**
     * 文档上传接口
     * @param docUploadModel
     * @return
     */
    @RequestMapping(value = "/docUpload", method = RequestMethod.POST)
    public Result<DocUploadModel> docUpload(@RequestBody DocUploadModel docUploadModel) {

        Result<DocUploadModel> result = new Result<DocUploadModel>();
        DocUpload docUpload=new DocUpload();
        String  returnInformation= DocUntil.docVerification(docUploadModel);
        result.setResult(docUploadModel);
        if(returnInformation.equals("trues")){
            File file=docUploadModel.getFile();
            try {
                Test.uploadFile(file);
                result.setCode(1);
                result.setMessage("上传成功");
                result.success("true");
            }catch (Exception e){
                result.setCode(0);
                result.setMessage("生成文件失败");
                result.success("false");
            }
            result.setCode(1);
            result.setMessage("上传成功");
            result.success("true");
            result.setCode(1);
            result.setMessage("上传成功");
            result.success("true");
        }else{
            result.setCode(0);
            result.setMessage(returnInformation);
            result.success("false");
        }
        BeanUtils.copyProperties(docUploadModel,docUpload);

        docUploadService.saveDocUpload(docUpload);
        return result;
    }

    /**
     * 音频文件上传
     * @param audioUploadModel
     * @returna
     */
    @RequestMapping(value = "/audioUpload", method = RequestMethod.POST)
    public Result<AudioUploadModel> audioUpload(@RequestBody AudioUploadModel audioUploadModel) {
        Result<AudioUploadModel> result = new Result<AudioUploadModel>();
        AudioUpload audioUpload=new AudioUpload();
        String  returnInformation= AudioUntil.audioUntil(audioUploadModel);
        result.setResult(audioUploadModel);
        if(returnInformation.equals("trues")){

            File file=audioUploadModel.getFile();
            try {
                Test.uploadFile(file);
                result.setCode(1);
                result.setMessage("上传成功");
                result.success("true");
            }catch (Exception e){
                result.setCode(0);
                result.setMessage("生成文件失败");
                result.success("false");
            }
            result.setCode(1);
            result.setMessage("上传成功");
            result.success("true");
        }else{
            result.setCode(0);
            result.setMessage(returnInformation);
            result.success("false");
        }
        BeanUtils.copyProperties(audioUploadModel,audioUpload);

        audioUploadService.saveAudioUpload(audioUpload);
        return result;
    }

    /**
     * 视频文件上传
     * @paramdocUpload
     * @return
     */
    @RequestMapping(value = "/VideoUpload", method = RequestMethod.POST)
    public Result<VideoUploadModel> videoUpload(@RequestBody VideoUploadModel videoUploadModel) {
        Result<VideoUploadModel> result = new Result<VideoUploadModel>();
        VideoUpload videoUpload=new VideoUpload();
        String  returnInformation= VideoUntitl.videoUntitl(videoUploadModel);
        result.setResult(videoUploadModel);
        if(returnInformation.equals("trues")){
            File file=videoUploadModel.getFile();
            try {
                Test.uploadFile(file);
                result.setCode(1);
                result.setMessage("上传成功");
                result.success("true");
            }catch (Exception e){
                result.setCode(0);
                result.setMessage("生成文件失败");
                result.success("false");
            }
        }else{
            result.setCode(0);
            result.setMessage(returnInformation);
            result.success("false");
        }
        BeanUtils.copyProperties(videoUploadModel,videoUpload);//对象转换

        videoUploadService.saveVideoUpload(videoUpload);
        return result;
    }

    /**
     * 图片文件上传
     * @param pictureUploadModel
     * @return
     */
    @RequestMapping(value = "/pictureUpload", method = RequestMethod.POST)
    public Result<PictureUploadModel> pictureUpload(@RequestBody PictureUploadModel pictureUploadModel) {
        Result<PictureUploadModel> result = new Result<PictureUploadModel>();
        PictureUpload pictureUpload=new PictureUpload();
        String  returnInformation= PictureUntil.pictureUntil(pictureUploadModel);//校验必填字段
        result.setResult(pictureUploadModel);
        if(returnInformation.equals("trues")){
            File file=pictureUploadModel.getFile();
           try {
               Test.uploadFile(file);
               result.setCode(1);
               result.setMessage("上传成功");
               result.success("true");
           }catch (Exception e){
               result.setCode(0);
               result.setMessage("生成文件失败");
               result.success("false");
           }

        }else{
            result.setCode(0);
            result.setMessage(returnInformation);
            result.success("false");
        }
        BeanUtils.copyProperties(pictureUploadModel,pictureUpload);//对象转换

        pictureUploadService.savePictureUpload(pictureUpload);//保存上传图片
        return result;
    }

}

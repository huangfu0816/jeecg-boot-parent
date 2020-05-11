package org.jeecg.modules.restfulupload.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 文档上传
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
@ApiModel(value="文档上传对象", description="文档上传对象")
public class DocUploadModel implements Serializable {
    private String appid;//appid
    private String sign;//签名
    private String title;//文件标题
    private String group_id;//文档所属分类2默认，29移动采集，31活动
    private String admin_id;//对应后台用户
    private File file;//文件对象

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

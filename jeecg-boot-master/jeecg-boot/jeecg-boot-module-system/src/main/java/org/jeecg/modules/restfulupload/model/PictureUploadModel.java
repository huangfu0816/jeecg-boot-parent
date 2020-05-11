package org.jeecg.modules.restfulupload.model;

import java.io.File;

public class PictureUploadModel {
    private String appid;//云平台id
    private String sign;//签名
    private String title;//文件标题
    private String compress;//是否压缩0不压缩，1压缩，默认为0
    private String water;//是否打水印：0不打水印，1-9：打水印，位置依次为上左、上中、上右、中左、中、中右、下左、下中、下右、默认为9
    private String waterpic;//水印编号，water为1-9时有效
    private String group_id;//图片所属分类 2默认，7爆料，9移动采集，11活动，12拍客图片
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

    public String getCompress() {
        return compress;
    }

    public void setCompress(String compress) {
        this.compress = compress;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getWaterpic() {
        return waterpic;
    }

    public void setWaterpic(String waterpic) {
        this.waterpic = waterpic;
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

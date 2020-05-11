package org.jeecg.modules.restfulupload.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 图片上传
 * @Author: jeecg-boot
 * @Date:   2020-05-08
 * @Version: V1.0
 */
@Data
@TableName("tb_picture_upload")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_picture_upload对象", description="图片上传")
public class PictureUpload implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
	@Excel(name = "更新人", width = 15)
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;
	/**文件标题*/
	@Excel(name = "文件标题", width = 15)
    @ApiModelProperty(value = "文件标题")
    private String title;
	/**picture*/
	@Excel(name = "picture", width = 15)
    @ApiModelProperty(value = "picture")
    private String resType;
	/**文件类型*/
	@Excel(name = "文件类型", width = 15)
    @ApiModelProperty(value = "文件类型")
    private String type;
	/**文件相对路径*/
	@Excel(name = "文件相对路径", width = 15)
    @ApiModelProperty(value = "文件相对路径")
    private String filePath;
	/**原图文件名*/
	@Excel(name = "原图文件名", width = 15)
    @ApiModelProperty(value = "原图文件名")
    private String picN;
	/**大图文件名*/
	@Excel(name = "大图文件名", width = 15)
    @ApiModelProperty(value = "大图文件名")
    private String picW;
	/**小图文件名*/
	@Excel(name = "小图文件名", width = 15)
    @ApiModelProperty(value = "小图文件名")
    private String picM;
	/**缩略图文件名*/
	@Excel(name = "缩略图文件名", width = 15)
    @ApiModelProperty(value = "缩略图文件名")
    private String picS;
	/**原图高度*/
	@Excel(name = "原图高度", width = 15)
    @ApiModelProperty(value = "原图高度")
    private String higthN;
	/**大图高度*/
	@Excel(name = "大图高度", width = 15)
    @ApiModelProperty(value = "大图高度")
    private String higthW;
	/**小图高度*/
	@Excel(name = "小图高度", width = 15)
    @ApiModelProperty(value = "小图高度")
    private String higthM;
	/**缩略图高度*/
	@Excel(name = "缩略图高度", width = 15)
    @ApiModelProperty(value = "缩略图高度")
    private String higthS;
	/**原图宽度*/
	@Excel(name = "原图宽度", width = 15)
    @ApiModelProperty(value = "原图宽度")
    private String widthN;
	/**大图宽度*/
	@Excel(name = "大图宽度", width = 15)
    @ApiModelProperty(value = "大图宽度")
    private String widthW;
	/**小图宽度*/
	@Excel(name = "小图宽度", width = 15)
    @ApiModelProperty(value = "小图宽度")
    private String widthM;
	/**缩略图宽度*/
	@Excel(name = "缩略图宽度", width = 15)
    @ApiModelProperty(value = "缩略图宽度")
    private String widthS;
	/**原图大小*/
	@Excel(name = "原图大小", width = 15)
    @ApiModelProperty(value = "原图大小")
    private String sizeN;
	/**大图大小*/
	@Excel(name = "大图大小", width = 15)
    @ApiModelProperty(value = "大图大小")
    private String sizeW;
	/**小图大小*/
	@Excel(name = "小图大小", width = 15)
    @ApiModelProperty(value = "小图大小")
    private String sizeM;
	/**缩略图大小*/
	@Excel(name = "缩略图大小", width = 15)
    @ApiModelProperty(value = "缩略图大小")
    private String sizeS;
	/**原图路径*/
	@Excel(name = "原图路径", width = 15)
    @ApiModelProperty(value = "原图路径")
    private String picPathN;
	/**大图路径*/
	@Excel(name = "大图路径", width = 15)
    @ApiModelProperty(value = "大图路径")
    private String picPathW;
	/**小图路径*/
	@Excel(name = "小图路径", width = 15)
    @ApiModelProperty(value = "小图路径")
    private String picPathM;
	/**缩略图路径*/
	@Excel(name = "缩略图路径", width = 15)
    @ApiModelProperty(value = "缩略图路径")
    private String picPathS;
	/**上传用户appid*/
	@Excel(name = "上传用户appid", width = 15)
    @ApiModelProperty(value = "上传用户appid")
    private String appid;
	/**平台用户id*/
	@Excel(name = "平台用户id", width = 15)
    @ApiModelProperty(value = "平台用户id")
    private String platformid;
	/**拓展字段1*/
	@Excel(name = "拓展字段1", width = 15)
    @ApiModelProperty(value = "拓展字段1")
    private String fdExt01;
	/**拓展字段2*/
	@Excel(name = "拓展字段2", width = 15)
    @ApiModelProperty(value = "拓展字段2")
    private String fdExt02;
	/**拓展字段3*/
	@Excel(name = "拓展字段3", width = 15)
    @ApiModelProperty(value = "拓展字段3")
    private String fdExt03;
	/**签名*/
	@Excel(name = "签名", width = 15)
    @ApiModelProperty(value = "签名")
    private String sign;
	/**是否压缩*/
	@Excel(name = "是否压缩", width = 15)
    @ApiModelProperty(value = "是否压缩")
    private String compress;
	/**是否水印*/
	@Excel(name = "是否水印", width = 15)
    @ApiModelProperty(value = "是否水印")
    private String water;
	/**水印编号*/
	@Excel(name = "水印编号", width = 15)
    @ApiModelProperty(value = "水印编号")
    private String waterpic;
	/**图片所属分类*/
	@Excel(name = "图片所属分类", width = 15)
    @ApiModelProperty(value = "图片所属分类")
    private String groupId;
	/**对应后台用户*/
	@Excel(name = "对应后台用户", width = 15)
    @ApiModelProperty(value = "对应后台用户")
    private String adminId;
}

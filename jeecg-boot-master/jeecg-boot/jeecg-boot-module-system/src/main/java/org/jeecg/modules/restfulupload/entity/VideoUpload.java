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
 * @Description: 视频文件参数
 * @Author: jeecg-boot
 * @Date:   2020-05-08
 * @Version: V1.0
 */
@Data
@TableName("tb_video_upload")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="tb_video_upload对象", description="视频文件参数")
public class VideoUpload implements Serializable {
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
	/**上传用户id*/
	@Excel(name = "上传用户id", width = 15)
    @ApiModelProperty(value = "上传用户id")
    private String appid;
	/**签名*/
	@Excel(name = "签名", width = 15)
    @ApiModelProperty(value = "签名")
    private String sign;
	/**文件标题*/
	@Excel(name = "文件标题", width = 15)
    @ApiModelProperty(value = "文件标题")
    private String title;
	/**video*/
	@Excel(name = "video", width = 15)
    @ApiModelProperty(value = "video")
    private String groupId;
	/**文件类型*/
	@Excel(name = "文件类型", width = 15)
    @ApiModelProperty(value = "文件类型")
    private String videoType;
	/**文件相对路径*/
	@Excel(name = "文件相对路径", width = 15)
    @ApiModelProperty(value = "文件相对路径")
    private String videoUrl;
	/**文件名称*/
	@Excel(name = "文件名称", width = 15)
    @ApiModelProperty(value = "文件名称")
    private String videoName;
	/**视频大小*/
	@Excel(name = "视频大小", width = 15)
    @ApiModelProperty(value = "视频大小")
    private String videoSize;
	/**视频时长*/
	@Excel(name = "视频时长", width = 15)
    @ApiModelProperty(value = "视频时长")
    private String videoDate;
	/**视频封面图路径访问*/
	@Excel(name = "视频封面图路径访问", width = 15)
    @ApiModelProperty(value = "视频封面图路径访问")
    private String videoUrls;
	/**视频访问路径*/
	@Excel(name = "视频访问路径", width = 15)
    @ApiModelProperty(value = "视频访问路径")
    private String videoUrlss;
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
	/**对应后台用户*/
	@Excel(name = "对应后台用户", width = 15)
    @ApiModelProperty(value = "对应后台用户")
    private String adminId;
}

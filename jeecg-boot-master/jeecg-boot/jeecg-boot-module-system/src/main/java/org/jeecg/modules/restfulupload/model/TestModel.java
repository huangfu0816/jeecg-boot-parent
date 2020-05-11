package org.jeecg.modules.restfulupload.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value="文档上传对象", description="文档上传对象")
public class TestModel {
    /**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
    /**创建人*/
    @ApiModelProperty(value = "创建人")
    private String updateBy;
    /**创建时间*/
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    /**创建人*/
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}

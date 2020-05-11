package org.jeecg.modules.ftp.until;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.restfulupload.model.VerificationEntity;

import java.io.File;

/**
 *获取文件的大小及名称
 */
public class Verification {
    public Result<VerificationEntity> verification(){
        Result<VerificationEntity> ver= new Result<VerificationEntity>();
        VerificationEntity verificationEntity=new VerificationEntity();
        File file = new File("D://1000个典型区块项目详情汇总.zip");
        String fileName = file.getName();
        verificationEntity.setName(fileName);
        verificationEntity.setSizes(String.valueOf(file.length()));
        ver.setResult(verificationEntity);
        return ver;
    }
}

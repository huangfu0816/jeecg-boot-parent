package org.jeecg.modules.restfulupload.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成文件保存路径
 * appid 机构名称编码
 * fileName 文件类型
 */
public class ReturnUrlUntil {
    public static String returnUrl(String appid,String fileName){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf1=new SimpleDateFormat("MM");
        SimpleDateFormat sdf2=new SimpleDateFormat("dd");
        String year=sdf.format(date);
        String yue=sdf1.format(date);
        String day=sdf2.format(date);
        String url="e:/"+appid+"/"+fileName+"/"+year+yue+"/"+day;
        return url;
    }
}

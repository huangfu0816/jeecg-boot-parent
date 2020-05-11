package org.jeecg.modules.ftp.until;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
/**
 * 文件上传
 * @author huang
 *
 */
public class Test {

    private  FTPClient ftp;
    /**
     *
     * @param path 上传到ftp服务器哪个路径下
     * @param addr 地址
     * @param port 端口号
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    private  boolean connect(String path,String addr,int port,String username,String password) throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr,port);
        ftp.login(username,password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        ftp.changeWorkingDirectory(path);
        result = true;
        return result;
    }
    /**
     *
     * @param file 上传的文件或文件夹
     * @throws Exception
     */
    private void upload(File file) throws Exception{
        if(file.isDirectory()){
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath()+"\\"+files[i] );
                if(file1.isDirectory()){
                    upload(file1);
                    ftp.changeToParentDirectory();
                }else{
                    File file2 = new File(file.getPath()+"\\"+files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        }else{
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.storeFile(file2.getName(), input);
            input.close();
        }
    }
    public static boolean uploadFile(File file)  {
            //上传到固定文件夹，不可以自动上传到文件夹
        Test test=new Test();
        try {
            test.connect("/ftp/ftp/ss", "192.168.0.200", 21, "ftp", "ftp");
            } catch (Exception e) {
                System.out.println("连接ftp服务器异常");
                e.printStackTrace();
            return false;
        }
        try {
            test.upload(file);
            } catch (Exception e) {
                System.out.println("文件上传失败");
                e.printStackTrace();
                return false;
            }
         return true;
    }

    public static void main(String[] args) throws Exception{
        //上传到固定文件夹，不可以自动上传到文件夹
        Test t = new Test();
        t.connect("/ftp/ftp/ss", "192.168.0.200", 21, "ftp", "ftp");
        File file = new File("E:/lanlian.dmp");
        try {
            t.upload(file);
        } catch (Exception e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
        }

    }
}  
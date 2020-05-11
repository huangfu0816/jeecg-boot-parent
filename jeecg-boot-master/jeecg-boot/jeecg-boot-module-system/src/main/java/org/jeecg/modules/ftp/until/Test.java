package org.jeecg.modules.ftp.until;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
/**
 * �ļ��ϴ�
 * @author huang
 *
 */
public class Test {

    private  FTPClient ftp;
    /**
     *
     * @param path �ϴ���ftp�������ĸ�·����
     * @param addr ��ַ
     * @param port �˿ں�
     * @param username �û���
     * @param password ����
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
     * @param file �ϴ����ļ����ļ���
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
            //�ϴ����̶��ļ��У��������Զ��ϴ����ļ���
        Test test=new Test();
        try {
            test.connect("/ftp/ftp/ss", "192.168.0.200", 21, "ftp", "ftp");
            } catch (Exception e) {
                System.out.println("����ftp�������쳣");
                e.printStackTrace();
            return false;
        }
        try {
            test.upload(file);
            } catch (Exception e) {
                System.out.println("�ļ��ϴ�ʧ��");
                e.printStackTrace();
                return false;
            }
         return true;
    }

    public static void main(String[] args) throws Exception{
        //�ϴ����̶��ļ��У��������Զ��ϴ����ļ���
        Test t = new Test();
        t.connect("/ftp/ftp/ss", "192.168.0.200", 21, "ftp", "ftp");
        File file = new File("E:/lanlian.dmp");
        try {
            t.upload(file);
        } catch (Exception e) {
            System.out.println("�ļ��ϴ�ʧ��");
            e.printStackTrace();
        }

    }
}  
package org.jeecg.modules.ftp.until;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
/**
 * 文件下载
 * @author huang
 *
 */
public class FtpApche {
	private static FTPClient ftpClient = new FTPClient();
	private static String encoding = System.getProperty("file.encoding");

	/**
	 * Description: 从FTP服务器下载文件
	 *
	 * @Version1.0
	 *
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static boolean downFile(String url, int port, String username, String password, String remotePath,
								   String fileName, String localPath) {
		boolean result = false;
		try {
			int reply;
			ftpClient.setControlEncoding(encoding);

			/*
			 * 为了上传和下载中文文件，有些地方建议使用以下两句代替 new
			 * String(remotePath.getBytes(encoding),"iso-8859-1")转码。 经过测试，通不过。
			 */
			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
			conf.setServerLanguageCode("zh");

			ftpClient.connect(url, port);
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftpClient.login(username, password);// 登录
			// 设置文件传输类型为二进制
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			// 获取ftp登录应答代码
			reply = ftpClient.getReplyCode();
			// 验证是否登陆成功
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.err.println("FTP server refused connection.");
				return result;
			}
			// 转移到FTP服务器目录至指定的目录下
			ftpClient.changeWorkingDirectory(new String(remotePath.getBytes(encoding), "iso-8859-1"));
			// 获取文件列表
			FTPFile[] fs = ftpClient.listFiles();
			localPath=new String(localPath.getBytes("GBK"),"UTF-8");//设置生成文件夹编码格式
			File file = new File(localPath);
			if (!file.exists()) {
				file.mkdirs();
			}

			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "/" + ff.getName());

					OutputStream is = new FileOutputStream(localFile);
					ftpClient.retrieveFile(ff.getName(), is);
					is.close();
				}
			}

			ftpClient.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}

	/**
	 * 将FTP服务器上文件下载到本地 * 10.150.41.94 * 21 * dx *
	 */
	public void testDownFile(String resourceFolder, String fileName, String targetFolder) {
		try {
			String dataServerIp = "192.168.0.200";
			String dataServerUsername = "ftp";
			String dataServerPassword ="ftp";
			boolean flag = downFile(dataServerIp, 21, dataServerUsername, dataServerPassword, resourceFolder, fileName,
					targetFolder);
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//把文件下载到固定文件夹中
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		SimpleDateFormat sdf1=new SimpleDateFormat("MM");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd");
		String year=sdf.format(date);
		String yue=sdf1.format(date);
		String day=sdf2.format(date);
		String url="e:/镇雄/"+year+yue+"/"+day;
		FtpApche fa = new FtpApche();
		// FTP服务器的文件夹的路径，文件名称，要存放的服务器的路径
		fa.testDownFile("ftp\\ftp\\ss", "lanlian.dmp", url);
	}
}
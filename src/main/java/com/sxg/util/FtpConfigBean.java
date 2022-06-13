package com.sxg.util;



import java.io.Serializable;


/**
 * Ftp配置信息基对象 <一句话功能简述> <功能详细描述>
 * 
 * @author xielin
 * @version [版本号, 2015-11-21]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FtpConfigBean implements Serializable
{
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1009450190904694884L;
    
    /**
     * FTP服务器的ip地址
     */
    private String ipAddress;
    
    /**
     * 端口
     */
    private int port;
    
    /**
     * 用户名
     */
    private String userName;
    
    /**
     * 密码
     */
    private String passWord;
    
    /**
     * 超时时间
     */
    private int timeout;
    
    /**
     * 上传基路径
     */
    private String ftpFilePath;
    
    /**
     * 上传文件路径
     */
    private String localFilePath;
    
    /**
     * 备份基路径
     */
    private String backupPath;
    
    /**
     * 编码类型 - 如UTF-8、GBK等
     */
    private String encoding;
    
    /**
     * 是否备份文件
     */
    private boolean isBackup;
    
    /**
     * 需要下载文件名规格
     */
    private String fileNameTemp;
    /**
     * 文件上传的路径
     */
    private String uploadPath;
    
    private String fileNameType;//匹配文件名类型,如:*order.txt
    
    public String getFileNameType() {
		return fileNameType;
	}

	public void setFileNameType(String fileNameType) {
		this.fileNameType = fileNameType;
	}

	public String getIpAddress()
    {
        return ipAddress;
    }
    
    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }
    
    public int getPort()
    {
        return port;
    }
    
    public void setPort(int port)
    {
        this.port = port;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPassWord()
    {
        return passWord;
    }
    
    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }
    
    public int getTimeout()
    {
        return timeout;
    }
    
    public void setTimeout(int timeout)
    {
        this.timeout = timeout;
    }
    
    public String getFtpFilePath()
    {
        return ftpFilePath;
    }
    
    public void setFtpFilePath(String ftpFilePath)
    {
        this.ftpFilePath = ftpFilePath;
    }
    
    public String getLocalFilePath()
    {
        return localFilePath;
    }
    
    public void setLocalFilePath(String localFilePath)
    {
        this.localFilePath = localFilePath;
    }
    
    public String getBackupPath()
    {
        return backupPath;
    }
    
    public void setBackupPath(String backupPath)
    {
        this.backupPath = backupPath;
    }
    
    public String getEncoding()
    {
        return encoding;
    }
    
    public void setEncoding(String encoding)
    {
        this.encoding = encoding;
    }
    
    public boolean isBackup()
    {
        return isBackup;
    }
    
    public void setBackup(boolean isBackup)
    {
        this.isBackup = isBackup;
    }
    
    public String getFileNameTemp()
    {
        return fileNameTemp;
    }
    
    public void setFileNameTemp(String fileNameTemp)
    {
        this.fileNameTemp = fileNameTemp;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }


    
}

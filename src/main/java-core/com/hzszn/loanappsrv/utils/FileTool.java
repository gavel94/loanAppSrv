package com.hzszn.loanappsrv.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@Component
public class FileTool implements ApplicationContextAware
{

    private static String FILE_PATH = System.getProperty("user.dir") + "/../file_upload";

    /**
     * 保存临时文件
     * @param type
     * @param userId
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public static String saveFileSyncTmp(String type, Integer userId, MultipartFile multipartFile) throws IOException {
//        TSysProperty tSysProperty = SysPropertyTool.getProperty(SysPropertyTypeEnum.FILE_BUSINESS_TYPE, type);
        //验证允许上传的业务类型 或者 文件是否为空
        if (null == multipartFile || multipartFile.isEmpty())
        {
            return "err:上传的文件为空";
        }
//        if (null == tSysProperty)
//        {
//            return "err:不支持的业务类型";
//        }

        long curTime = System.currentTimeMillis();
        String fileName = type + "_" + userId + "_" + curTime;      //文件名规则

        //验证业务类型对应的文件类型
//        if (null != multipartFile && !multipartFile.isEmpty())
//        {
//            String endfix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf(".") + 1, multipartFile.getOriginalFilename().length());
//            if (0 > tSysProperty.getPropertyValue().indexOf(endfix))
//            {
//                return "err:不支持的文件类型";
//            }
//
//            fileName += "." + endfix;
//        }

        //保存到临时目录
        String path = FILE_PATH + "/temp/" + type + "/" + userId + "/";
        File dirTmp = new File(path);
        if (!dirTmp.exists())
        {
            dirTmp.mkdirs();
        }
        File fileTmp = new File(path + fileName);
        if (fileTmp.exists())
        {
            fileTmp.delete();
        }
        fileTmp.createNewFile();
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), fileTmp);

        //定时删除
//        taskScheduler.schedule(() -> {
//            fileTmp.delete();
//        }, new Date(curTime + Long.decode(SysPropertyTool.getProperty(SysPropertyTypeEnum.SYS, KeyEnum.SYS_TMP_DEL_TIMER_KEY).getPropertyValue()) * 3600 * 1000));


        return fileName;
    }

    /**
     * 保存文件
     * @param fileName
     */
    public static boolean saveFileSync(String fileName) throws IOException {
        String[] strs = verifyFileName(fileName);
        if (null == strs) {
            return false;
        }
        File srcFile = new File(FILE_PATH + "/temp/" + strs[0] + "/" + strs[1] + "/" + fileName);

        File destFile = new File(FILE_PATH + "/" + strs[0] + "/" + strs[1] + "/" + fileName);
        if(!srcFile.exists()) {
            if(!destFile.exists()){
                return false;
            }else {
                return true;
            }

        }
        String path = FILE_PATH + "/" + strs[0] + "/" + strs[1] + "/";
        File fileTmp = new File(path + fileName);
        fileTmp.delete();
        FileUtils.moveFile(srcFile, destFile);

        return true;
    }

    /**
     * 根据文件名获取文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static File getFile(String fileName) throws IOException {
        String[] strs = verifyFileName(fileName);
        if (null == strs) {
            throw new IOException("文件名非法");
        }
        File fileResult = new File(FILE_PATH + "/" + strs[0] + "/" + strs[1] + "/" + fileName);
        if (!fileResult.exists()) {
            //LogTool.BIZ_LOG.debug("文件不存在");
            return null;
        }

        return fileResult;
    }

    /**
     * 根据文件名获取临时文件
     * @param fileName
     * @return
     */
    public static File getFileTmp(String fileName) throws IOException {
        String[] strs = verifyFileName(fileName);
        if (null == strs) {
            throw new IOException("文件名非法");
        }
        File fileResult = new File(FILE_PATH + "/temp/" + strs[0] + "/" + strs[1] + "/" + fileName);
        if (!fileResult.exists()) {
            return null;
        }

        return fileResult;
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    public static void delFile(String fileName) {
        String[] strs = verifyFileName(fileName);
        if (null == strs) {
            return;
        }
        File fileResult = new File(FILE_PATH + "/" + strs[0] + "/" + strs[1] + "/" + fileName);
        if (!fileResult.exists()) {
            fileResult.delete();
            return;
        }
    }

    /**
     * 重写文件
     *
     * @param fileName
     * @param file
     * @return
     * @throws IOException
     */
    public static boolean rewriteFile(String fileName, MultipartFile file) throws IOException {
        String[] strs = verifyFileName(fileName);
        if (null == strs) {
            return false;
        }
        File fileResult = new File(FILE_PATH + "/" + strs[0] + "/" + strs[1] + "/" + fileName);
        if (!fileResult.exists()) {
            fileResult.createNewFile();
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(), fileResult);

        return true;
    }

    private static String[] verifyFileName(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        String[] strs = fileName.split("_");
        if (strs.length != 3) {
            return null;
        }

        return strs;
    }

    /**
     * 保存临时文件
     *
     * @return
     * @throws IOException
     */
    public static String saveFileSyncTmpAvatar(String type, Integer userId, MultipartFile multipartFile, String fileName) throws IOException {
//        TSysProperty tSysProperty = SysPropertyTool.getProperty(SysPropertyTypeEnum.FILE_BUSINESS_TYPE, type);
        //验证允许上传的业务类型 或者 文件是否为空
        if (null == multipartFile || multipartFile.isEmpty()) {
            return "err:上传的文件为空";
        }
//        if (null == tSysProperty) {
//            return "err:不支持的业务类型";
//        }

        long curTime = System.currentTimeMillis();
        if (StringUtils.isBlank(fileName)) {
            fileName = type + "_" + userId + "_" + curTime;//文件名规则
        }
        //验证业务类型对应的文件类型
//        if (null != multipartFile && !multipartFile.isEmpty()) {
//            String endfix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf(".") + 1, multipartFile.getOriginalFilename().length());
//            if (0 > tSysProperty.getPropertyValue().indexOf(endfix)) {
//                return "err:不支持的文件类型";
//            }
//            if (!fileName.contains(".")) {
//                fileName += "." + endfix;
//            }
//        }

        //保存到临时目录
        String path = FILE_PATH + "/temp/" + type + "/" + userId + "/";
        File dirTmp = new File(path);
        if (!dirTmp.exists()) {
            dirTmp.mkdirs();
        }
        File fileTmp = new File(path + fileName);
        if (fileTmp.exists()) {
            fileTmp.delete();
        }
        fileTmp.createNewFile();
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), fileTmp);

//        //定时删除
//        taskScheduler.schedule(() -> {
//            fileTmp.delete();
//        }, new Date(curTime + Long.decode(SysPropertyTool.getProperty(SysPropertyTypeEnum.SYS, KeyEnum.SYS_TMP_DEL_TIMER_KEY).getPropertyValue()) * 3600 * 1000));


        return fileName;
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {

    }
}

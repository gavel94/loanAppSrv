package com.hzszn.loanappsrv.service.impl;

import com.hzszn.loanappsrv.model.ServiceResult;
import com.hzszn.loanappsrv.service.facade.ResService;
import com.hzszn.loanappsrv.utils.FileTool;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@Service
@Primary
public class ResServiceimpl implements ResService
{
    public ServiceResult uploadImage(MultipartFile[] file, Integer userId)
    {
        try
        {
            for (MultipartFile f : file)
            {
                String fileName = FileTool.saveFileSyncTmp("5", userId, f);
                if (fileName.startsWith("err:"))
                {
                    return ServiceResult.failure(fileName, ObjectUtils.NULL);
                }
                if (!FileTool.saveFileSync(fileName))
                {
                    return ServiceResult.failure("保存验证图片失败", ObjectUtils.NULL);
                }
            }
        } catch (IOException e)
        {
            return ServiceResult.failure("保存验证图片异常", ObjectUtils.NULL);
        }
        return ServiceResult.success("上传图片成功");
    }

}

package com.hzszn.loanappsrv.service.facade;

import com.hzszn.loanappsrv.model.ServiceResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
public interface ResService
{
    ServiceResult uploadImage(MultipartFile[] file, Integer checkId);
}

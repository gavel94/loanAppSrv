package com.hzszn.loanappsrv.controller;

import com.hzszn.loanappsrv.base.BaseApiContorller;
import com.hzszn.loanappsrv.model.JsonResponse;
import com.hzszn.loanappsrv.model.ServiceResult;
import com.hzszn.loanappsrv.service.facade.ResService;
import com.hzszn.loanappsrv.utils.JsonResponseTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：资源
 */
@SuppressWarnings("unchecked")
@RestController()
@RequestMapping("/res")
public class ResController extends BaseApiContorller
{
    @Autowired
    private ResService resService;
    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public JsonResponse<String> uploadImage(@RequestParam("file") MultipartFile[] file, @RequestParam Integer userId)
    {
        if (0 >= file.length) {
            return JsonResponseTool.authFailure("未上传文件");
        }

        ServiceResult serviceResult = resService.uploadImage(file, userId);

        if (!serviceResult.getFlag()) {
            return JsonResponseTool.failure(serviceResult.getMessage());
        }


        return JsonResponseTool.success(serviceResult.getMessage());
    }
}

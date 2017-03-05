package com.hzszn.loanappsrv.controller;

import com.hzszn.loanappsrv.base.BaseApiContorller;
import com.hzszn.loanappsrv.model.JsonResponse;
import com.hzszn.loanappsrv.utils.JsonResponseTool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：资源
 */
@RestController()
@RequestMapping("/res")
public class ResController extends BaseApiContorller
{
    public JsonResponse<String> uploadImage(@RequestParam("file") MultipartFile[] file, @RequestParam Integer checkId)
    {
        if (0 >= file.length) {
            return JsonResponseTool.authFailure("未上传文件");
        }



        return JsonResponseTool.success("");
    }
}

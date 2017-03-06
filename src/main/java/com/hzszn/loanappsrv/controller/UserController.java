package com.hzszn.loanappsrv.controller;

import com.hzszn.loanappsrv.base.BaseApiContorller;
import com.hzszn.loanappsrv.model.JsonResponse;
import com.hzszn.loanappsrv.orm.pojo.User;
import com.hzszn.loanappsrv.service.dto.UserDTO;
import com.hzszn.loanappsrv.service.facade.UserService;
import com.hzszn.loanappsrv.utils.JsonResponseTool;
import com.hzszn.loanappsrv.utils.ProtocolTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jhhuang on 17-3-5
 * QQ:781913268
 * Description：xxx
 */
@RestController()
@RequestMapping("/user")
public class UserController extends BaseApiContorller
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public JsonResponse info(@RequestParam int id) throws Exception
    {
        User user = userService.findUserById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setSex(user.getSex());
        userDTO.setAge(user.getAge());
        System.out.println(userDTO);
        return JsonResponseTool.success(userDTO);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonResponse save(User user) throws Exception
    {
        userService.insertUser(user);
        return JsonResponseTool.success(null);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResponse register(User user) throws Exception
    {
        int userId = userService.insertUser(user);

        return JsonResponseTool.success(ProtocolTool.createToken(user.getId()));
    }
}

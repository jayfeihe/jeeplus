package com.jeeplus.admin.controller;

import com.jeeplus.admin.common.controller.BaseController;
import com.jeeplus.admin.services.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yuzp17311 on 2016/8/24.
 */
@Controller
@RequestMapping("/SysUser")
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;

    /**
     * 登陆
     * @param username 登陆用户名
     * @param password 登陆密码
     * @param captchaCode 验证码
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String password,String captchaCode){

        return null;

    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        return null;
    }

}

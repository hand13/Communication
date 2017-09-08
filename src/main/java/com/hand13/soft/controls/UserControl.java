package com.hand13.soft.controls;

import com.hand13.soft.dao.UserInfoDao;
import com.hand13.soft.domain.Userinfo;
import com.hand13.soft.exception.UserExistdException;
import com.hand13.soft.exception.UserNotExistException;
import com.hand13.soft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hd110 on 2017/9/2.
 */
@Controller
public class UserControl {
    private UserService service;

    public UserService getService() {
        return service;
    }
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping("/index.html")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, Userinfo userinfo){
        try {
            Userinfo info = service.getUserByNameAndPassword(userinfo);
            request.getSession().setAttribute("user",userinfo);
            return new ModelAndView("main");
        }
        catch (UserNotExistException ioe) {
        }
        return new ModelAndView("login","error","not");
    }
    @RequestMapping("/rregiest.html")
    public String rregiest() {
        return "regiest";
    }
    @RequestMapping("/reg.html")
    public ModelAndView reg(HttpServletRequest request,Userinfo userinfo) {
        try {
            service.register(userinfo);
            request.setAttribute("user",userinfo);
            return new ModelAndView("main");
        }
        catch (UserExistdException ioe) {

        }
        return new ModelAndView("login","error","exist");
    }
}

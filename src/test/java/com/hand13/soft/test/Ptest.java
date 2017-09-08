package com.hand13.soft.test;
import com.hand13.soft.dao.FriendDao;
import com.hand13.soft.dao.UserInfoDao;
import com.hand13.soft.domain.Friend;
import com.hand13.soft.domain.Userinfo;
import com.hand13.soft.exception.UserExistdException;
import com.hand13.soft.exception.UserNotExistException;
import com.hand13.soft.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hd110 on 2017/9/2.
 */
public class Ptest {
    @Test
    public void ts()throws UserExistdException {
        ApplicationContext acx = new ClassPathXmlApplicationContext("spring-bean.xml");
        UserService userService = acx.getBean(UserService.class);
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("xgh");
        userinfo.setPassword("321893");
        userService.register(userinfo);
    }
}

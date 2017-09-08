package com.hand13.soft.dao;

import com.hand13.soft.domain.Userinfo;
import com.hand13.soft.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hd110 on 2017/9/2.
 */
@Repository
public class IdToNameDao {
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public String getNameById(Integer i) throws UserNotExistException{
        String fd = "from Userinfo u where u.id = ?";
        List s = template.find(fd,i);
        if(s.size() == 0) {
            throw new UserNotExistException("no body");
        } else {
            Userinfo userinfo = (Userinfo) s.get(0);
            return userinfo.getUsername();
        }
    }
    public Integer getIdByName(String username)throws UserNotExistException {
        String fd = "from Userinfo u where u.username = ?";
        List s = template.find(fd,username);
        if(s.size() == 0) {
            throw new UserNotExistException("no body");
        } else {
            Userinfo userinfo = (Userinfo) s.get(0);
            return userinfo.getId();
        }
    }
}

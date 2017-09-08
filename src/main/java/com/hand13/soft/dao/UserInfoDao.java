package com.hand13.soft.dao;

import com.hand13.soft.domain.Userinfo;
import com.hand13.soft.exception.UserExistdException;
import com.hand13.soft.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by hd110 on 2017/9/2.
 */
@Repository
public class UserInfoDao {
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public boolean saveUser(Userinfo userinfo) throws UserExistdException {
        String fd = "from Userinfo u where u.username = ?";
        List tmp = template.find(fd,userinfo.getUsername());
        if(tmp.size() != 0) {
            throw new UserExistdException("YONG HU YI CHUNG ZAI");
        } else {
            template.save(userinfo);
            return true;
        }
    }
    public Userinfo getUser(Userinfo userinfo)throws UserNotExistException {
        String fd = "from Userinfo u where u.username = ? and u.password = ?";
        List l = template.find(fd,userinfo.getUsername(),userinfo.getPassword());
        if(l.size() == 0) {
            throw new UserNotExistException("no body");
        } else {
            return (Userinfo)l.get(0);
        }
    }
    public void deleteUser(Userinfo userinfo) {
        template.delete(userinfo);
    }

    public void upUser(Userinfo userinfo) {
        template.update(userinfo);
    }
}

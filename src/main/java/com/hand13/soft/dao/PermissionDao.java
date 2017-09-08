package com.hand13.soft.dao;

import com.hand13.soft.domain.Permission;
import org.hibernate.LockMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hd110 on 2017/9/2.
 */
@Repository
public class PermissionDao {
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    public void saveP(Permission permission) {
        template.save(permission);
    }

    public Permission getP(Integer i) {
         return template.get(Permission.class,i);
    }
}

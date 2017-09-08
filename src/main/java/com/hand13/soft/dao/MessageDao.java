package com.hand13.soft.dao;

import com.hand13.soft.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MessageDao {
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void addMessage(Message message) {
        template.save(message);
    }
    public void readMessage(Message message) {
        message.setRead(true);
        template.update(message);
    }
    public void deleteMessage(Message message) {
        template.delete(message);
    }
    public List notRead(Integer userId) {
        String fd = "from Message m where m.userT = ? and m.read = false ";
        List messages = template.find(fd,userId);
        return messages;
    }
    public List getMessage(Integer userId) {
        String fd = "from Message m where m.userT = ?";
        return template.find(fd,userId);
    }
}

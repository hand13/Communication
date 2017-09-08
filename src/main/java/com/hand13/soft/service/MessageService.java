package com.hand13.soft.service;

import com.hand13.soft.dao.MessageDao;
import com.hand13.soft.domain.Message;
import com.hand13.soft.domain.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hd110 on 2017/9/2.
 */
@Service
public class MessageService {
    private MessageDao messageDao;

    public MessageDao getMessageDao() {
        return messageDao;
    }

    @Autowired
    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public void sendMessage(Message message) {
        messageDao.addMessage(message);
    }

    public List getMessage(Userinfo userinfo) {
        return messageDao.getMessage(userinfo.getId());
    }

    public List getNotRead(Userinfo userinfo) {
        return messageDao.notRead(userinfo.getId());
    }

    public void readMessage(Message message) {
        messageDao.readMessage(message);
    }
}

package com.hand13.soft.dao;

import com.hand13.soft.domain.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hd110 on 2017/9/1.
 */
@Repository
public class FriendDao {

    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void addFriend(Friend friend) {
        template.save(friend);
    }
    public List getFriends(Integer userId) {
        List friends;
        String fd = "from Friend f where f.you = ?";
        friends = template.find(fd,userId);
        return friends;
    }
    public void deleteFriend(Friend friend) {
        template.delete(friend);
    }
}

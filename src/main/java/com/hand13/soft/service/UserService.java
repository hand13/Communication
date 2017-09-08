package com.hand13.soft.service;

import com.hand13.soft.dao.FriendDao;
import com.hand13.soft.dao.IdToNameDao;
import com.hand13.soft.dao.UserInfoDao;
import com.hand13.soft.domain.Friend;
import com.hand13.soft.domain.FriendIdAndName;
import com.hand13.soft.domain.Userinfo;
import com.hand13.soft.exception.UserExistdException;
import com.hand13.soft.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hd110 on 2017/9/2.
 */
@Service
public class UserService {
    private UserInfoDao userInfoDao;

    private FriendDao friendDao;

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    @Autowired
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    public FriendDao getFriendDao() {
        return friendDao;
    }

    @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    private IdToNameDao idToNameDao;

    public IdToNameDao getIdToNameDao() {
        return idToNameDao;
    }

    @Autowired
    public void setIdToNameDao(IdToNameDao idToNameDao) {
        this.idToNameDao = idToNameDao;
    }

    public void register(Userinfo userinfo) throws UserExistdException{
        userinfo.setPermissionId(2);
        userInfoDao.saveUser(userinfo);
    }
    public Userinfo getUserByNameAndPassword(Userinfo userinfo) throws UserNotExistException {
        userinfo = userInfoDao.getUser(userinfo);
        return userinfo;
    }
    public void upUser(Userinfo userinfo) {
        userInfoDao.upUser(userinfo);
    }
    public void addFriendById(Userinfo userinfo,Integer friendId)throws UserNotExistException {
        String sd = idToNameDao.getNameById(friendId);
        if(sd != null) {
            Friend friend = new Friend();
            friend.setYou(userinfo.getId());
            friend.setHer(friendId);
            friendDao.addFriend(friend);
        }
    }
    public List<FriendIdAndName> getFriendList(Userinfo userinfo) throws UserNotExistException{
        List l =  friendDao.getFriends(userinfo.getId());
        Iterator i = l.iterator();
        List<FriendIdAndName> ls = new ArrayList<>();
        while (i.hasNext()) {
            Friend friend = (Friend)i.next();
            FriendIdAndName idAndName = new FriendIdAndName();
            idAndName.setId(friend.getHer());
            idAndName.setUserName(idToNameDao.getNameById(friend.getHer()));
            ls.add(idAndName);
        }
        return ls;
    }
}

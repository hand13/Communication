package com.hand13.soft.exception;

/**
 * Created by hd110 on 2017/9/2.
 */
public class UserExistdException  extends Exception{
    public UserExistdException(){

    }
    public UserExistdException(String message) {
        super(message);
    }
}

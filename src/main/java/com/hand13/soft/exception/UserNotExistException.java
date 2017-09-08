package com.hand13.soft.exception;

/**
 * Created by hd110 on 2017/9/2.
 */
public class UserNotExistException extends Exception {
    public UserNotExistException(){}
    public UserNotExistException(String message) {
        super(message);
    }
}

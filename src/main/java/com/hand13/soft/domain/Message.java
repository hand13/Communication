package com.hand13.soft.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Message implements Serializable {
    private Integer id;
    private Integer userF;
    private Integer userT;
    private String message;
    private boolean read;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public Integer getUserF() {
        return userF;
    }

    public void setUserF(Integer userF) {
        this.userF = userF;
    }

    public Integer getUserT() {
        return userT;
    }

    public void setUserT(Integer userT) {
        this.userT = userT;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean readed) {
        this.read = readed;
    }
}

package com.hand13.soft.domain;

import java.io.Serializable;

/**
 * Created by hd110 on 2017/9/1.
 */
public class Friend  implements Serializable{
    private Integer id;
    private Integer you;
    private Integer her;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYou() {
        return you;
    }

    public void setYou(Integer you) {
        this.you = you;
    }

    public Integer getHer() {
        return her;
    }

    public void setHer(Integer her) {
        this.her = her;
    }
}

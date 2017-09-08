package com.hand13.soft.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Permission implements Serializable {
    public static String ADMIN = "admin";
    public static String ORDINARY = "ordinary";
    private Integer id;
    private Short type;
    private String typename;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getTypename() {
        return this.typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .append("typename",getTypename())
            .toString();
    }

}

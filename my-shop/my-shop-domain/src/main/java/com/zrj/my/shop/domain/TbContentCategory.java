package com.zrj.my.shop.domain;

import com.zrj.my.shop.commons.persistence.BaseEntity;

public class TbContentCategory extends BaseEntity {
    private Long parentId;

    private String name;

    private int status;

    private int shorOrder;

    private int isParent;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getShorOrder() {
        return shorOrder;
    }

    public void setShorOrder(int shorOrder) {
        this.shorOrder = shorOrder;
    }

    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }
}

package org.example.learn.spring.boot.commons.model.goods.dto;

import org.example.learn.spring.boot.commons.model.base.BaseDTO;

public class GoodsDTO extends BaseDTO {

    private String goodsNo;

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}

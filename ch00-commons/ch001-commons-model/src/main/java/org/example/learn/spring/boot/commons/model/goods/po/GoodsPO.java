package org.example.learn.spring.boot.commons.model.goods.po;

import org.example.learn.spring.boot.commons.model.base.BasePO;

public class GoodsPO extends BasePO {

    // 商品编码
    private String goodsNo;

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }
}

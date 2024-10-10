package org.example.learn.spring.boot.commons.model.order.dto;

import org.example.learn.spring.boot.commons.model.base.BaseDTO;

import java.math.BigDecimal;

public class OrderDTO extends BaseDTO {

    // 用户id
    private Long userId;

    // 商品id
    private Long goodsId;

    // 商品价格
    private BigDecimal price;

    // 商品数量
    private BigDecimal amount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

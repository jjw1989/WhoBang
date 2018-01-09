package com.whombang.app.entity;

/**
 * Created by David on 2018/1/10.
 */

public class GroupingDesEntity {

    /**
     * goodsGroupRequiredCount : 50
     * groupingDes : 50件成团，已参团：32件
     * amountOrdered : 32
     */

    private int goodsGroupRequiredCount;
    private String groupingDes;
    private int amountOrdered;

    public int getGoodsGroupRequiredCount() {
        return goodsGroupRequiredCount;
    }

    public void setGoodsGroupRequiredCount(int goodsGroupRequiredCount) {
        this.goodsGroupRequiredCount = goodsGroupRequiredCount;
    }

    public String getGroupingDes() {
        return groupingDes;
    }

    public void setGroupingDes(String groupingDes) {
        this.groupingDes = groupingDes;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }
}

package com.whombang.app.common.tabGround;

import java.util.List;

public class TagBean  {

    private String title;
    private double price;
    private int amount;
    private List<TagBean> tagBean=null;

    public TagBean(){}
    public  TagBean(String title , double price, int amount){
        this.title=title;
        this.price=price;
        this.amount=amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTagBean(List<TagBean> tagBean) {
        this.tagBean = tagBean;
    }
    public List<TagBean> getTagBean(){
        return  tagBean;
    }
}

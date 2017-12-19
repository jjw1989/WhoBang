package com.whombang.app.common.tabGround;

public abstract class TagFactory <T>{
    public enum ClickStatus{
        BAN,CLICK,UNCLICK
    }
    public abstract ClickStatus onColorTagClick(int position);
    public abstract ClickStatus onSizeTagClick(int position);
    public abstract T getClickObject();
}

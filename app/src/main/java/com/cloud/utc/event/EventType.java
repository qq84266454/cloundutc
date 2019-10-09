package com.cloud.utc.event;

/**
 * @author xp.h
 * @date 16/9/2  14:12
 * @描述:eventbus的类型
 */
public interface EventType {

     int EVENT_OPEN_GET_POPUP = 1;

    int EVENT_CLOSE_BUY_POPUP = 2;
    // 点击BuyBasePopup中的Get按钮,打开trade浮窗.
    int EVENT_OPEN_GET = 3;
    // 点击BuyBasePopup中的enter按钮
    int EVENT_OPEN_ENTRY = 4;

    int EVENT_CLOSE_BUY_AND_GET = 5;


}
package com.cloud.utc.event;

/**
 * @authorhuangxinpeng
 * @date16/7/15 10:37
 * @描述:EvnetBus数据实体类
 */
public class EventBusInfo<T> {
    private T data;//数据
    private int type;//类型


    public EventBusInfo(int type) {
        this.type = type;
    }

    public EventBusInfo(int type, T data) {
        this.type = type;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

package com.example.demo.vo;

import lombok.*;

/**
 * @author lijinfei
 * @Desc
 * @date 2020/3/19 20:33 Version: 1.0
 */
public class Car {

    private int carId;
    private String carName;
    private String ctime;
    private String carDesc;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.Car;

/**
 * @author Administrator
 */
public interface ICarService {
    /**
     * 写入单个用户
     * 
     * @param cars
     */
    boolean insertCars(List<Car> cars);

    List<Car> selectCars();

    /**
     * 根据用户名字查找用户
     * 
     * @param name
     * @return
     */
    Car selectCarByName(String name);

    String selectDescByName(String name);

    boolean deleteCar(Car car);
}

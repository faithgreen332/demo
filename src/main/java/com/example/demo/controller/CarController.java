package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.ICarService;
import com.example.demo.util.Constant;
import com.example.demo.vo.Car;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("car")
public class CarController {
    private static final Logger logger = LogManager.getLogger(CarController.class);
    @Resource
    private ICarService carService;

    @RequestMapping("selectCarByName")
    public Car selectCarByName(@RequestParam("name") String name) {
        return carService.selectCarByName(name);
    }

    @RequestMapping("selectAllCars")
    public List<Car> selectAllUsers() {
        return carService.selectCars();
    }

    @RequestMapping("selectAllCarsJson")
    public Object selectAllUsersJson() {
        JSONObject jsonObject = new JSONObject();
        if (!CollectionUtils.isEmpty(carService.selectCars())) {
            List<Car> carList = new ArrayList<>(carService.selectCars());
            jsonObject.put(Constant.STATUS, Constant.OK_CODE);
            jsonObject.put(Constant.MESSAGE, carList);
        }
        return jsonObject;
    }

    @RequestMapping("insertCar")
    public Object insertCar(@RequestBody Car car) {

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        JSONObject jsonObject = new JSONObject();
        if (carService.insertCars(cars)) {
            jsonObject.put(Constant.STATUS, Constant.OK_CODE);
            jsonObject.put(Constant.MESSAGE, "add successful");
        } else {
            jsonObject.put(Constant.STATUS, Constant.NOT_OK_CODE);
            jsonObject.put(Constant.MESSAGE, "en error occurred while adding");
        }
        return jsonObject;
    }

    @RequestMapping("selectDescByName")
    public String selectDescByName(@RequestParam("name") String name) {
        return carService.selectDescByName(name);
    }

    @RequestMapping("deleteCar")
    public Object deleteCar(@RequestBody Car car) {
        JSONObject jsonObject = new JSONObject();
        if (carService.deleteCar(car)) {
            jsonObject.put(Constant.STATUS, Constant.OK_CODE);
            jsonObject.put(Constant.MESSAGE, "delete successful!");
        } else {
            jsonObject.put(Constant.STATUS, Constant.NOT_OK_CODE);
            jsonObject.put(Constant.MESSAGE, "an error occurred while deleting");
        }
        return jsonObject;
    }
}

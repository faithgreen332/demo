package com.example.demo.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.dao.ICarDao;
import com.example.demo.service.ICarService;
import com.example.demo.vo.Car;

/**
 * @author Administrator
 */
@Service("carService")
public class CarServiceImpl implements ICarService {

    @Resource
    private ICarDao iCarDao;

    @Override
    public boolean insertCars(List<Car> cars) {
        int insertedCount = iCarDao.insertCars(cars);
        return insertedCount > 0;
    }

    @Override
    public List<Car> selectCars() {
        return iCarDao.selectCars();
    }

    @Override
    public Car selectCarByName(String name) {
        return null;
    }

    @Override
    public String selectDescByName(String name) {
        return iCarDao.selectDescByName(name);
    }

    @Override
    public boolean deleteCar(Car car) {
        int deletedCars = iCarDao.deleteCar(car.getCarId());
        return deletedCars > 0;
    }
}

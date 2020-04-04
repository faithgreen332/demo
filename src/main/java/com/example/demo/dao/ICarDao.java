package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.vo.Car;

/**
 * @author Administrator
 */
public interface ICarDao {

    @Transactional(rollbackFor = Exception.class)
    int insertCars(List<Car> cars);

    List<Car> selectCars();

    Car selectUserByName(String name);

    String selectDescByName(@Param("carName") String carName);

    /**
     * mybatis中提供三种删除返回值， 1、返回删除掉的条数 2.返回是否删除成功 3.返回空，这里用第一种
     * 
     * @param carId
     * @return
     */
    int deleteCar(@Param("carId") int carId);
}

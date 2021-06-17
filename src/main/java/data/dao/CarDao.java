package data.dao;

import data.entity.Car;
import data.entity.User;
import data.service.CarServiceModel;

import java.util.List;

public interface CarDao {
    void create(Car car);

    List<Car> getAll();

}

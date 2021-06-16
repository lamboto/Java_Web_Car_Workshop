package services.base;

import data.dao.CarDaoImpl;
import data.entity.Car;
import data.entity.Engine;
import data.service.CarServiceModel;
import services.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarDaoImpl carDao = new CarDaoImpl();

    @Override
    public void create(String brand, String model, String year, String engineType) {
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setYear(year);
        car.setEngine(Engine.valueOf(engineType));
        this.carDao.create(car);
    }

    @Override
    public List<CarServiceModel> getAll() {
        return this.carDao.getAll();
    }
}

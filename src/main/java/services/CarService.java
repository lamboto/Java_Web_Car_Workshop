package services;

import data.service.CarServiceModel;

import java.util.List;

public interface CarService {

    void create(String brand, String model, String year, String engineType, int userId);

    List<CarServiceModel> getAll();
}

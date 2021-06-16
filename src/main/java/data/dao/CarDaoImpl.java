package data.dao;

import config.DataBaseConnector;
import data.entity.Car;
import data.entity.Engine;
import data.service.CarServiceModel;
import org.modelmapper.ModelMapper;
import query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDaoImpl implements CarDao {
    private final DataBaseConnector connector = new DataBaseConnector();
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public void create(Car car) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Query.INSERT_CAR)) {
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getYear());
            preparedStatement.setString(4, car.getEngine().name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<CarServiceModel> getAll() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = this.connector.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(Query.SELECT_ALL_CARS)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String year = rs.getString("year");
                String engine = rs.getString("engine");
                cars.add(new Car(id, brand, model, year, Engine.valueOf(engine)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return cars.stream()
                .map(car -> mapper.map(car, CarServiceModel.class))
                .collect(Collectors.toList());
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

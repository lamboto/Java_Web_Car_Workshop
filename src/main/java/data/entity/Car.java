package data.entity;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String year;
    private Engine engine;
    private int userId;


    public Car() {
    }

    public Car(String brand, String model, String year, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public Car(String brand, String model, String year, Engine engine, int userId) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.userId = userId;
    }

    public Car(int id, String brand, String model, String year, Engine engine) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    public Car(int id, String brand, String model, String year, Engine engine, int userId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

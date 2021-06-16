package query;

public class Query {
    public static final String INSERT_USER = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
    public static final String SELECT_USER_BY_USERNAME = "select * from users where username=?";

    public static final String INSERT_CAR = "INSERT INTO cars (brand, model, year,engine) VALUES (?, ?, ?,?)";
    public static final String SELECT_ALL_CARS = "select * from cars";
}

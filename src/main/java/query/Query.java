package query;

public class Query {
    public static final String INSERT_USER = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
    public static final String SELECT_USER_BY_USERNAME = "select * from users where username=?";
    public static final String SELECT_USER_BY_ID = "select * from users where id=?";

    public static final String INSERT_CAR = "INSERT INTO cars (brand, model, year,engine,user_id) VALUES (?, ?, ?,?,?)";
    public static final String SELECT_ALL_CARS_WITH_USER = "select c.brand,c.model,c.year,c.engine,e.username from cars as c\n" +
            "join users as e\n" +
            "on  c.user_id = e.id;";

}

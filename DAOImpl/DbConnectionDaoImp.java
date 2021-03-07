package DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionDaoImp {
    private String url = "";
    private String user = "postgre";
    private String pass = "Pass1234";

    public void connectDb() throws SQLException {
        Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
    }
}
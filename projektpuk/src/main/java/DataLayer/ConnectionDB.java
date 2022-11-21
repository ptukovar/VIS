package DataLayer;
import java.sql.*;

public class ConnectionDB {
    public static void main(String[] args) {
    String connectionUrl =
            "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                    + "database=PUK0023;"
                    + "user=puk0023;"
                    + "password=G9773rSE7qsoF1cU;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {
            String createSql = "CREATE TABLE Vis_Clothes(" +
                    "   ID   INT              NOT NULL," +
                    "   NAME VARCHAR (50)     NOT NULL," +
                    "   TYPE VARCHAR (50)     NOT NULL," +
                    "   SIZE CHAR (1)         NOT NULL," +
                    "   QUANTITY INTEGER,      " +
                    "   PRIMARY KEY (ID)" +
                    ");";
            statement.executeUpdate(createSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package task1.db_connection;

import task1.db_connection.Configs;
import task1.db_connection.Const;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataBaseHandler extends Configs {

    Connection dbConnection;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void addFigureToDB(String figureName, int area, int perimeter) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO" + Const.TABLE + "(" + Const.FIGURE_NAME + "," + Const.FIGURE_AREA + "," + Const.FIGURE_PERIMETER + ")"
                + "VALUES(?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,figureName);
        prSt.setInt(2, area);
        prSt.setInt(3, perimeter);

        prSt.execute();
    }
}

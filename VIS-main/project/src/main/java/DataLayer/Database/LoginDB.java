package DataLayer.Database;
import java.sql.*;

import BusinessLayer.Objects.Product;
import BusinessLayer.Objects.User;
public class LoginDB {

	public static int rows=0;
	public String connectionUrl =
            "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                    + "database=PUK0023;" 
                    + "user=puk0023;"
                    + "password=****;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";

    ResultSet resultSet = null;
	public boolean createTable() {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
		         Statement statement = connection.createStatement();) {
		        String createSql =
		                "CREATE TABLE VIS_LOGIN ( "
		                + "ID INTEGER NOT NULL,  "
		                + "NAME VARCHAR (50) NOT NULL,"
		                + "PASSWORD VARCHAR (50) NOT NULL,"
		                + "PRIMARY KEY (ID));";
		        statement.executeUpdate(createSql);
		        return true;
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}
	public boolean loginTable(User u) throws SQLException {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
		         Statement statement = connection.createStatement();) {
				String selectSql = "Select * from VIS_LOGIN WHERE NAME='"+u.name+"' AND PASSWORD='"+u.password+"';";
				resultSet=statement.executeQuery(selectSql);
				 rows=0;
		        while (resultSet.next()) {
		            resultSet.getString(1);
		            rows++;
		    		return resultSet.getString(1)!=null?true:false;
		        }
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		return false;
	}
	public boolean checkName(User u) {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
		         Statement statement = connection.createStatement();) {
				String selectSql = "Select * from VIS_LOGIN WHERE NAME='"+u.name+"';";
				resultSet=statement.executeQuery(selectSql);
				 rows=0;
		        while (resultSet.next()) {
		            resultSet.getString(1);
		            rows++;
		    		return resultSet.getString(1)!=null?true:false;
		        }
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		return false;
	}
	public boolean register(User u) {
		if(!checkName(u)) {
			int xx=0;
			try (Connection connection = DriverManager.getConnection(connectionUrl);
			         Statement statement = connection.createStatement();) {
					String selectSql = "Select * from VIS_LOGIN;";
					resultSet=statement.executeQuery(selectSql);
			        while (resultSet.next()) {
				        xx=resultSet.getInt(1)+1;
				        this.rows = resultSet.getInt(1)+1;
			        }
			    }
			    catch (SQLException e) {
			        e.printStackTrace();
			    }
			try (Connection connection = DriverManager.getConnection(connectionUrl);
			         Statement statement = connection.createStatement();) {
			        String insertSql = "INSERT INTO VIS_LOGIN (ID, NAME, PASSWORD) VALUES "
			                + "('"+xx+"','"+u.name+"', '"+u.password+"');";
			       statement.executeUpdate(insertSql);
			    }
			    catch (SQLException e) {
			        e.printStackTrace();
			    }
			return true;
			}
		return false;
	}
	
	public void updateTable(Product p, int id) {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
		         Statement statement = connection.createStatement();) {
		        String updateSql = "UPDATE VIS_CLOTHES SET NAME='"+p.name+"',TYPE='"+p.name+"',SIZE='"+p.name+"',QUANTITY='"+p.name+"' WHERE ID = '"+id+"';";
		        statement.executeUpdate(updateSql);
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	
	public void removeTable(int id) {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
	         Statement statement = connection.createStatement();) {
	        String updateSql = "Delete from Vis_Clothes where ID = '"+id+"';";
	        statement.executeUpdate(updateSql);
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public int getMaxID() throws SQLException {
		try (Connection connection = DriverManager.getConnection(connectionUrl);
		         Statement statement = connection.createStatement();) {
				String selectSql = "Select * from Vis_Clothes;";
				resultSet=statement.executeQuery(selectSql);
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		return resultSet.getInt(1);
	}
}

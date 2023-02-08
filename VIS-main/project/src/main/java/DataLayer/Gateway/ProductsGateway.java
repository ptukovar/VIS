package DataLayer.Gateway;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLayer.Objects.Product;
import DataLayer.Database.ConnectionDB;

public class ProductsGateway {
	ConnectionDB conn = new ConnectionDB();
	private int rows;
	public int getRows() {return this.rows;}
	ResultSet resultSet = null;
	public ArrayList<Product> selectTable() {
		ArrayList<Product> productList = new ArrayList<Product>();
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
		         Statement statement = connection.createStatement();) {
				String selectSql = "Select * from Vis_Clothes;";
				resultSet = statement.executeQuery(selectSql);
				 int rows = 0;
		        while (resultSet.next()) {
		        	Product p = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
		        	productList.add(p);
		        	rows++;
		        }
		        return productList;
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		return null;
	}
	
	public void insertTable(Product p) {
		int xx=0;
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
		         Statement statement = connection.createStatement();) {
				String selectSql = "Select * from Vis_Clothes;";
				resultSet = statement.executeQuery(selectSql);
		        while (resultSet.next()) {
			        xx=resultSet.getInt(1)+1;
			        this.rows = resultSet.getInt(1)+1;
		        }
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
		         Statement statement = connection.createStatement();) {
		        String insertSql = "INSERT INTO Vis_Clothes (ID, NAME, TYPE, SIZE, QUANTITY) VALUES "
		                + "('"+xx+"','"+p.name+"', '"+p.type+"', '"+p.size+"', '"+p.quantity+"');";
		       statement.executeUpdate(insertSql);
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	public void preInsert(Product[] p) {
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
		         Statement statement = connection.createStatement();) {
			for(int i=0; i<p.length;i++) {
				String preInsertSql = "INSERT INTO Vis_Clothes (ID, NAME, TYPE, SIZE, QUANTITY) VALUES "
		                + "('"+p[i].id+"','"+p[i].name+"', '"+p[i].type+"', '"+p[i].size+"', '"+p[i].quantity+"');";
				statement.executeUpdate(preInsertSql);
			}   
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
    }
	public void updateTable(Product p) {
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
		         Statement statement = connection.createStatement();) {
		        String updateSql = "UPDATE VIS_CLOTHES SET NAME='"+p.name+"',TYPE='"+p.name+"',SIZE='"+p.name+"',QUANTITY='"+p.name+"' WHERE ID = '"+p.id+"';";
		        statement.executeUpdate(updateSql);
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	
	public void removeTable(int id) {
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
	         Statement statement = connection.createStatement();) {
	        String updateSql = "Delete from Vis_Clothes where ID = '"+id+"';";
	        statement.executeUpdate(updateSql);
	    }
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public int getMaxID() throws SQLException {
		resultSet = null;
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
		         Statement statement = connection.createStatement();) {
				String selectSql = "Select * from Vis_Clothes;";
				resultSet=statement.executeQuery(selectSql);
		    }
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		return resultSet.getInt(1);
	}
	
	public void saveS() {
		try (Connection connection = DriverManager.getConnection(conn.getConnection());
		         Statement statement = connection.createStatement();) {
				String selectSql = "Select * from Vis_Clothes;";
				resultSet = statement.executeQuery(selectSql);
				 System.out.println("id\tname\ttype\tsize\tquantity");
				 rows=0;
			try(PrintWriter pw = new PrintWriter(new FileWriter("products.txt"))) {
		        while (resultSet.next()) {
		            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2)+ "\t" +resultSet.getString(3) + "\t" + resultSet.getString(4)+ "\t    " + resultSet.getString(5));
		            rows++;
					pw.printf("%s;%s;%s;%s;%s\n",
							resultSet.getString(1),
							resultSet.getString(2), 
							resultSet.getString(3),
							resultSet.getString(4), 
							resultSet.getString(5)
							);
					} 
		        }catch (IOException e) {
				e.printStackTrace();
			} 
		}
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

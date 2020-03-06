import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * 
 */

/**
 * @author samasu5
 *
 */
public class StandAloneDbConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StandAloneDbConnection().queryVsibDb();
	}

	
	public static class ConnectionManager {
	    private static String url = "jdbc:oracle:thin:@uiioci03d-ekixk-scan.dbclient1.ocivesnpusashbu.oraclevcn.com:1521/VSIBUATAPP";    
	    private static String driverName = "oracle.jdbc.driver.OracleDriver";   
	    private static String username = "vsib_app";   
	    private static String password = "vsibtork1983$";
	    private static Connection con;

	    public static Connection getConnection() {
	        try {
	        	System.out.println("Registering the DB driver.... "+new Date());
	            Class.forName(driverName);
	            System.out.println("DB driver registered. "+new Date());
	            try {
	            	System.out.println("Creating a DB connection with ... \nURL: "+url
	            			+ " \nUser Name: "+username
	            			+ " \nPassword: "+password);
	                con = DriverManager.getConnection(url, username, password);
	                System.out.println("Successfully connected to DB. "+new Date());
	            } catch (SQLException ex) {
	                // log an exception. fro example:
	                System.out.println("Failed to create the database connection."); 
	                ex.printStackTrace();
	            }
	        } catch (ClassNotFoundException ex) {
	            // log an exception. for example:
	            System.out.println("Driver not found."); 
	            ex.printStackTrace();
	        }
	        return con;
	    }
	}
	
	public void queryVsibDb() {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println("Creating the DB connection object..... "+new Date());
			con = ConnectionManager.getConnection();
			
			if (con != null) {
				System.out.println("Got the DB connection. "+new Date());
				stmt = con.createStatement();
				String sqlQeury = "select * from vsib_config";
				rs = stmt.executeQuery(sqlQeury);
				System.out.println("SQL query ("+sqlQeury+") successfully executed. "+new Date());
				rs.next();
				System.out.println("Result Set 1st record: "+rs.getString(1)); 
				/*while(rs.next())  
					System.out.println(rs.getString(1)); */ 
					  
					//step5 close the connection object  
					con.close();  
			}
			
			
				  
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		
	}
}

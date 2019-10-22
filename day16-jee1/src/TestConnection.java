import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TestConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
          //1. Load the Driver class
		
		 Class.forName("com.mysql.cj.jdbc.Driver"); //  format got to do with the player - driver
		 //type 4 driver
		 //2. User DriverManager for obtaining connection with the mysql db
		 //http://google.com
		 String url= "jdbc:mysql://localhost:3306/music";  // protocol uniform and universal 
		 String username="root";
		 String password="test";
		 Connection con = DriverManager.getConnection(url,username,password);
		 //  SQL - Uniform 
	/*	 PreparedStatement ps = con.prepareStatement("insert into song values(?,?,?)");
		 ps.setInt(1, 3);
        ps.setString(2, "Whitney Houston");
        ps.setString(3,"I will always love you");
        int count = ps.executeUpdate();
        System.out.println((count > 0 )? "one record is inserted":"zero records inserted" );
    */    
		 
		 PreparedStatement ps = con.prepareStatement("update song set title=? where songid=?");
		 ps.setString(1,"Bailando");
		 ps.setInt(2, 2);
		 int count = ps.executeUpdate();
	        System.out.println((count > 0 )? "one record is inserted":"zero records inserted" );
		 System.out.println("connected..................");
		 
	}

}

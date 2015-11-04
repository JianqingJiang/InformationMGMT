package mgmtsystem__;
import java.sql.Connection;
import java.sql.DriverManager;
public class JdbcUtil
{
		 public static Connection getConnection()throws Exception{
			 Connection conn;
			  Class.forName("com.mysql.jdbc.Driver");
			  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data?useUnicode=true&characterEncoding=gbk", "root","");
			   return conn;
		  }
	}
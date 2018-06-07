import java.io.*;
import java.sql.*;
import java.util.*;

class DBSearch {

        Connection DBConn = null;
	Statement DBStmt = null;

	DBSearch() throws Exception {
		DBConnect();
	}

	private void DBConnect() throws Exception {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://biostar.kaist.ac.kr:5432/uta";
        	String ID= "uta"; 
        	String Passwd= "tabislaprom3"; 

            	Class.forName(driver);
            	DBConn = DriverManager.getConnection(url, ID, Passwd);
		DBStmt = DBConn.createStatement();
    	}

	public void DBDisconnect() throws Exception {
		DBConn.close();
	}

	public int GetSearchKey() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("=========== [Search Key Request Page] ==============");
		System.out.print("Enter your search key: ");
		String yname = scan.nextLine();
		int skey = Integer.parseInt(yname);

		return(skey);	
	}

	public void DisplayData(int search_key) throws Exception {
		ResultSet rs = null;
		int cno;
		String cname = null;
		String cphone = null;

		String query = "select * from mydata where no > " + search_key + ";";
		System.out.println("\n\n======= [Search Result Page] ==============");
		System.out.println(query);
		rs = DBStmt.executeQuery(query);
		System.out.println("===========================");
		System.out.println("NO"+"\t"+"NAME"+"\t"+"PHONE");
		System.out.println("===========================");
		while(rs.next()) {
			cno = rs.getInt("no");
			cname = rs.getString("name");
			cphone = rs.getString("phone");
			System.out.println(cno+"\t"+cname+"\t"+cphone);
		}
		System.out.println("===========================");
	}
}

class MyLogin {

	Scanner scan = new Scanner(System.in);

	MyLogin() throws Exception {
		String yname;
		System.out.println("\n============== [Login Request Page] =====================");
		System.out.println("Simple Gene Search System");
		System.out.print("Login: ");
		yname = scan.nextLine();	
		CheckLoginName(yname);
	}

	public void CheckLoginName(String lname) {
		System.out.println("\n\n============ [Result Page] =====================");
		System.out.println("Your Login Name is: "+ lname);
		System.out.println("Continue?[Return]");
		String yname = scan.nextLine();	
	}
}

public class ex4 {
	public static void main(String[] args) throws Exception {
		try {
			MyLogin mylogin = new MyLogin();
			DBSearch dbSearch = new DBSearch();
			int skey = dbSearch.GetSearchKey();
			dbSearch.DisplayData(skey);
			dbSearch.DBDisconnect();
		} 
		catch (Exception ex) {
			System.out.println("end");
			ex.printStackTrace();
		}
	}
}


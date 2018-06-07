
// DBAccess.java

import java.io.*;
import java.sql.*;
import java.util.*;

class DBAccess {

        Connection DBConn = null;
	Statement DBStmt = null;

	DBAccess() throws Exception {
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

	public void insertData(String[] records) throws Exception {
		System.out.println("insertData");
	
		String query = "";
                for (int i = 0; i < records.length; i++) {
			if(records[i].matches("[0-9]+")) {
				query = query + records[i] + ","; 
			} else {
				query = query + "'" + records[i] + "',";
			}
		}
		query = "insert into mydata values (" + query.substring(0, query.length()-1) + ");";
		DBStmt.executeUpdate(query);
		System.out.println(query);
	}

	public void readData() throws Exception {
		System.out.println("readData");
		ResultSet rs = null;
		int cno;
		String cname = null;
		String cphone = null;

		String query = "select * from mydata;";
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

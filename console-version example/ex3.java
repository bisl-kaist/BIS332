
// ex3.java

import java.io.*;
import java.sql.*;
import java.util.*;

public class ex3 {
	public static void main(String[] args) throws Exception {
		try {
			String yname;
			Scanner scan = new Scanner(System.in);

			System.out.println("Welcome to a Basic File Parser");
			System.out.print("Enter Your Name: ");
			yname = scan.nextLine();	
			System.out.println("Your Name is " + yname);
			FileParser parser = new FileParser(args[0]);
			parser.dbAccess.readData();
			parser.dbAccess.DBDisconnect();
		} 
		catch (Exception ex) {
			System.out.println("end");
			ex.printStackTrace();
		}
	}
}


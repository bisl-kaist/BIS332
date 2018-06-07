
// ex1.java

import java.io.*;
import java.sql.*;
import java.util.*;

class DumParser {
	int	i = 7;

	DumParser() throws Exception {
		System.out.println("Dummy Parser Constructor");
	}

	public void doParse() {
		System.out.println("Dummy Parser Method - Do Parse");
	}
}


public class ex1 {
	public static void main(String[] args) throws Exception {
		try {
			String yname;
			Scanner scan = new Scanner(System.in);

			System.out.println("Welcome to a Basic File Parser");
			System.out.print("Enter Your Name: ");
			yname = scan.nextLine();	
			System.out.println("Your Name is " + yname);

			DumParser dumParser = new DumParser();
			dumParser.doParse();
		} 
		catch (Exception ex) {
			System.out.println("end");
			ex.printStackTrace();
		}
	}
}



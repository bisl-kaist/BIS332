
// ex2.java

import java.io.*;
import java.sql.*;
import java.util.*;

class FileParser {

	FileParser(String fileName) throws Exception {
		System.out.println("Input Filename: " + fileName);
		FileReader fileReader = new FileReader(fileName);
        	BufferedReader bufferReader = new BufferedReader(fileReader);
		String[] lineArray;

 		String line = bufferReader.readLine();
                line = bufferReader.readLine();
            	while(line != null) {
                	lineArray = line.split("\t");
			displayRecord(lineArray);
                	line = bufferReader.readLine();
                }
	}

	private	void displayRecord(String[] records) throws Exception {
		for(int i = 0; i < records.length; i++) {
			System.out.print(records[i] + "\t");
		}
		System.out.println("");
	} 
}


public class ex2 {
	public static void main(String[] args) throws Exception {
		try {
			String yname;
			Scanner scan = new Scanner(System.in);

			System.out.println("Welcome to a Basic File Parser");
			System.out.print("Enter Your Name: ");
			yname = scan.nextLine();	
			System.out.println("Your Name is " + yname);
			FileParser parser = new FileParser(args[0]);
		} 
		catch (Exception ex) {
			System.out.println("end");
			ex.printStackTrace();
		}
	}
}




// FileParser.java

import java.io.*;
import java.sql.*;
import java.util.*;

class FileParser {

	DBAccess dbAccess = null;

	FileParser(String fileName) throws Exception {
		System.out.println("Input Filename: " + fileName);
		FileReader fileReader = new FileReader(fileName);
        	BufferedReader bufferReader = new BufferedReader(fileReader);
		String[] lineArray;

		dbAccess = new DBAccess();
 		String line = bufferReader.readLine();
                line = bufferReader.readLine();
            	while(line != null) {
                	lineArray = line.split("\t");
			insertDataToDB(lineArray);
                	line = bufferReader.readLine();
                }
	}

	private	void insertDataToDB(String[] records) throws Exception {
			dbAccess.insertData(records);
	} 
}



package ex4;

import ex4.SelectResultObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    
    private Connection PostgresqlConnector() throws Exception {
        Connection conn = null;
        String IP_ADDRESS="";
        String PORT="";
        String DB_NAME=""; // Student Number
        String ID= ""; //Student Number
        String Passwd= "";  //Password

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://" + IP_ADDRESS + ":" + PORT + "/" + DB_NAME, ID, Passwd);

        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return conn;
    }

    // Example #6-2 : JDBC RestfulAPI
    @RequestMapping(value = "/restSelectorResult", method = RequestMethod.GET)
    public List<SelectResultObject> restselectorresult(
	@RequestParam(value="inputNo", required = false, defaultValue ="0") int inputNo
	) throws Exception {
        Connection conn = PostgresqlConnector();

        String sql = "";
        if (inputNo == 0 ) {
            sql = "select no, name, phone from mydata";
        } else {
            sql = "select no, name, phone from mydata where no > '"+Integer.toString(inputNo) + "'";
        }

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<SelectResultObject> resultInfoList = new ArrayList<SelectResultObject>();

        while(rs.next()) {
            resultInfoList.add(new SelectResultObject(rs.getString("no"),rs.getString("name"),rs.getString("phone")));
        }

        stmt.close();
        conn.close();

        return resultInfoList;

    }


}



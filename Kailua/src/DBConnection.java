import java.sql.*;

public class DBConnection {

    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String database_url = ""; //the url of database
    private static String username = "";
    private static String password = "";
    private static String schema = "";


    public static ResultSet selectQuery(String query) { // Select Queries only
        try {
            //create connection
            Class.forName(JDBC_DRIVER); //load DB driver
            Connection con = DriverManager.getConnection(database_url, username, password); //return connection object
            Statement st = con.createStatement(); //statement object which will hold sql statement
            st.execute("USE " + schema + ";");
            ResultSet rs = st.executeQuery(query); // Query is executed return result set object in form of rows
            return rs; // The ResultSet is being returned.
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Returns null in case of any exception.
    }

    public static boolean executeQuery(String query) { //can we use void???
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(database_url, username, password);
            Statement st = con.createStatement();
            st.execute("USE " + schema + ";");
            boolean rs = st.execute(query); // Query is executed. //???
            return rs; // The ResultSet is being returned. /????
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false; // Returns null in case of any exception. //????
    }
}

import model.dao.mapper.AccountMapper;

import java.sql.*;
import java.util.TreeMap;

public class App {
    /*private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";*/

    public static void main(String[] args) throws SQLException {
        System.out.println("Assist".hashCode());

        System.out.println("Hello!");
        /*Connection connection =
                DriverManager.*/
                       // getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);

        /*Statement query = con.createStatement();
        ResultSet rs = query.executeQuery("SELECT * FROM event");
        while( rs.next()) {
            System.out.println(rs.getString("name"));}*/


        //String query = "DELETE FROM account WHERE email = ?";

        /*try(PreparedStatement ps = connection.prepareCall(query)) {

            System.out.println(connection.isClosed());
            ps.setString(1, "demchuk.dasha@gmailc.com");
            int rs = ps.executeUpdate();
*/
            /*AccountMapper userMapper = new AccountMapper();

            userMapper.extractFromResultSet(rs);*/

       /* } catch (SQLException e) {
            e.printStackTrace();
        }
*/    }

}

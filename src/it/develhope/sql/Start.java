package it.develhope.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Start {
    public static void main(String[] args) throws SQLException
    {
        Connection connection = null;
        try
        {
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "passwordhere";
            connection= DriverManager.getConnection(url, user,password);
            Statement query = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";
            query.executeUpdate(sql);
            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Rossi', 'Marco');");
            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Verdi', 'Davide');");
            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('DeLuca', 'Giuseppe');");
            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Costanzo', 'Mirco');");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if (connection != null)
                    connection.close();
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }

         
    }

}

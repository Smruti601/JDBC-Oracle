import java.sql.*;
public class InsertStudent
{
    public static void main(String[] args)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl1";

        String username = "scott";
        String password = "tiger";

        String query = "select * from student";

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("  ID |   Roll     |   Name               |   Course   |");
            System.out.println("---------------------------------------------------------");
//            while (rs.next())
//            {
//                System.out.println( rs.getInt("id" +"       ") +
//                                    rs.getString("rollnumber" + "       ")+
//                                    rs.getString("name"+ "      ")+
//                                    rs.getString("branch" + "       ")
//                                  );
//            }
            while (rs.next()) {
                int id = rs.getInt("ID");
                String roll = rs.getString("ROLLNUMBER");
                String name = rs.getString("NAME");
                String branch = rs.getString("BRANCH");

                System.out.printf("%4d | %-10s | %-20s | %-10s |\n", id, roll, name, branch);
            }


        }
        catch (Exception e)
        {
                    e.printStackTrace();
        }
    }
}

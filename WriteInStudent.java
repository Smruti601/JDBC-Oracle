import java.sql.*;

public class WriteInStudent
{
    public static void main(String[] args)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl1";
        String user = "scott";
        String password = "tiger";

        String query = "insert into student(id , rollnumber ,name , branch) values(?,?,?,?)";
        String query2 = "select * from student order by id";

        try{
            Connection con = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = con.prepareStatement(query);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query2);

            ps.setInt(1,12);
            ps.setString(2,"L23BCA101");
            ps.setString(3,"Saawat");
            ps.setString(4,"BCA");
            ps.executeUpdate();

            ps.setInt(1,9);
            ps.setString(2,"L21CS188");
            ps.setString(3,"Mamata Meher");
            ps.setString(4,"CS");
            ps.executeUpdate();

            System.out.println("  ID |   Roll     |   Name               |   Course   |");
            System.out.println("---------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("ID");
                String roll = rs.getString("ROLLNUMBER");
                String name = rs.getString("NAME");
                String branch = rs.getString("BRANCH");

                System.out.printf("%4d | %-10s | %-20s | %-10s |\n", id, roll, name, branch);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

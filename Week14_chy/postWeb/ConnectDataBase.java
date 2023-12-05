package Week14_chy.postWeb;

import java.sql.*;

public class ConnectDataBase {

    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/boards";

        String id = "root";
        String password = "";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
            return con; // Return the Connection object on success
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
            e.printStackTrace(); // Print the exception details for debugging
        }
        return con; // Return null in case of an exception
    }
    public static void main (String arg[]) throws SQLException {
        Connection con = makeConnection();

        try{
            String sql = ""+
                    "INSERT INTO users (userid, username, userpassword, userage, useremail) " +
                    "values(?,?,?,?,?)";


            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,"winter");
            pstm.setString(2,"한겨울");
            pstm.setString(3,"12345");
            pstm.setInt(4,25);
            pstm.setString(5,"gusdudco6@naver.com");

            int row  = pstm.executeUpdate();
            System.out.println("저장된 행 수 : "+row);
            pstm.close();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                try{
                    con.close();
                }catch (SQLException e){}
            }
        }



    }
}

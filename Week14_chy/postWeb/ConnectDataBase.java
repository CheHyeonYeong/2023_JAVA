package Week14_chy.postWeb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

            //대개변수화된 SQL문 작성
            String sql = new StringBuilder ()
                    . append ("UPDATE boards SET ")
                    . append ("btitle =? , ")
                    . append ("bcontent =? , ")
                    . append ("bfilename =? , ")
                    . append ("bfiledata =? ")
                    . append ("WHERE bno =? ")
                    . toString ();

            //PreparedStatement 얼기 및 값 지정
            PreparedStatement pstmt = con.prepareStatement (sql) ;
            pstmt.setString (1, "눈사람");
            pstmt.setString (2, "눈으로 만든 사람");
            pstmt.setString (3, "snowman.jpg") ;

            // FileInputStream을 사용하여 이미지 데이터를 BLOB에 설정
            try {
                // FileInputStream을 사용하여 이미지 데이터를 BLOB에 설정
                pstmt.setBlob(4, new FileInputStream("snowman.jpg") );
            } catch (FileNotFoundException e) {
                System.out.println("파일을 찾을 수 없습니다.");
                e.printStackTrace();
            }

                pstmt.setInt (5, 1); //WHERE bno=14

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

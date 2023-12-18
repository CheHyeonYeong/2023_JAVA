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
            String sql = ""+
                    "INSERT INTO boards (btitle,bcontent,bwriter,bdate,bfilename,bfiledata) " +
                    "values(?,?,?,now(),?,?)";

            PreparedStatement pstmt = con.prepareStatement (sql, new String[] {"bno"});
            pstmt.setString(1, "눈오는 날") ;
            pstmt.setString(2, "함박눈이 내려요. ") ;
            pstmt.setString(3, "winter");
            pstmt.setString(4, "snow.jpg") ;

            // FileInputStream을 사용하여 이미지 데이터를 BLOB에 설정
            try {
                // FileInputStream을 사용하여 이미지 데이터를 BLOB에 설정
                pstmt.setBlob(5, new FileInputStream("snow.jpg") );
            } catch (FileNotFoundException e) {
                System.out.println("파일을 찾을 수 없습니다. ");
                e.printStackTrace();
            }
            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System. out.println ("저장된 행 수: " + rows);
            if(rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next ()) {
                    int bno = rs.getInt (1) ;
                    System.out.println("저장된 bno: " + bno);

                }
                rs.close ();}
            //PreparedStatement 달기
            pstmt.close ();

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

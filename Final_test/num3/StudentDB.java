package Final_test.num3;
import java.sql.*;

public class StudentDB {
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/duksung";

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
    //2)레코드에 새로운 값 추가하기
    public static void addBook(int stuId, String name, String tel, String dept){
        Connection con = makeConnection();
        try{
            Statement stmt = con.createStatement();
            String s = "INSERT INTO student (stuId, name, tel, dept) VALUES ";
            s+="('"+stuId+"','"+name+"','"+tel+"','"+dept+"')";
            System.out.println(s);
            int i = stmt.executeUpdate(s);
            if(i==1) System.out.println("레코드 추가 성공");
            else System.out.println("레코드 추가 실패");
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public static void main (String arg[]) throws SQLException {
        Connection con = makeConnection();


        addBook(2022001,"Minji Lee","000-0000-0001","Cyber Security");
        addBook(2022002,"Hanni park","000-0000-0002","Computer");
        addBook(2022003,"Danielle chung","000-0000-0003","IT Media");
        addBook(2022004,"Hyein choi","000-0000-0004","Software");


        con.close();

    }
}
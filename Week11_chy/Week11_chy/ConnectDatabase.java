package Week11_chy.Week11_chy;

import java.sql.*;

public class ConnectDatabase {

    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/book_db";

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
    public static void addBook(String title, String publisher, String year, int price){
        Connection con = makeConnection();
        try{
            Statement stmt = con.createStatement();
            String s = "INSERT INTO books (title, publisher, year, price) VALUES ";
            s+="('"+title+"','"+publisher+"','"+year+"','"+price+"')";
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

            String query = "SELECT books.title, books.price" + " FROM books"
                    + " WHERE publisher = ?";
            PreparedStatement stmt1 = con.prepareStatement (query) ;
            stmt1.setString (1, "Wiley");
            ResultSet rs1 = stmt1.executeQuery();

            while (rs1.next ()) {
                String title = rs1.getString("title");
                int price = rs1.getInt("price");
                System.out.println(title + " " + price);
            }
            con.close();

            addBook("인간은 왜 사는가", "채현영","2021",15000);

            con.close();

        }

}
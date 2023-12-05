package Week12_chy;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static Week11_chy.ConnectDatabase.makeConnection;

public class MyFrame extends JFrame {
    JTextField id, title, publisher, year, price, search;
    JButton previousButton, nextButton, InsertButton, deleteButton, searchButton, ClearButton;
    ResultSet rs;
    Statement stmt;

    public MyFrame() throws SQLException{
        super("Database Viewer");
        Connection con = makeConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //ResultSet이 처음부터 끝까지 이용하면서 데이터를 순회할 수 있다.
        rs= stmt.executeQuery("SELECT * FROM books");
        //모든 데이터를 가져옴

        setLayout(new GridLayout(0,2));
        add(new JLabel("ID", JLabel.CENTER));
        add(id = new JTextField());

        add(new JLabel("TITLE", JLabel.CENTER));
        add(title = new JTextField());

        add(new JLabel("PUBLISHER", JLabel.CENTER));
        add(publisher = new JTextField());

        add(new JLabel("YEAR", JLabel.CENTER));
        add(year = new JTextField());

        add(new JLabel("PRICE", JLabel.CENTER));
        add(price = new JTextField());

        add(new JLabel("SEARCH", JLabel.CENTER));
        add(search = new JTextField());

        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    rs.previous();//ResultSet에서 가져온 데이터를 화면에 업데이트
                    id.setText("" + rs.getInt("book_id"));
                    title.setText(""+rs.getString("title"));
                    publisher.setText(""+rs.getString("publisher"));
                    year.setText(""+rs.getString("year"));
                    price.setText(""+rs.getString("price"));
                }catch (SQLException event){
                    event.printStackTrace();
                }
            }
        });

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    rs.next();
                    id.setText("" + rs.getInt("book_id"));
                    title.setText(""+rs.getString("title"));
                    publisher.setText(""+rs.getString("publisher"));
                    year.setText(""+rs.getString("year"));
                    price.setText(""+rs.getString("price"));
                }catch (SQLException event){
                    event.printStackTrace();
                }
            }
        });

        InsertButton = new JButton("Insert");
        deleteButton = new JButton("Delete");

        nextButton = new JButton("Search");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchKeyword = search.getText();
                //search가 아닌 searchPublisher을 사용해야 함

                try{
                    //SQL 쿼리를 사용하여 저자 이름을 기준으로 검색
                    String query = "SELETE * FROM books WHERE publisher LIKE '%'"+searchKeyword+"'%'";
                    ResultSet searchResult = stmt.executeQuery(query);
                    
                    //검색 결과가 있으면 ResultSet에서 가져온 데이터를 화면에 업데이트
                    if(searchResult.next()){
                        id.setText("" + searchResult.getInt("book_id"));
                        title.setText(""+searchResult.getString("title"));
                        publisher.setText(""+searchResult.getString("publisher"));
                        year.setText(""+searchResult.getString("year"));
                        price.setText(""+searchResult.getString("price"));
                    }else{
                        System.out.println("검색 결과가 없습니다.");
                    }
                }catch (SQLException event){
                    event.printStackTrace();
                }
            }
        });
        ClearButton = new JButton("Clear");

        add(previousButton);
        add(nextButton);
        add(InsertButton);
        add(deleteButton);
        add(searchButton);
        add(ClearButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,200);
        setVisible(true);
    }
    public static Connection makeConnection(){
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

    public class ConnectDatabase{
        public static void main(String[] args) throws SQLException{

            new MyFrame();
        }
    }
}

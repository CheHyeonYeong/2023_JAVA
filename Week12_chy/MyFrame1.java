package Week12_chy;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class MyFrame1 extends JFrame {

    JTextField id, title, publisher, year, price, search;
    JButton previousButton, nextButton, InsertButton, deleteButton, searchButton, ClearButton;
    ResultSet rs;
    Statement stmt;

    public MyFrame1() throws SQLException{
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
            public void actionPerformed(ActionEvent event) {
                try {
                    rs.previous();
                    id.setText("" + rs.getInt("book_id"));
                    title.setText("" + rs.getString("title"));
                    publisher.setText("" + rs.getString("publisher"));
                    year.setText("" + rs.getString("year"));
                    price.setText("" + rs.getInt("price"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    rs.next();
                    id.setText("" + rs.getInt("book_id"));
                    title.setText("" + rs.getString("title"));
                    publisher.setText("" + rs.getString("publisher"));
                    year.setText("" + rs.getString("year"));
                    price.setText("" + rs.getInt("price"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        InsertButton = new JButton("Insert");
        InsertButton.addActionListener(e -> {
            try {
                // Get values from text fields
                int bookId = Integer.parseInt(id.getText());
                String bookTitle = title.getText();
                String bookPublisher = publisher.getText();
                String bookYear = year.getText();
                String bookPrice = price.getText();

                // SQL query for insertion
                String query = "INSERT INTO books (book_id, title, publisher, year, price) " +
                        "VALUES (" + bookId + ", '" + bookTitle + "', '" + bookPublisher + "', '" + bookYear + "', '" + bookPrice + "')";

                // Execute the query
                stmt.executeUpdate(query);

                // Inform the user
                System.out.println("Record inserted successfully!");
            } catch (SQLException | NumberFormatException ex) {
                ex.printStackTrace();
            }
        });


        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            String searchKeyword = search.getText();

            try {
                // Get the book_id of the currently displayed record
                //int currentBookId = rs.getInt("book_id");
                //만약 bookid로 지우고 싶으면 "Delete from books Where book_id="+currentBookId;

                // SQL query for deletion
                String deleteQuery = "DELETE FROM books WHERE publisher LIKE '%"+searchKeyword+"%'";

                // Execute the deletion query
                stmt.executeUpdate(deleteQuery);

                // Inform the user
                System.out.println("Record deleted successfully!");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> {
            String searchKeyword = search.getText();
            try {
                String query = "SELECT * FROM books WHERE publisher LIKE '%" + searchKeyword + "%'";
                ResultSet searchResult = stmt.executeQuery(query);

                if (searchResult.next()) {
                    id.setText("" + searchResult.getInt("book_id"));
                    title.setText("" + searchResult.getString("title"));
                    publisher.setText("" + searchResult.getString("publisher"));
                    year.setText("" + searchResult.getString("year"));
                    price.setText("" + searchResult.getString("price"));
                } else {
                    System.out.println("검색 결과가 없습니다.");
                }
            } catch (SQLException event) {
                event.printStackTrace();
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
    private void updateFieldsFromResultSet() throws SQLException {
        id.setText("" + rs.getInt("book_id"));
        title.setText("" + rs.getString("title"));
        publisher.setText("" + rs.getString("publisher"));
        year.setText("" + rs.getString("year"));
        price.setText("" + rs.getString("price"));
    }
    public static void main(String[] args) throws SQLException {
        MyFrame1 myframe = new MyFrame1();
    }
}
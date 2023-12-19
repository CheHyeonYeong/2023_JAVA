package Final_test.num4;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



class MyFrame1 extends JFrame {

    JTextField id, name, tel, dept;
    JButton previousButton, nextButton, InsertButton, deleteButton, searchButton, ClearButton;
    ResultSet rs;
    Statement stmt;

    public MyFrame1() throws SQLException{
        super("Database Viewer");
        Connection con = makeConnection();
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //ResultSet이 처음부터 끝까지 이용하면서 데이터를 순회할 수 있다.
        rs= stmt.executeQuery("SELECT * FROM student");
        //모든 데이터를 가져옴

        setLayout(new GridLayout(0,2));
        add(new JLabel("ID", JLabel.CENTER));
        add(id = new JTextField());

        add(new JLabel("name", JLabel.CENTER));
        add(name = new JTextField());

        add(new JLabel("tel", JLabel.CENTER));
        add(tel = new JTextField());

        add(new JLabel("dept", JLabel.CENTER));
        add(dept = new JTextField());


        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    rs.previous();
                    id.setText("" + rs.getInt("book_id"));
                    name.setText("" + rs.getString("name"));
                    tel.setText("" + rs.getString("tel"));
                    dept.setText("" + rs.getString("dept"));
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
                    name.setText("" + rs.getString("name"));
                    tel.setText("" + rs.getString("tel"));
                    dept.setText("" + rs.getString("dept"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });


        InsertButton = new JButton("Insert");
        InsertButton.addActionListener(e -> {
            try {
                // Get values from text fields
                int stuId = Integer.parseInt(id.getText());
                String name1 = name.getText();
                String tel1 = tel.getText();
                String dept1 = dept.getText();

                // SQL query for insertion
                String query = "INSERT INTO student (stuId, name, tel, dept) " +
                        "VALUES (" + stuId + ", '" + name1 + "', '" + tel1 + "', '" + dept1 + "', ' )";

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
            String searchKeyword = name.getText();

            try {
                // Get the book_id of the currently displayed record


                // SQL query for deletion
                String deleteQuery = "DELETE FROM student WHERE name LIKE '%"+searchKeyword+"%'";

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
            String searchKeyword = name.getText();
            try {
                String query = "SELECT * FROM student WHERE name LIKE '%" + searchKeyword + "%'";
                ResultSet searchResult = stmt.executeQuery(query);

                if (searchResult.next()) {
                    id.setText("" + searchResult.getInt("stuId"));
                    name.setText("" + searchResult.getString("name"));
                    tel.setText("" + searchResult.getString("tel"));
                    dept.setText("" + searchResult.getString("dept"));
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
    private void updateFieldsFromResultSet() throws SQLException {
        id.setText("" + rs.getInt("book_id"));
        name.setText("" + rs.getString("name"));
        tel.setText("" + rs.getString("tel"));
        dept.setText("" + rs.getString("dept"));
    }
    public static void main(String[] args) throws SQLException {
        MyFrame1 myframe = new MyFrame1();
    }
}

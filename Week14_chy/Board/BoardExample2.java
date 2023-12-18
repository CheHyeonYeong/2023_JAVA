package Week14_chy.Board;

//과제였다!!!

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;


//스레드를 사용하지 0 -> 반복 호출 xxxx

public class BoardExample2 {

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


	public void mainMenu(){

		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-----------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s \n",
				"1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
		System.out.printf("%-6s%-12s%-16s%-40s \n",
				"2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Update | 5.Exit");
		System.out.print("메뉴선택: ");

		Scanner scanner = new Scanner(System.in);

		// 사용자로부터 숫자 입력 받기
		String menuNo = scanner.next();

		// Create a separate thread for each menu option
		Thread menuThread = new Thread(() -> {
			switch (menuNo) {
				case "1" -> create();
				case "2" -> read();
				case "3" -> clear();
				case "4" -> update();
				case "5" -> exit();
			}
		});

		// Start the thread
		menuThread.start();

		// Scanner 객체 닫기 (권장사항)
		scanner.close();
	}
	public void create() {
		System.out.println(" *** create 메소드 실행됨");

		Connection con = makeConnection();

		try{
			String sql = ""+
					"INSERT INTO boards (btitle,bcontent,bwriter,bdate,bfilename,bfiledata) " +
					"values(?,?,?,now(),?,?)";

			PreparedStatement pstmt = con.prepareStatement (sql, new String[] {"bno"});
			pstmt.setString(1, "눈오는 날");
			pstmt.setString(2, "함박눈이 내려요. ");
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

	public void update() {
		// Connection 생성
		Connection con = makeConnection();

		try {
			// 대개 변수화된 SQL문 작성
			String sql = "UPDATE boards SET btitle = ?, bcontent = ?, bfilename = ?, bfiledata = ? WHERE bno = ?";

			// PreparedStatement 생성 및 값 설정
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, "눈사람");
				pstmt.setString(2, "눈으로 만든 사람");
				pstmt.setString(3, "snowman.jpg");

				try{
					// FileInputStream을 사용하여 이미지 데이터를 BLOB에 설정
					pstmt.setBlob(4, new FileInputStream("snowman.jpg"));
				} catch (FileNotFoundException e) {
					System.out.println("파일을 찾을 수 없습니다.");
					e.printStackTrace();
				}

				pstmt.setInt(5, 1); // WHERE bno = 1

				// SQL문 실행
				int rows = pstmt.executeUpdate();
				System.out.println("변경된 행 수: " + rows);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Connection 닫기
			if (con != null) {
				try {
					con.close(); // 연결 끊기
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void read() {
		System.out.println(" *** read 메소드 실행됨");

		// Connection 생성
		Connection con = makeConnection();

		try {
			// Assuming 'btitle' is a required field, provide a value for it in the INSERT statement
			String sql = "SELECT * FROM boards WHERE bwriter = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "winter");

			// Execute the SELECT query
			ResultSet resultSet = pstmt.executeQuery();

			// Process the result set
			while (resultSet.next()) {
				int bno = resultSet.getInt("bno");
				String bwriter = resultSet.getString("bwriter");
				String btitle = resultSet.getString("btitle");
				String bfiledata = resultSet.getString("bfiledata");


				System.out.println("bno: " + bno);
				System.out.println("bwriter: " + bwriter);
				System.out.println("btitle: " + btitle);
				System.out.println("bfiledata: " + bfiledata);
				System.out.println("---------------");
			}

			// PreparedStatement and ResultSet should be closed
			pstmt.close();
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Connection 닫기
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void clear() {
		System.out.println(" *** clear 메소드 실행됨");

		// Connection 생성
		Connection con = makeConnection();
		try {
			String sql = "DELETE FROM boards WHERE bwriter=? ";
			//열기 및 값 지정
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString (1, "winter") ;

			//SQL문 실행
			int rows = pstmt.executeUpdate();
			System. out.println ("저장된 행 수: " + rows);
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Connection 닫기
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	}

	public void exit() {
		System.exit(0);
	}
	public static void main(String[] args) {

		BoardExample2 boardExample = new BoardExample2();
		boardExample.mainMenu();
	}

}

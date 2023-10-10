package Week05_chy.Week05_03;

import Week05_chy.Week05_03.Book;
import Week05_chy.Week05_03.BookArrayList;
import java.util.Scanner;
public class BookArrayListTest {
    public static void main(String[] args) {
        Week05_chy.Week05_03.BookArrayList bookArrayList = new BookArrayList();

        Week05_chy.Week05_03.Book book1 = new Week05_chy.Week05_03.Book(0001, "파우스트");
        Week05_chy.Week05_03.Book book2 = new Week05_chy.Week05_03.Book(0002, "황무지");
        Week05_chy.Week05_03.Book book3 = new Week05_chy.Week05_03.Book(0003, "변신");
        Week05_chy.Week05_03.Book book4 = new Week05_chy.Week05_03.Book(0004, "픽션들");
        Week05_chy.Week05_03.Book book5 = new Book(0005, "톨스토이");

        bookArrayList.addBook(book1);
        bookArrayList.addBook(book2);
        bookArrayList.addBook(book3);
        bookArrayList.addBook(book4);
        bookArrayList.addBook(book5);

        bookArrayList.showAllBook(); //전체 책 출력

        //키보드로 위치와 책 ID, 책 제목을 입력 받아서 추가
        Scanner scanner = new Scanner(System.in);

        System.out.print("도서를 추가할 위치를 입력");
        int insertIndex = scanner.nextInt();

        System.out.print("책 ID 입력 : ");
        int bookId = scanner.nextInt();

        System.out.print("책 제목 입력 : ");
        String title = scanner.nextLine();

        Book newBook = new Book(bookId, title);

        bookArrayList.insertBook(insertIndex, newBook);

        bookArrayList.showAllBook(); //전체 책 출력

        scanner.close();
    }
}

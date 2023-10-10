package Week05_chy.HashSet;
import Week05_chy.Week05_03.Book;
import java.util.HashSet;
public class BookHashSetTest {
    public static void main(String[] args){
        BookHashSet bookHashSet = new BookHashSet();

        Book book6 = new Book(111,"해리포터");
        Book book7 = new Book(222,"반지의 제왕");
        Book book8 = new Book(333,"트와일라잇");

        bookHashSet.addBook(book6);
        bookHashSet.addBook(book7);
        bookHashSet.addBook(book8);
        bookHashSet.showAllBook();

        Book book9 = new Book(111, "브레이킹던");
        bookHashSet.addBook(book9);
        bookHashSet.showAllBook();

    }
}

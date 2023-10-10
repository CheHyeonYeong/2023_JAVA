package Week05_chy.HashSet;
import java.util.HashSet;
import java.util.Iterator;
import Week05_chy.Week05_03.Book;
public class BookHashSet {
    private HashSet<Book> hashSet;
    public BookHashSet(){
        hashSet = new HashSet<Book>(); //생성
    }
    public void addBook(Book book){
        hashSet.add(book);
    }
    public boolean removeBook(int BookID){
        Iterator<Book> ir = hashSet.iterator();
        while (ir.hasNext()){
            Book book = ir.next();
            int tempID = book.getBookId();
            if(tempID == BookID){
                hashSet.remove(book);
                return true;
            }
        }
        System.out.println(BookID+"가 존재하지 않습니다");
        return false;
    }
    public void showAllBook(){
        for (Book book : hashSet){
            System.out.println(book);
        }
        System.out.println();
    }

}

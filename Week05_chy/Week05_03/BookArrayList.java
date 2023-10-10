package Week05_chy.Week05_03;

import java.util.ArrayList;
import Week05_chy.Week05_03.Book;
public class BookArrayList {
    private ArrayList<Week05_chy.Week05_03.Book> arrayList; //arrayList선언

    private Book book;
    public BookArrayList() {
        arrayList = new ArrayList<Week05_chy.Week05_03.Book>(); //Book형으로 선언한 ArrayList생성
    }

    public void addBook(Week05_chy.Week05_03.Book book) { //Book데이터 추가
        arrayList.add(book);
    }

    public boolean removeBook(int BookId) {
        for(int i = 0; i < arrayList.size();i++) {
            Week05_chy.Week05_03.Book book = arrayList.get(i);
            int tempId = book.getBookId();
            if(tempId == BookId) {
                arrayList.remove(i);
                return true;
            }
        }
        System.out.println(BookId + "가 존재하지 않습니다.");
        return false;
    }

    //직접 작성해보세요.
    public void insertBook(int insertIndex, Book newBook){
        arrayList.add(insertIndex, newBook);
    }

    public void showAllBook() {
        for(Book book : arrayList) {
            System.out.println(book);
        }
        System.out.println();
    }
}
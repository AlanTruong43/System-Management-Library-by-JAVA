/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Management_Library;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;       // Danh sách sách
    private List<Member> members;   // Danh sách thành viên

    // Constructor
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Thêm sách vào thư viện
    public void addBook(Book book) {
        books.add(book);
    }

    // Thêm thành viên vào thư viện
    public void addMember(Member member) {
        members.add(member);
    }

    // Lấy danh sách tất cả sách
    public List<Book> getAllBooks() {
        return books;
    }

    // Lấy danh sách sách đã mượn
    public List<Book> getBorrowedBooks() {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isBorrowed()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    // Lấy danh sách thành viên
    public List<Member> getMembers() {
        return members;
    }

    // Mượn sách
    public boolean borrowBook(String title, String memberId) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.borrowBook(memberId);
                return true; // Mượn sách thành công
            }
        }
        return false; // Không tìm thấy sách hoặc sách đã được mượn
    }

    // Trả sách
    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
                book.returnBook();
                return true; // Trả sách thành công
            }
        }
        return false; // Không tìm thấy sách hoặc sách chưa được mượn
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Management_Library;

/**
 *
 * @author LENOVO
 */
public class Book {
    private String title;      
    private String author;    
    private boolean isBorrowed; 
    private String borrowedBy; 

    // Constructor để khởi tạo một cuốn sách
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // Mặc định sách chưa được mượn
        this.borrowedBy = null;  // Mặc định chưa có người mượn
    }

    // Getter và Setter
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }
    public String getBorrowedBy() { return borrowedBy; }

    // Phương thức để mượn sách
    public void borrowBook(String memberId) {
        this.isBorrowed = true;
        this.borrowedBy = memberId;
    }

    // Phương thức để trả sách
    public void returnBook() {
        this.isBorrowed = false;
        this.borrowedBy = null;
    }

    @Override
    public String toString() {
        if (isBorrowed) {
            return title + " by " + author + " (Borrowed by: " + borrowedBy + ")";
        } else {
            return title + " by " + author;
        }
    }
}
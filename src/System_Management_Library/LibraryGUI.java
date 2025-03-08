package System_Management_Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LibraryGUI extends JFrame {
    private Library library; // Đối tượng thư viện
    private JTextArea outputArea; // Hiển thị thông tin

    // Constructor
    public LibraryGUI() {
        library = new Library(); // Khởi tạo thư viện
        setTitle("Library Management System"); // Tiêu đề cửa sổ
        setSize(600, 400); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng chương trình khi đóng cửa sổ

        // Tạo các thành phần giao diện
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false); // Không cho phép chỉnh sửa
        JScrollPane scrollPane = new JScrollPane(outputArea); // Thêm thanh cuộn
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2));

        // Nút thêm sách
        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        // Nút thêm thành viên
        JButton addMemberButton = new JButton("Add Member");
        addMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMember();
            }
        });

        // Nút hiển thị tất cả sách
        JButton listAllBooksButton = new JButton("List All Books");
        listAllBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAllBooks();
            }
        });

        // Nút hiển thị sách đã mượn
        JButton listBorrowedBooksButton = new JButton("List Borrowed Books");
        listBorrowedBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listBorrowedBooks();
            }
        });

        // Nút mượn sách
        JButton borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowBook();
            }
        });

        // Nút trả sách
        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });

        // Thêm các nút vào panel
        buttonPanel.add(addBookButton);
        buttonPanel.add(addMemberButton);
        buttonPanel.add(listAllBooksButton);
        buttonPanel.add(listBorrowedBooksButton);
        buttonPanel.add(borrowBookButton);
        buttonPanel.add(returnBookButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        add(panel); // Thêm panel vào JFrame
    }

    // Phương thức thêm sách
    private void addBook() {
        String title = JOptionPane.showInputDialog(this, "Enter book title:");
        String author = JOptionPane.showInputDialog(this, "Enter book author:");
        if (title != null && author != null) { // Kiểm tra null để tránh lỗi
            Book book = new Book(title, author);
            library.addBook(book);
            outputArea.append("Added book: " + book + "\n");
        }
    }

    // Phương thức thêm thành viên
    private void addMember() {
        String name = JOptionPane.showInputDialog(this, "Enter member name:");
        String memberId = JOptionPane.showInputDialog(this, "Enter member ID:");
        if (name != null && memberId != null) { // Kiểm tra null để tránh lỗi
            Member member = new Member(name, memberId);
            library.addMember(member);
            outputArea.append("Added member: " + member + "\n");
        }
    }

    // Phương thức hiển thị tất cả sách trong cửa sổ riêng biệt
    private void listAllBooks() {
        List<Book> books = library.getAllBooks();
        StringBuilder bookList = new StringBuilder("All Books:\n");
        for (Book book : books) {
            bookList.append(book).append("\n");
        }
        JOptionPane.showMessageDialog(this, bookList.toString(), "All Books", JOptionPane.INFORMATION_MESSAGE);
    }

    // Phương thức hiển thị sách đã mượn trong cửa sổ riêng biệt
    private void listBorrowedBooks() {
        List<Book> borrowedBooks = library.getBorrowedBooks();
        StringBuilder borrowedBookList = new StringBuilder("Borrowed Books:\n");
        for (Book book : borrowedBooks) {
            borrowedBookList.append(book).append("\n");
        }
        JOptionPane.showMessageDialog(this, borrowedBookList.toString(), "Borrowed Books", JOptionPane.INFORMATION_MESSAGE);
    }

    // Phương thức mượn sách
    private void borrowBook() {
        String title = JOptionPane.showInputDialog(this, "Enter book title to borrow:");
        String memberId = JOptionPane.showInputDialog(this, "Enter member ID:");
        if (title != null && memberId != null) { // Kiểm tra null để tránh lỗi
            if (library.borrowBook(title, memberId)) {
                outputArea.append("Book '" + title + "' borrowed by member ID: " + memberId + "\n");
            } else {
                outputArea.append("Failed to borrow book. Book not found or already borrowed.\n");
            }
        }
    }

    // Phương thức trả sách
    private void returnBook() {
        String title = JOptionPane.showInputDialog(this, "Enter book title to return:");
        if (title != null) { // Kiểm tra null để tránh lỗi
            if (library.returnBook(title)) {
                outputArea.append("Book '" + title + "' returned successfully.\n");
            } else {
                outputArea.append("Failed to return book. Book not found or not borrowed.\n");
            }
        }
    }
}
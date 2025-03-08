/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Management_Library;

/**
 *
 * @author LENOVO
 */
public class Member {
    private String name;    // Tên thành viên
    private String memberId; // Mã thành viên

    // Constructor để khởi tạo một thành viên
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getter và Setter
    public String getName() { return name; }
    public String getMemberId() { return memberId; }

    @Override
    public String toString() {
        return name + " (ID: " + memberId + ")"; // Hiển thị thông tin thành viên
    }
}
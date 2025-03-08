/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Management_Library;

import javax.swing.SwingUtilities;

/**
 *
 * @author LENOVO
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Tạo và hiển thị giao diện
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryGUI().setVisible(true); // Hiển thị cửa sổ
            }
        });
    }
}
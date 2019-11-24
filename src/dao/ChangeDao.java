package dao;

import model.Manager;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeDao {
    public void setStuPsd(Connection con, Student student,String newPassword) throws SQLException {
        String sql = "update t_student set password = ? where studentId = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, newPassword);
        pstmt.setString(2, student.getStudentId());
        pstmt.executeUpdate();
    }

    public void setManPsd(Connection con, Manager manager,String newPassword) throws SQLException {
        String sql = "update t_manager set password = ? where managerId = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, newPassword);
        pstmt.setString(2, manager.getManagerId());
        pstmt.executeUpdate();
    }
}

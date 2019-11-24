package dao;

import model.Manager;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    //学生登陆方法
    public Student Login(Connection con,Student student) throws SQLException {
        Student resultStudent = null;

        String sql = "select * from t_student where studentId = ? and password = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,student.getStudentId());
        pstmt.setString(2,student.getPassword());
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            resultStudent = new Student();
            resultStudent.setStudentId(rs.getString("studentId"));
            resultStudent.setName(rs.getString("name"));
            resultStudent.setPassword(rs.getString("password"));
            resultStudent.setDormBuild(rs.getString("dormBuild"));
            resultStudent.setDorm(rs.getString("dorm"));
        }
        return resultStudent;
    }

    //管理员登陆方法
    public Manager Login(Connection con,Manager manager) throws SQLException {
        Manager resultManager = null;

        String sql = "select * from t_manager where managerId = ? and password = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,manager.getManagerId());
        pstmt.setString(2,manager.getPassword());
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            resultManager = new Manager();
            resultManager.setManagerId(rs.getString("managerId"));
            resultManager.setName(rs.getString("name"));
            resultManager.setPassword(rs.getString("password"));
        }
        return resultManager;
    }
}

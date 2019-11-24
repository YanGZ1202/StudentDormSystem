package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> query(Connection con) throws SQLException {
        String sql = "select * from t_student";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Student> resultList = new ArrayList<Student>();
        Student student;

        while (rs.next()){
            student = new Student();
            student.setStudentId(rs.getString("studentId"));
            student.setName(rs.getString("name"));
            student.setPassword(rs.getString("password"));
            student.setDormBuild(rs.getString("dormBuild"));
            student.setDorm(rs.getString("dorm"));
            resultList.add(student);
        }
        return resultList;
    }

    public void insert(Connection con, Student student) throws SQLException {
        String sql = "insert into t_student(studentId,name,password,dormBuild,dorm) values(?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,student.getStudentId());
        pstmt.setString(2,student.getName());
        pstmt.setString(3,student.getPassword());
        pstmt.setString(4,student.getDormBuild());
        pstmt.setString(5,student.getDorm());
        pstmt.executeUpdate();
    }

    public void modify(Connection con,String studentId,String dormBuild,String dorm) throws SQLException {
        String sql = "update t_student set dormBuild = ?,dorm = ? where studentId = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,dormBuild);
        pstmt.setString(2,dorm);
        pstmt.setString(3,studentId);
        pstmt.executeUpdate();
    }

    public void delete(Connection con,String studentId) throws SQLException {
        String sql = "delete from t_student where studentId = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,studentId);
        pstmt.executeUpdate();
    }
}

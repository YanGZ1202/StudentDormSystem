package dao;

import model.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    public void register(Connection con, Record record) throws SQLException {
        String sql = "insert into t_record(date,studentId,name,dormBuild,dorm,detail) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,record.getDate());
        pstmt.setString(2,record.getStudentId());
        pstmt.setString(3,record.getName());
        pstmt.setString(4,record.getDormBuild());
        pstmt.setString(5,record.getDorm());
        pstmt.setString(6,record.getDetail());
        pstmt.executeUpdate();
    }
}

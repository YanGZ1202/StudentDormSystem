package dao;

import model.Repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RepairDao {
    //登记报修方法
    public void setRepair(Connection con, Repair repair) throws SQLException {
        String sql = "insert into t_repair(dormBuild, dorm, tel, description) values(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,repair.getDormBuild());
        pstmt.setString(2,repair.getDorm());
        pstmt.setString(3,repair.getTel());
        pstmt.setString(4,repair.getDescri());
        pstmt.executeUpdate();
    }
}

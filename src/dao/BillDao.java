package dao;

import model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDao {
    public List<Bill> query(Connection con) throws SQLException {
        String sql = "select * from t_bill";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Bill> resultList = new ArrayList<Bill>();
        Bill bill;

        while (rs.next()){
            bill = new Bill();
            bill.setDate(rs.getString("date"));
            bill.setCost(rs.getString("cost"));
            bill.setDormBuild(rs.getString("dormBuild"));
            bill.setDorm(rs.getString("dorm"));
            resultList.add(bill);
        }
        return resultList;
    }

    public void register(Connection con, Bill bill) throws SQLException {
        String sql = "insert into t_bill(date,dormBuild,dorm,cost) values(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,bill.getDate());
        pstmt.setString(2,bill.getDormBuild());
        pstmt.setString(3,bill.getDorm());
        pstmt.setString(4,bill.getCost());
        pstmt.executeUpdate();
    }
}

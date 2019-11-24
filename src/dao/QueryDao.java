package dao;

import model.Bill;
import model.Record;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDao {
    //查询晚归记录方法
    public List<Record> getRecordList(Connection con, Student student) throws SQLException {
        List<Record> recordList = new ArrayList<Record>();
        String sql = "select * from t_record where studentId = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,student.getStudentId());
        ResultSet rs = pstmt.executeQuery();
        Record record = null;
        while(rs.next()){
             record = new Record();
             record.setDate(rs.getString("date"));
             record.setStudentId(rs.getString("studentId"));
             record.setDormBuild(rs.getString("dormBuild"));
             record.setDorm(rs.getString("dorm"));
             record.setName(rs.getString("name"));
             record.setDetail(rs.getString("detail"));
             recordList.add(record);
        }
        return recordList;
    }

    //查询水电费方法
    public List<Bill> getBillList(Connection con,Student student) throws SQLException {
        List<Bill> billList = new ArrayList<Bill>();
        String sql = "select * from t_bill where dormBuild = ? and dorm = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,student.getDormBuild());
        pstmt.setString(2,student.getDorm());
        ResultSet rs = pstmt.executeQuery();
        Bill bill = null;
        System.out.println("a");

        while(rs.next()){
            bill = new Bill();
            bill.setDate(rs.getString("date"));
            bill.setDormBuild(rs.getString("dormBuild"));
            bill.setDorm(rs.getString("dorm"));
            bill.setCost(rs.getString("cost"));
            billList.add(bill);
            System.out.println("a");
        }
        return billList;
    }
}

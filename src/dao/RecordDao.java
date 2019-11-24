package dao;

import model.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordDao {
    public List<Record> getRecordList(Connection con) throws SQLException {
        List<Record> resultList = new ArrayList<Record>();
        String sql = "select * from t_record";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        Record record = null;

        while(rs.next()){
            record = new Record();
            record.setDate(rs.getString("date"));
            record.setStudentId(rs.getString("studentId"));
            record.setName(rs.getString("name"));
            record.setDormBuild(rs.getString("dormBuild"));
            record.setDorm(rs.getString("dorm"));
            record.setDetail(rs.getString("detail"));
            resultList.add(record);
        }
        return resultList;
    }
}

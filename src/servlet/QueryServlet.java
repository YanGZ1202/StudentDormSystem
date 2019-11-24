package servlet;

import dao.QueryDao;
import model.Bill;
import model.Record;
import model.Student;
import util.Dbutil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {

    private Dbutil dbutil= new Dbutil();
    private QueryDao queryDao = new QueryDao();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        Connection con;
        Student student = (Student)session.getAttribute("currentUser");
        try {
            con = dbutil.getCon();
            List<Record> recordList = queryDao.getRecordList(con,student);
            List<Bill> billList = queryDao.getBillList(con,student);
            session.setAttribute("recordList",recordList);
            session.setAttribute("billList",billList);
            request.getRequestDispatcher("student.jsp").forward(request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package servlet;

import dao.RegisterDao;
import model.Record;
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

@WebServlet("/regRecord")
public class RegRecordServlet extends HttpServlet {
    private Dbutil dbutil = new Dbutil();
    private RegisterDao recordDao = new RegisterDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String date = request.getParameter("date");
        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String dormBuild = request.getParameter("dormBuild");
        String dorm = request.getParameter("dorm");
        String detail = request.getParameter("detail");

        Connection con;
        try {
            con = dbutil.getCon();
            Record record = new Record(date,studentId,name,dormBuild,dorm,detail);
            recordDao.register(con,record);
            session.setAttribute("registerMsg","提交成功!");
            request.getRequestDispatcher("manager.jsp").forward(request,response);
            session.removeAttribute("registerMsg");
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

package servlet;

import dao.StudentDao;
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

@WebServlet("/studentQuery")
public class StudentQueryServlet extends HttpServlet {
    private Dbutil dbutil = new Dbutil();
    private StudentDao studentDao = new StudentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Connection con;
        try {
            con = dbutil.getCon();
            List<Student> studentList = studentDao.query(con);
            session.setAttribute("studentList",studentList);
            request.getRequestDispatcher("studentQuery.jsp").forward(request,response);
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

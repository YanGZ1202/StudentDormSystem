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

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private Dbutil dbutil = new Dbutil();
    private StudentDao studentDao = new StudentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String dormBuild = request.getParameter("dormBuild");
        String dorm = request.getParameter("dorm");
        String opType = request.getParameter("opType");

        Connection con;
        try {
            con = dbutil.getCon();
            Student student = null;

            if ("insert".equals(opType)) {
                student = new Student(studentId,name,password,dormBuild,dorm);
                studentDao.insert(con,student);
                session.setAttribute("studentMsg","添加成功！");
            } else if ("modify".equals(opType)) {
                studentDao.modify(con,studentId,dormBuild,dorm);
                session.setAttribute("studentMsg","修改成功！");
            }else{
                studentDao.delete(con,studentId);
                session.setAttribute("studentMsg","删除成功！");
            }
            request.getRequestDispatcher("studentMsg.jsp").forward(request,response);
            session.removeAttribute("studentMsg");
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

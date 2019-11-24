package servlet;

import dao.OutputDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/outputStu")
public class OutputStuServlet extends HttpServlet {
    private OutputDao outputDao = new OutputDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        List<Student> studentList = (List<Student>) session.getAttribute("studentList");
        outputDao.outputStu(studentList);
        session.setAttribute("outputMsg","导出成功！");
        request.getRequestDispatcher("studentQuery.jsp").forward(request,response);
        session.removeAttribute("outputMsg");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

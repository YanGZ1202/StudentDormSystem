package servlet;

import dao.UserDao;
import model.Manager;
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

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private Dbutil dbutil = new Dbutil();
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        //获取输入信息
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        Connection con;
        try {
            con = dbutil.getCon();
            Student currentStudent;
            Manager currentManager = null;

            //学生登陆
            if("student".equals(userType)){
                Student student = new Student(userId,password);
                currentStudent = userDao.Login(con,student);
                if(currentStudent == null){
                    request.setAttribute("student",student);
                    request.setAttribute("error","用户或密码错误");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }else{
                    session.setAttribute("currentUserType","student");
                    session.setAttribute("currentUser",currentStudent);
                    request.getRequestDispatcher("studentblank.jsp").forward(request,response);
                }
            }
            //管理员登陆
            else{
                Manager manager = new Manager(userId,password);
                currentManager = userDao.Login(con,manager);
                if(currentManager == null){
                    request.setAttribute("manager",manager);
                    request.setAttribute("error","用户名或密码错误");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }else{
                    session.setAttribute("currentUserType","manager");
                    session.setAttribute("currentUser",currentManager);
                    request.getRequestDispatcher("managerblank.jsp").forward(request,response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package servlet;

import dao.ChangeDao;
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
import java.sql.SQLException;

@WebServlet("/changepsd")
public class ChangePsdServlet extends HttpServlet {
    private Dbutil dbutil = new Dbutil();
    private ChangeDao changeDao = new ChangeDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if("stuChange".equals(action)){
            stuChange(request,response);
        }else{
            manChange(request,response);
        }
    }

    private void stuChange(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("currentUser");
        String newPsd = request.getParameter("newPsd");
        Connection con;
        try {
            con = dbutil.getCon();
            changeDao.setStuPsd(con,student,newPsd);
            student.setPassword(newPsd);
            session.setAttribute("changeMsg","修改成功");
            request.getRequestDispatcher("changepassword.jsp").forward(request,response);
            session.removeAttribute("changeMsg");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void manChange(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("currentUser");
        String newPsd = request.getParameter("newPsd");
        Connection con;
        try {
            con = dbutil.getCon();
            changeDao.setManPsd(con,manager,newPsd);
            manager.setPassword(newPsd);
            session.setAttribute("changeMsg","修改成功");
            request.getRequestDispatcher("changepasswords.jsp").forward(request,response);
            session.removeAttribute("changeMsg");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

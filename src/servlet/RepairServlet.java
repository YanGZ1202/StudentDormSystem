package servlet;

import dao.RepairDao;
import model.Repair;
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

@WebServlet("/repair")
public class RepairServlet extends HttpServlet {
    private Dbutil dbutil = new Dbutil();
    private RepairDao repairDao = new RepairDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String dormBuild = request.getParameter("dormBuild");
        String dorm = request.getParameter("dorm");
        String descri = request.getParameter("descri");
        String tel = request.getParameter("tel");

        Connection con;
        try {
            con = dbutil.getCon();
            Repair repair = new Repair(dormBuild,dorm,tel,descri);
            repairDao.setRepair(con,repair);
            session.setAttribute("repairMsg","报修成功");
            request.getRequestDispatcher("repair.jsp").forward(request,response);
            session.removeAttribute("repairMsg");
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

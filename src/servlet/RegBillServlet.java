package servlet;

import dao.BillDao;
import model.Bill;
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

@WebServlet("/regBill")
public class RegBillServlet extends HttpServlet {
    private Dbutil dbutil = new Dbutil();
    private BillDao billDao = new BillDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String date = request.getParameter("date");
        String dormBuild = request.getParameter("dormBuild");
        String dorm = request.getParameter("dorm");
        String cost = request.getParameter("cost");

        Connection con;
        try {
            con = dbutil.getCon();
            Bill bill = new Bill(date,dormBuild,dorm,cost);
            billDao.register(con,bill);
            session.setAttribute("billMsg","提交成功！");
            request.getRequestDispatcher("bill.jsp").forward(request,response);
            session.removeAttribute("billMsg");
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

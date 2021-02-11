package servlets;

import dao.CategoryDao;
import model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    CategoryDao categoryDao = new CategoryDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listCategory(request,response);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Category> categoryList = categoryDao.fetch();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(request,response);
    }
}

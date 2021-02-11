package servlets;

import dao.CategoryDao;
import dao.ExpressionDao;
import model.Category;
import model.Expression;
import model.SearchResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    ExpressionDao expressionDao = new ExpressionDao();
    CategoryDao categoryDao = new CategoryDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                search(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String word = "";
        int cId = 1, page = 1;
        if (request.getParameter("word") != null) word = request.getParameter("word");
        if (request.getParameter("categoryId") != null) cId = Integer.parseInt(request.getParameter("categoryId"));
        if (request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
        SearchResult expressions = expressionDao.search(word, cId, page);
        request.setAttribute("expressions", expressions);
        List<Category> categoryList = categoryDao.fetch();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
        requestDispatcher.forward(request,response);
    }
}

package dao;

import model.Category;
import java.sql.SQLException;
import java.util.Stack;

public class CategoryDao extends Dao<Category> {
    private Stack<Category> categories;

    @Override
    public Stack<Category> fetch() {
        if (categories != null) return categories;
        categories = new Stack<>();
        try {
            getConnection();
            query = "SELECT c.id, c.name, count(e.id) FROM categories c " +
                    "LEFT JOIN expressions e on c.id = e.category_id " +
                    "GROUP BY c.id, c.name " +
                    "ORDER BY 2";
            pStatement = connection.prepareStatement(query);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int count = resultSet.getInt(3);
                Category category = new Category(id, name, count);
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return categories;
    }

    @Override
    public void add(Category category) {
        try {
            getConnection();
            query = "Insert into categories(id, name) VALUES (?,?)";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, category.getId());
            pStatement.setString(2, category.getName());
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public void edit(Category o) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Category get(int id) {
        Category category = new Category();
        try {
            getConnection();
            query = "SELECT * From categories where id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                int catId = resultSet.getInt("id");
                String firstName = resultSet.getString("name");
                category.setId(catId);
                category.setName(firstName);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement,connection);
        }
        return category;
    }

    public Stack<Category> getCategories() {
        return categories;
    }
}

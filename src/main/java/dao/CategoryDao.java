package dao;

import model.Category;
import java.sql.SQLException;
import java.util.Stack;

public class CategoryDao extends Dao<Category> {
    private final Stack<Category> categories= new Stack<>();

    @Override
    public Stack<Category> fetch() {
        try {
            getConnection();
            query = "SELECT * From categories";
            pStatement = connection.prepareStatement(query);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Category category = new Category(id, name);
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
}

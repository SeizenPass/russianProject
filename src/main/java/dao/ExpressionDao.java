package dao;

import model.Category;
import model.Expression;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpressionDao extends Dao<Expression> {
    private final List<Expression> expressions = new ArrayList<>();

    @Override
    public List<Expression> fetch() {
        try {
            getConnection();
            query = "SELECT * From expressions";
            pStatement = connection.prepareStatement(query);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String expression = resultSet.getString(2);
                String translation = resultSet.getString(3);
                String transcription = resultSet.getString(4);
                String description = resultSet.getString(5);
                String example = resultSet.getString(6);
                int categoryId = resultSet.getInt(7);
                Expression expr = new Expression(id, expression, translation, transcription, description, example, categoryId);
                expressions.add(expr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return expressions;
    }

    @Override
    public void add(Expression o) {

    }

    @Override
    public void edit(Expression o) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Expression get(int id) {
        Expression expression = new Expression();
        try {
            getConnection();
            query = "SELECT * From expressions where id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                int expr_id = resultSet.getInt("id");
                String expr = resultSet.getString("expression");
                String translation = resultSet.getString("translation");
                String transcription = resultSet.getString("transcription");
                String description = resultSet.getString("description");
                String example = resultSet.getString("example");
                int catId = resultSet.getInt("category_id");
                expression.setId(expr_id);
                expression.setExpression(expr);
                expression.setTranscription(translation);
                expression.setTranscription(transcription);
                expression.setDescription(description);
                expression.setExample(example);
                expression.setCategoryId(catId);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement,connection);
        }
        return expression;
    }
}

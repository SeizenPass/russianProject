package dao;

import model.Expression;
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
        return null;
    }
}

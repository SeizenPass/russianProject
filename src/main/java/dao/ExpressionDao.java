package dao;

import model.Category;
import model.Expression;
import model.SearchResult;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
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

    public SearchResult search(String word, int categoryId, int page) {
        SearchResult searchResult = new SearchResult();
        List<Expression> expressions = new LinkedList<>();
        try {
            getConnection();
            //SELECT * FROM expressions where (expression LIKE '%e%'
            //OR translation LIKE '%a%' OR transcription LIKE '%e%' OR description LIKE '%e%'
            //    OR example LIKE '%a%') AND category_id = 9 LIMIT 10 OFFSET 0;
            query = "SELECT * FROM expressions ";
            String totalQuery = "SELECT COUNT(*) FROM expressions ";
            boolean combined = false;
            if (!word.trim().equals("")) {
                combined = true;
                query += " WHERE ";
                totalQuery += " WHERE ";
                String likeStr = " (expression LIKE ? " +
                        "OR translation LIKE ? OR transcription LIKE ? OR description LIKE ? " +
                        "OR example LIKE ?) ";
                query += likeStr;
                totalQuery += likeStr;
            }
            if (categoryId != 1) {
                if (combined) {
                    query += " AND ";
                    totalQuery += " AND ";
                }
                else {
                    query += " WHERE ";
                    totalQuery += " WHERE ";
                }
                String cIdStr = " category_id = ? ";
                query += cIdStr;
                totalQuery += cIdStr;
            }
            query += " LIMIT 10 OFFSET ? ";
            pStatement = connection.prepareStatement(query);

            int propertyCounter = 1;
            if (!word.trim().equals("")) {
                String likeWord = "%" + word.trim() +"%";
                for (int i = 1; i <= 5; i++) {
                    pStatement.setString(propertyCounter++, likeWord);
                }
            }
            if (categoryId != 1) {
                pStatement.setInt(propertyCounter++, categoryId);
            }
            pStatement.setInt(propertyCounter++, (page-1) * 10);
            searchResult.setPage(page);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int expr_id = resultSet.getInt("id");
                String expr = resultSet.getString("expression");
                String translation = resultSet.getString("translation");
                String transcription = resultSet.getString("transcription");
                String description = resultSet.getString("description");
                String example = resultSet.getString("example");
                int catId = resultSet.getInt("category_id");
                Expression expression = new Expression();
                expression.setId(expr_id);
                expression.setExpression(expr);
                expression.setTranscription(translation);
                expression.setTranscription(transcription);
                expression.setDescription(description);
                expression.setExample(example);
                expression.setCategoryId(catId);
                expressions.add(expression);
            }
            pStatement = connection.prepareStatement(totalQuery);
            propertyCounter = 1;
            if (!word.trim().equals("")) {
                String likeWord = "%" + word.trim() +"%";
                for (int i = 1; i <= 5; i++) {
                    pStatement.setString(propertyCounter++, likeWord);
                }
            }
            if (categoryId != 1) {
                pStatement.setInt(propertyCounter++, categoryId);
            }
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                searchResult.setTotal((resultSet.getInt(1) / 10) + 1);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement,connection);
        }
        searchResult.setExpressionList(expressions);
        return searchResult;
    }
}

package ch.lab4tech.jav09.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.lab4tech.jav09.db.CommonJdbcConnection;
import ch.lab4tech.jav09.model.Category;

public class CategoryJdbcDAO extends CommonJdbcConnection implements CategoryDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public List<Category> find() {
        List<Category> categories = new ArrayList<Category>();
        Category category = null;

        try {
            String query = "SELECT * FROM tblcategories";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                category = new Category();
                category.setCode(Integer.parseInt(resultSet.getString(1)));
                category.setDescription(resultSet.getString(2));
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return categories;
    }
}
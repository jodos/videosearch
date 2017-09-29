package ch.lab4tech.jav09.dao;

import ch.lab4tech.jav09.db.CommonJdbcConnection;
import ch.lab4tech.jav09.model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDAO extends CommonJdbcConnection implements CategoryDAO {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public List<String> find() {
        List<String> categories = new ArrayList<String>();
        Category category = null;

        try {
            String query = "SELECT Description FROM tblcategories";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                categories.add(resultSet.getString(1));
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

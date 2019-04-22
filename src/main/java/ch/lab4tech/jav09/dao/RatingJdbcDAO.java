package ch.lab4tech.jav09.dao;

import ch.lab4tech.jav09.db.CommonJdbcConnection;
import ch.lab4tech.jav09.model.Rating;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingJdbcDAO extends CommonJdbcConnection implements RatingDAO {

    private PreparedStatement PreparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public List<Rating> find() {
        List<Rating> ratings = new ArrayList<Rating>();
        Rating rating;

        try {
            String query = "SELECT * FROM tblratings";
            connection = getConnection();
            PreparedStatement = connection.prepareStatement(query);
            resultSet = PreparedStatement.executeQuery();

            while (resultSet.next()) {
                rating = new Rating();
                rating.setRating(resultSet.getString(1));
                rating.setDescription(resultSet.getString(2));
                ratings.add(rating);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (PreparedStatement != null)
                    PreparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ratings;
    }
}
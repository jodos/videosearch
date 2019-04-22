package ch.lab4tech.jav09.dao;

import ch.lab4tech.jav09.db.CommonJdbcConnection;
import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Movie;
import ch.lab4tech.jav09.model.Rating;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieJdbcDAO extends CommonJdbcConnection implements MovieDAO {

    private final PreparedStatement preparedStatement = null;
    private final ResultSet resultSet = null;
    private String currentSQLQuery = null;

    @Override
    public List<Movie> findByCodeAndRating(List<Category> categories, List<Rating> ratings) {
        List<Movie> movies = new ArrayList<>();
        Movie movie;

        final int sizeCategories = categories.size();
        final int sizeRatings = ratings.size();

        if (sizeCategories > 0 || sizeRatings > 0) {

            try {
                StringBuilder SQLquery = new StringBuilder();
                SQLquery.append("SELECT Title, Rating, CategoryCode, Description FROM tblmovietitles WHERE ");

                if (sizeCategories > 0) {
                    SQLquery.append("(");
                    for (int index = 1; index <= sizeCategories; index++) {
                        SQLquery.append("CategoryCode=?");
                        if (index == sizeCategories) {
                            SQLquery.append(")");
                        } else {
                            SQLquery.append(" OR ");
                        }
                    }
                    if (sizeRatings > 0) {
                        SQLquery.append(" AND ");
                    }
                }

                if (sizeRatings > 0) {
                    SQLquery.append("(");
                    for (int index = 1; index <= sizeRatings; index++) {
                        SQLquery.append("Rating=?");
                        if (index == sizeRatings) {
                            SQLquery.append(")");
                        } else {
                            SQLquery.append(" OR ");
                        }
                    }
                }

                connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQLquery.toString());

                for (int index = 0; index < sizeCategories; index++) {
                    Category categorie = categories.get(index);
                    preparedStatement.setInt(index + 1, categorie.getCode());
                }

                for (int index = 0; index < sizeRatings; index++) {
                    Rating rating = ratings.get(index);
                    preparedStatement.setString(sizeCategories + 1 + index, rating.getRating());
                }

                this.currentSQLQuery = preparedStatement.toString();
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    movie = new Movie();
                    movie.setTitle(rs.getString(1));
                    movie.setRating(rs.getString(2));
                    movie.setCategoryCode(rs.getInt(3));
                    movie.setDescription(rs.getString(4));
                    movies.add(movie);
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
        }
        return movies;
    }

    @Override
    public String showCurrentSQLQuery() {
        if (currentSQLQuery != null) {
            int indexOfColon = currentSQLQuery.indexOf(':');
            return currentSQLQuery.substring(indexOfColon + 1).trim();
        } else {
            return "";
        }
    }
}
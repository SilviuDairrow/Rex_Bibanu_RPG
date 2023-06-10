import java.sql.*;

public class Database_Manager {
    private Connection connection;
    private final String databaseName = "game_database.db";

    public Database_Manager() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName);
            createTable();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS game_data (" +
                "Killcount INTEGER, " +
                "Player_Pos_X INTEGER, " +
                "Player_Pos_Y INTEGER, " +
                "WEAPON TEXT" +
                ")";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(int killcount, int posX, int posY, String weapon) {
        String query = "INSERT INTO game_data (Killcount, Player_Pos_X, Player_Pos_Y, WEAPON) " +
                "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, killcount);
            preparedStatement.setInt(2, posX);
            preparedStatement.setInt(3, posY);
            preparedStatement.setString(4, weapon);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        String query = "SELECT * FROM game_data";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int killcount = resultSet.getInt("Killcount");
                int posX = resultSet.getInt("Player_Pos_X");
                int posY = resultSet.getInt("Player_Pos_Y");
                String weapon = resultSet.getString("WEAPON");
                System.out.println("Killcount: " + killcount +
                        ", Player Pos X: " + posX +
                        ", Player Pos Y: " + posY +
                        ", Weapon: " + weapon);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeDatabase() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
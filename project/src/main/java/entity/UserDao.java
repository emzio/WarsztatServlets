package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;



import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.Arrays;

public class UserDao {

    private static final String UPDATE_USER_QUERY = "UPDATE users SET email = ?, username = ?, password = ? WHERE id = ?";
    private static final String CREATE_USER_QUERY = "INSERT INTO users (email, username, password) VALUES (?,?,?);";
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USERS = "SELECT * FROM users";

    public String hashPassword(String password) {
        return org.mindrot.jbcrypt.BCrypt.hashpw(password, org.mindrot.jbcrypt.BCrypt.gensalt());
    }

    public User create (User user){

        try (Connection connection = DBUtil.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            String hashed = hashPassword(user.getPassword());
            preparedStatement.setString(3,hashed);
            preparedStatement.executeUpdate();

            user.setId(getGeneratedKey(preparedStatement));
            user.setPassword(hashed);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        user.print();
        return user;
    }

    public User read(int userId){
        String query = "SELECT * FROM users WHERE id = ?";
        User user = new User();
        if (checkingId(userId)){

            try (Connection connection = DBUtil.connect()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, userId);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    user.setId(userId);
                    user.setEmail(rs.getString("email"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
//                    user.print();
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            user = null;
        }
        return user;
    }

    public static int getGeneratedKey(PreparedStatement preparedStatement) throws SQLException {
        ResultSet rs = preparedStatement.getGeneratedKeys();
        int id = 0;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public static boolean checkingId(int id){  //sprawdzam czy tabela zawiera element o zadanym id
        boolean ifContain = false;

        try (Connection connection = DBUtil.connect()) {
            String query = "SELECT id FROM users ORDER BY id";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                if (id == rs.getInt("id")){
                    ifContain = true;
                    break;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ifContain;
    }

//    public void update2(User user){
//        User user2 = read(user.getId());
//        if (user2 != null){
//            user2.setId(user.getId());
//            user2.setEmail(user.getEmail());
//            user2.setUsername(user.getUsername());
//            user2.setPassword(hashPassword(user.getPassword()));
//            System.out.println("updating");
////            user.print();
////            user2.print();
//            updateExistingUser(user2);
//        } else {
//            System.out.println("User not exist");
//        }
//    }

    public void update(User user){
        if (checkingId(user.getId())){
            System.out.print("updating user : ");
            user.print();
            updateExistingUser(user);
        } else {
//            user = null;
            System.out.println("User not exist");
//            System.out.println(user==null);
        }
    }

    public void updateExistingUser(User user){
        try (Connection connection = DBUtil.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            String hashed = hashPassword(user.getPassword());
            preparedStatement.setString(3, hashed);

            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            user.setPassword(hashed);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int userId){
        try (Connection connection = DBUtil.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    public int lastId(){
//        int lastId = 0;
//        String query = "SELECT id FROM users ORDER BY id";
//
//        try (Connection connection = DBUtil.connect()){
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                lastId = rs.getInt("id");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return lastId;
//    }

    public User[] findAll(){
        User[] users = new User[0];

        try (Connection connection = DBUtil.connect()){
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users = addToArray(user, users);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1); // Tworzymy kopię tablicy powiększoną o 1.
        tmpUsers[users.length] = u; // Dodajemy obiekt na ostatniej pozycji.
        return tmpUsers; // Zwracamy nową tablicę.
    }



//    public static String hashPassword(String password) {
//        return org.mindrot.jbcrypt.BCrypt.hashpw(password, org.mindrot.jbcrypt.BCrypt.gensalt());
//    }
//// zmiany start
//    public static User create (User user){
//
//        try (Connection connection = DBUtil.connect()){
//            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
//            preparedStatement.setString(1,user.getEmail());
//            preparedStatement.setString(2, user.getUsername());
//            String hashed = hashPassword(user.getPassword());
//            preparedStatement.setString(3,hashed);
//            preparedStatement.executeUpdate();
//
//            user.setId(getGeneratedKey(preparedStatement));
//            user.setPassword(hashed);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
////        user.print();
//        return user;
//    }
//
//    public static User read(int userId){
//        String query = "SELECT * FROM users WHERE id = ?";
//        User user = new User();
//        if (checkingId(userId)){
//
//            try (Connection connection = DBUtil.connect()) {
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//                preparedStatement.setInt(1, userId);
//                ResultSet rs = preparedStatement.executeQuery();
//                if (rs.next()) {
//                    user.setId(userId);
//                    user.setEmail(rs.getString("email"));
//                    user.setUsername(rs.getString("username"));
//                    user.setPassword(rs.getString("password"));
////                    user.print();
//                }
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        } else {
//            user = null;
//        }
//        return user;
//    }
//
//    public static int getGeneratedKey(PreparedStatement preparedStatement) throws SQLException {
//        ResultSet rs = preparedStatement.getGeneratedKeys();
//        int id = 0;
//        if (rs.next()) {
//            id = rs.getInt(1);
//        }
//        return id;
//    }
//
//    public static boolean checkingId(int id){  //sprawdzam czy tabela zawiera element o zadanym id
//        boolean ifContain = false;
//
//        try (Connection connection = DBUtil.connect()) {
//            String query = "SELECT id FROM users ORDER BY id";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                if (id == rs.getInt("id")){
//                    ifContain = true;
//                    break;
//                }
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return ifContain;
//    }
//
////    public void update2(User user){
////        User user2 = read(user.getId());
////        if (user2 != null){
////            user2.setId(user.getId());
////            user2.setEmail(user.getEmail());
////            user2.setUsername(user.getUsername());
////            user2.setPassword(hashPassword(user.getPassword()));
////            System.out.println("updating");
//////            user.print();
//////            user2.print();
////            updateExistingUser(user2);
////        } else {
////            System.out.println("User not exist");
////        }
////    }
//
//    public static void update(User user){
//        if (checkingId(user.getId())){
//            System.out.print("updating user : ");
//            user.print();
//            updateExistingUser(user);
//        } else {
////            user = null;
//            System.out.println("User not exist");
////            System.out.println(user==null);
//        }
//    }
//
//    public static void updateExistingUser(User user){
//        try (Connection connection = DBUtil.connect()){
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
//            preparedStatement.setString(1, user.getEmail());
//            preparedStatement.setString(2, user.getUsername());
//            String hashed = hashPassword(user.getPassword());
//            preparedStatement.setString(3, hashed);
//
//            preparedStatement.setInt(4, user.getId());
//            preparedStatement.executeUpdate();
//            user.setPassword(hashed);
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public static void delete(int userId){
//        try (Connection connection = DBUtil.connect()){
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
//            preparedStatement.setInt(1, userId);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
////    public int lastId(){
////        int lastId = 0;
////        String query = "SELECT id FROM users ORDER BY id";
////
////        try (Connection connection = DBUtil.connect()){
////            PreparedStatement preparedStatement = connection.prepareStatement(query);
////            ResultSet rs = preparedStatement.executeQuery();
////            while (rs.next()){
////                lastId = rs.getInt("id");
////            }
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////        return lastId;
////    }
//
//    public static User[] findAll(){
//        User[] users = new User[0];
//
//        try (Connection connection = DBUtil.connect()){
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setEmail(rs.getString("email"));
//                user.setUsername(rs.getString("username"));
//                user.setPassword(rs.getString("password"));
//                users = addToArray(user, users);
//            }
//            return users;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return null;
//        }
//    }
//
//    private static User[] addToArray(User u, User[] users) {
//        User[] tmpUsers = Arrays.copyOf(users, users.length + 1); // Tworzymy kopię tablicy powiększoną o 1.
//        tmpUsers[users.length] = u; // Dodajemy obiekt na ostatniej pozycji.
//        return tmpUsers; // Zwracamy nową tablicę.
//    }

}

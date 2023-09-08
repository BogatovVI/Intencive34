package ru.aston.bogatov_vi.task3.Dao;

import ru.aston.bogatov_vi.task3.ConnectorDB;
import ru.aston.bogatov_vi.task3.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements DaoDataEntityLayer<User>{
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SQL_SELECT_USER_ID = "SELECT * FROM users WHERE id=?";
    private static final String SQL_DELETE_USER_ID = "DELETE FROM users WHERE id=?";
    private static final String SQL_CREATE_USER = "INSERT INTO users (name, surname, telephone, email, id_order)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE users " +
            "SET name = ?, surname = ?, telephone = ?, email = ?, id_order = ?" +
            "WHERE id = ?";

    private static final String SQL_SELECT_USERS_JOIN_ORDERS
            = "SELECT users.name, o.name FROM users JOIN orders o on o.Id = users.Id_order";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try(Connection connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()){
                users.add(new User(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User findEntityById(int id) {
        User user = null;
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User(resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),
                                resultSet.getString(5), resultSet.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_USER_ID)) {
            statement.setLong(1, id);
            if (statement.executeUpdate() > 0){
                isDelete = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    @Override
    public boolean create(User user) {
        boolean isCreate = false;
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getTelephone());
            statement.setString(4, user.getMail());
            statement.setInt(5, user.getOrderId());
            if (statement.executeUpdate() > 0){
                isCreate = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isCreate;
    }

    @Override
    public User update(User user) {
        User resultUser = null;
        try(Connection connection = ConnectorDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getTelephone());
            statement.setString(4, user.getMail());
            statement.setInt(5, user.getOrderId());
            statement.setInt(6, user.getId());
            if (statement.executeUpdate() > 0){
                resultUser = findEntityById(user.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultUser;
    }

    public List<String> joinUsersAndOrders() {
        List<String> listJoin = new ArrayList<>();
        try(Connection connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USERS_JOIN_ORDERS);
            while (resultSet.next()){
                listJoin.add("Имя пользователя: " +resultSet.getString(1)
                        + " Именование заказа: " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listJoin;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import function.LoginSampleException;
import function.OrderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SebastianBernthJepse
 */
public class DataMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO User (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(email, password);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public void createOrder(Order order) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "insert into `Orders` (email, width, length, height, 2x4Bricks, 2x2Bricks, 2x1Bricks) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getEmail());
            ps.setInt(2, order.getWidth());
            ps.setInt(3, order.getHeight());
            ps.setInt(4, order.getLength());
            ps.setInt(5, order.getBrick2x1());
            ps.setInt(6, order.getBrick2x2());
            ps.setInt(7, order.getBrick2x4());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public ArrayList<Order> getOrders(String email) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "select * from `Orders` where email ='" + email + "';";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                orders.add(new Order(rs.getString("email"), rs.getInt("width"), rs.getInt("length"), rs.getInt("height"), rs.getInt("2x4Bricks"), rs.getInt("2x2Bricks"), rs.getInt("2x1Bricks"), rs.getInt("orderId"), rs.getBoolean("shipped")));
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static void main(String[] args) throws LoginSampleException {
        User user = new User("test@mail.dk", "name", "pw");
        createUser(user);
    }

}

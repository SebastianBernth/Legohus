package function;

import data.DataMapper;
import data.Order;
import data.User;
import java.util.ArrayList;



public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return DataMapper.login( email, password);
    } 

    public static User createUser( String email, String username, String password ) throws LoginSampleException {
        User user = new User(email, password, username);
        DataMapper.createUser( user );
        return user;
    }
    
    public boolean createOrder(String email, int height, int length, int width, int brick2x1, int brick2x2, int brick2x4, int orderId, boolean shipped){
        try{
            Order order = new Order(email, height, length, width, brick2x1, brick2x2, brick2x4, orderId, shipped);
            DataMapper dm = new DataMapper();
            dm.createOrder(order);
            return true;
        } catch (OrderException ex) {
            return false;
        }
    }
    
    public ArrayList<Order> getOrders(String email) throws OrderException{
        DataMapper dm = new DataMapper();
        return dm.getOrders(email);
    }

}

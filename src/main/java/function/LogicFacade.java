package function;

import data.DataMapper;
import data.User;


public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return DataMapper.login( email, password);
    } 

    public static User createUser( String email, String username, String password ) throws LoginSampleException {
        User user = new User(email, password, username);
        DataMapper.createUser( user );
        return user;
    }

}

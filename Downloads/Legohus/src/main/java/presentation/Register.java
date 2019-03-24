package presentation;

import function.LogicFacade;
import function.LoginSampleException;
import data.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String username = request.getParameter("username");
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( email, username, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            return user + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}

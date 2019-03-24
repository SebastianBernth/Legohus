package presentation;

import function.LogicFacade;
import function.LoginSampleException;
import data.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandRegister extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(email, username, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }
}



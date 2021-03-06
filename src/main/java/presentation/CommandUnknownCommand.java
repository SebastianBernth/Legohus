package presentation;

import function.LoginSampleException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The purpose of UnknownCommand is to...
 *
 * @author kasper
 */
public class CommandUnknownCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException {
        String msg = "Unknown command. Contact IT";
        throw new LoginSampleException(msg);
    }

}



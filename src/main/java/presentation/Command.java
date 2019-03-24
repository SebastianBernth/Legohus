package presentation;

import function.LoginSampleException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {

    private static HashMap<String, Command> commands;

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, LoginSampleException;

    public static Command from(HttpServletRequest request)
    {
        Command c;
        
        String origin = request.getParameter("command");
        
        HashMap<String, Command> commands;

        commands = new HashMap<>();
        commands.put("login", new CommandLogin());
        commands.put("register", new CommandRegister());
        commands.put("mainPage", new CommandMainPage());

        c = commands.getOrDefault(origin, new CommandUnknownCommand());
        
        return c;
    }

}

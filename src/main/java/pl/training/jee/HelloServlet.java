package pl.training.jee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "say-hello")
public class HelloServlet extends HttpServlet {

    private static final String NAME_PARAM = "name";
    private static final String NAME_ATTRIBUTE = "name";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter(NAME_PARAM);
        if (name == null) {
            name = "";
        }
        request.setAttribute(NAME_ATTRIBUTE, name);
        var dispatcher = getServletContext().getRequestDispatcher("/say-hello.jsp");
        dispatcher.forward(request, response);
    }

}

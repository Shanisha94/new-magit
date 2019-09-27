package chat.servlets;
import chat.constants.Constants;
import chat.utils.ServletUtils;
import com.google.gson.Gson;
import engine.users.UserManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profileServlet")
public class ProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Profile servlet was called");
        response.setContentType("application/json");
        UserManager userManager = ServletUtils.getUserManager(getServletContext());
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(userManager);
        request.setAttribute(Constants.USERNAME, userManager.getActiveUser());
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

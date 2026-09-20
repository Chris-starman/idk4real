package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/process")
public class ProcessServlet extends HttpServlet {

    // MUST BE PUBLIC: Changing this from protected to public allows your test to call it
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Retrieve the value from the form input named "username"
        String name = request.getParameter("username");

        // Fallback protection in case input is blank
        if (name == null || name.trim().isEmpty()) {
            name = "Anonymous";
        }

        // 2. Set the data as a request attribute for the JSP to read
        request.setAttribute("usernameAttr", name);

        // 3. Forward the request to the display page (renamed from result.jsp to result.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    // Optional: Standard practice to forward GET requests to the POST handler or index
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

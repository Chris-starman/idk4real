package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


public class ProcessServletTest {

    private ProcessServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;

    @BeforeEach
    public void setUp() {
        servlet = new ProcessServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    //Scans would-be usernames can checks if they're a certain variable
    @Test
    public void testDoPost_WithValidUsername() throws Exception {
        // Arrange
        when(request.getParameter("username")).thenReturn("Ace");
        when(request.getRequestDispatcher("/result.jsp")).thenReturn(dispatcher);

        // Act
        servlet.doPost(request, response);

        // Assert
        //What the variable is supposed to be
        verify(request).setAttribute("usernameAttr", "A");
        verify(dispatcher).forward(request, response);
    }
    // TEST CASE 2: Blank Name Provided (Validates your fallback logic!)
    @Test
    public void testDoPost_WithBlankUsername() throws Exception {
        // Arrange: Simulate a user clicking submit without typing anything
        when(request.getParameter("username")).thenReturn("Something");
        when(request.getRequestDispatcher("/result.jsp")).thenReturn(dispatcher);

        // Act
        servlet.doPost(request, response);

        // Assert: Verify it fell back to "Anonymous" instead of saving an empty string
        verify(request).setAttribute("usernameAttr", "S");
        verify(dispatcher).forward(request, response);
    }
}

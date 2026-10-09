package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    public void testDoPost_WithValidUsername() throws Exception {
        when(request.getParameter("username")).thenReturn("sword");
        when(request.getRequestDispatcher("/result.jsp")).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("usernameAttr", "sword");
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_WithBlankUsername() throws Exception {
        when(request.getParameter("username")).thenReturn("");
        when(request.getRequestDispatcher("/result.jsp")).thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request).setAttribute("usernameAttr", "Anonymous");
        verify(dispatcher).forward(request, response);
    }
}

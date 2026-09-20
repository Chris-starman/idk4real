package com.example;

// Updated package paths to match the new library version
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlForm;
import org.htmlunit.html.HtmlPage;
import org.htmlunit.html.HtmlSubmitInput;
import org.htmlunit.html.HtmlTextInput;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkflowIT {

    @Test
    public void testLiveTomcatJspWorkflow() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            // Disable CSS/JS errors if your JSPs throw warnings during testing
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

            // 1. Hit the live local Tomcat server root instance
            // Ensure your test matches the Tomcat 8080 port layout!
            final HtmlPage indexPage = webClient.getPage("http://localhost:8080/demo/index.jsp");


            // 2. Fetch form parameters
            final HtmlForm form = indexPage.getForms().get(0);
            final HtmlTextInput textField = form.getInputByName("username");
            final HtmlSubmitInput button = form.getInputByValue("Submit");

            // 3. Populate form and click submit
            textField.type("Devon");
            final HtmlPage resultPage = button.click();

            // 4. Assert Tomcat successfully compiled the JSP and handled the servlet routing
            String pageText = resultPage.asNormalizedText();
            assertTrue(pageText.contains("Devon logged in."));
        }
    }
}

package webim;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Listener
 */
//@WebServlet("/listener")
public class Listener extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listener() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String vkPesp = "";
        
        vkPesp += ("");
        
        vkPesp += ("\n<p>URL request: " + request.getRequestURL() + "?" + request.getQueryString() + "</p>");
        
        vkPesp += ("<li>METHOD: "+ request.getMethod() + "</li>");
        vkPesp += ("<li>Protocol: "+ request.getProtocol() + "</li>");
        vkPesp += ("<li>Port: "+ request.getLocalPort() + "</li>");
        vkPesp += ("<li>URL: "+ request.getRequestURL() + "</li>");
        vkPesp += ("<li>URI: "+ request.getRequestURI() + "</li>");
        vkPesp += (getHeaders(request));
        
        vkPesp += ("\n\n<p>Request parameters: " + request.getQueryString() + "</p>");
        
        vkPesp += (getParameters(request));
        
        HttpSession session = request.getSession();
        session.setAttribute("resp", vkPesp);

        response.sendRedirect("/webim/webim");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected String getParameters(HttpServletRequest request)
            throws ServletException, IOException {
        String result = "";

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            result += ("<p>" + parameterName + ": "
                    + request.getParameter(parameterName) + "</p>\n");
        }

        return result;
    }
    
    protected String getHeaders(HttpServletRequest request) throws ServletException, IOException {
        String result = "";
        
        Enumeration<String> headerNames = request.getHeaderNames();
        
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            result += ("<li>" + headerName + ": " + request.getHeader(headerName) + "</li>\n");
        }
        
        return result;
    }    
    
}

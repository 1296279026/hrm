package com.cm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Main
 */
@WebServlet(urlPatterns = {"/main.action","/left.action","/right.action","/top.action"})
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收请求
		String servletPath = request.getServletPath();
		
		String prefix = "/WEB-INF/jsp/";
		String suffix = ".jsp";
		//判断
		if(servletPath.equals("/main.action")) {
			//主页 main.jsp  /WEB-INF/jsp/main.jsp
			request.getRequestDispatcher(prefix + "main" +suffix).forward(request, response);
		}else if(servletPath.equals("/top.action")) {
			//主页 main.jsp  /WEB-INF/jsp/top.jsp
			request.getRequestDispatcher(prefix + "top" +suffix).forward(request, response);
		}else if(servletPath.equals("/left.action")) {
			//主页 main.jsp  /WEB-INF/jsp/left.jsp
			request.getRequestDispatcher(prefix + "left" +suffix).forward(request, response);
		}else if(servletPath.equals("/right.action")) {
			//主页 main.jsp  /WEB-INF/jsp/main.jsp
			request.getRequestDispatcher(prefix + "right" +suffix).forward(request, response);
		}
		
		
	}

}

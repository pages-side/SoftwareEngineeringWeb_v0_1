package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.CompanyBean;
import com.beans.CustomerBean;
import com.beans.GameBean;
import com.commands.CompanyCommand;
import com.commands.CustomerCommand;
import com.commands.GameCommand;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}


	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requester = request.getParameter("requester");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if("company".equalsIgnoreCase(requester)){
			CompanyCommand cmd = new CompanyCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				CompanyBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
			rd.forward(request, response);
		}else if("customer".equalsIgnoreCase(requester)){
			CustomerCommand cmd = new CustomerCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				CustomerBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
			rd.forward(request, response);

		}else if("game".equalsIgnoreCase(requester)){
			GameCommand cmd = new GameCommand();
			if(!cmd.execute()){
				rd = request.getRequestDispatcher("/error.jsp");
			}else{
				GameBean bean = cmd.getBean();
				//request.setAttribute("result", bean);
				session.setAttribute("result", bean);
				rd = request.getRequestDispatcher(cmd.getForwardingPage());
			}
			rd.forward(request, response);
		}
	}

}

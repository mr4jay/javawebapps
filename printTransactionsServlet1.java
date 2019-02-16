package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cap.model.Account;
import org.cap.model.Transaction;
import org.cap.service.ICustomerService;

/**
 * Servlet implementation class printTransactionsServlet
 */
@WebServlet("/printTransactionsServlet")
public class printTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICustomerService service;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		Integer custId=(Integer)session.getAttribute("customerid");
		Long accountId=(Long)(session.getAttribute("account"));
		List<Transaction> transactions=service.getAccountTranscations(accountId);
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<pre><b>                        print transcations</b></pre>\r\n" + 
				"<form method=\"post\" action=\"1.html\">\r\n" + 
				"<pre>from date:  <input type=\"date\" name=\"from date\" size=\"20\">  to date:  <input type=\"date\" name=\"to date\" size=\"20\"><br>  \r\n" + 
				"                               <input type=\"submit\" name=\"print\" value=\"print\">\r\n" + 
				"</pre>\r\n" + 
				"<div style=\"padding-left: 75px;\">\r\n" + 
				"<table border=\"1\" style=\"padding: 10px;\">\r\n" + 
				"<tr>\r\n" + 
				"<th>from account</th>\r\n" + 
				"<th>to account</th>\r\n" + 
				"<th>debit/credit</th>\r\n" + 
				"<th>amount</th>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td></td><td></td><td></td><td></td>\r\n" + 
				"</tr>\r\n" + 
				"<tr>\r\n" + 
				"<td></td><td></td><td></td><td></td>\r\n" + 
				"</tr>\r\n" + 
				"</table>\r\n" + 
				"</div>\r\n" + 
				"</form>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		
		
		
	}

}

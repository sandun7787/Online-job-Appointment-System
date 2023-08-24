package com.codewithluck.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithluck.model.JobSeeker;
import com.codewithluck.service.RegisterService;



public class JobSeekerRegistrationAndLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisterService getRegisterService() {
		return RegisterService.getRegisterServiceObj();
		
	}
    String message="";   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String actionType=request.getParameter("actionType");
		if(actionType.equals("login")) {
			  fetchJobSeeker(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionType=request.getParameter("actionType");
		
		if(actionType.equals("add")) {
			registerJobSeeker(request,response);
		}
	}
	
	private void registerJobSeeker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobSeeker js=new JobSeeker();
		String firstName=request.getParameter("firstname");
	    String lastName=request.getParameter("lastname");
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    String confirmPassword=request.getParameter("confirmpassword");
	    if(password.equals(confirmPassword)) {
		js.setFirstName(firstName);
		js.setLastName(lastName);
		js.setEmail(email);
		js.setPassword(password);
		js.setConfirmPassword(confirmPassword);
	    
	    try {
			if(getRegisterService().addJobSeeker(js)) {
				message="JOb Seeker has been registered successfully";
			}else {
				message="Job Seeker hasn't been registered successfully";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			   message=e.getMessage();
		}
	    request.setAttribute("feedbackmessage",message);
	    RequestDispatcher rd=request.getRequestDispatcher("JobSeekerLogin.jsp");
	    rd.forward(request, response);
		
		
		
	}else {
		message="your password and confirm password is not matching";
		request.setAttribute("feedbackmessage",message);
		RequestDispatcher rd=request.getRequestDispatcher("JobSeekerRegistration.jsp");
		rd.forward(request, response);

	}
	
 
}
	private void fetchJobSeeker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			JobSeeker jobSeeker=getRegisterService().fetchSingleJobSeeker(email);
			if(email.equals(jobSeeker.getEmail())&&(password.equals(jobSeeker.getPassword()))){
				message="Login is successfully confirmed";
				request.setAttribute("feedbackmessage",message);
				RequestDispatcher rd=request.getRequestDispatcher("JobAppoinment.jsp");
				rd.forward(request, response);
				
			}else {
				message="Login is not successfully confirmed";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			   message=e.getMessage();
		}
		
		
	}
}

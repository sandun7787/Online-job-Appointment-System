package com.codewithluck.service;


import java.sql.SQLException;


import com.codewithluck.dao.JobSeekerRegistration;
import com.codewithluck.dao.JobSeekerRegistrationImp;
import com.codewithluck.model.JobSeeker;

public class RegisterService {
	
private static RegisterService registerServiceObj;
	
	
	private JobSeekerRegistration getJobSeekerRegistrationDao() {
		return new JobSeekerRegistrationImp();
		
	}

	private RegisterService() {
		
		// TODO Auto-generated constructor stub
	}
	public static synchronized RegisterService getRegisterServiceObj() {
		if(registerServiceObj==null) {
			 registerServiceObj=new RegisterService();
		}
		return registerServiceObj;
	}
	
	public boolean addJobSeeker(JobSeeker jobSeeker) throws SQLException, ClassNotFoundException {
		return getJobSeekerRegistrationDao().registerJobSeeker(jobSeeker);
		
	}
	public JobSeeker fetchSingleJobSeeker(String email) throws ClassNotFoundException, SQLException {
		return getJobSeekerRegistrationDao().fetchSingleJobSeeker(email);
	}
	
	
	
	
	
	

}

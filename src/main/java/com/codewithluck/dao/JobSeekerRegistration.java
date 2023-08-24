package com.codewithluck.dao;

import java.sql.SQLException;

import com.codewithluck.model.JobSeeker;

public interface JobSeekerRegistration {
	
	public boolean registerJobSeeker(JobSeeker jobSeeker) throws SQLException, ClassNotFoundException;
	public JobSeeker fetchSingleJobSeeker(String email) throws ClassNotFoundException, SQLException;
	
}
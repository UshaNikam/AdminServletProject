package org.techhub.service;

import org.techhub.model.Register;
import org.techhub.repository.RegisterRepoImpl;

public class RegisterServiceImpl implements RegService
{
	RegisterRepoImpl  regRepo=new RegisterRepoImpl();
	@Override
	public boolean isRegister(Register model) {
		// TODO Auto-generated method stub
		String email=model.getEmail();
		
		if(email.indexOf("@gmail.com")!=-1)
		{ //call repository layer here 
			return regRepo.isRegister(model);
		}
		else {
		  return false;	
		}
		
		
	}

}

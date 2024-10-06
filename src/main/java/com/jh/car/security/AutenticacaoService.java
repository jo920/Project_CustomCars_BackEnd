package com.jh.car.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService  implements UserDetailsService  {


    @Autowired
    private UsuarioRepository repo;	
    
	
	  @Override 
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // TODO Auto-generated method stub return
	  
		 return  repo.findByLogin(username); 
	  
	  }
	 

}

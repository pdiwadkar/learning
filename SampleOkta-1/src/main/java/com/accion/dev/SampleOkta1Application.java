package com.accion.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.UserList;

@SpringBootApplication
@RestController
public class SampleOkta1Application {

	@Autowired
	public Client client;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleOkta1Application.class, args);
	}
	
	 @GetMapping("/")
	    public String home(@AuthenticationPrincipal OidcUser user) {
	        return "Welcome, "+ user.getFullName() +"!";
	    }
	 
	 @GetMapping("/users")
	 public UserList getUsers() {
		 
		 return client.listUsers();
		 
	 }

}

package br.com.tab.depositodeseries.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tab.depositodeseries.operations.UserSignInRequest;
import br.com.tab.depositodeseries.operations.UserSignInResponse;
import br.com.tab.depositodeseries.operations.UserSignUpRequest;
import br.com.tab.depositodeseries.operations.UserSignUpResponse;
import br.com.tab.depositodeseries.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserResource
{
	@Autowired
	private UserService service;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<UserSignInResponse> signIn(@Valid @RequestBody UserSignInRequest userSignInRequest)
	{
		UserSignInResponse userSignInResponse = service.executeUserSignIn(userSignInRequest);
		
		return ResponseEntity.ok(userSignInResponse);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<UserSignUpResponse> signUp(@Valid @RequestBody UserSignUpRequest userSignUpRequest)
	{
		UserSignUpResponse userSignUpResponse = service.executeUserSignUp(userSignUpRequest);
		
		return ResponseEntity.ok(userSignUpResponse);
	}

}

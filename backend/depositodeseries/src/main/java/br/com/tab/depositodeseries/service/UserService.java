package br.com.tab.depositodeseries.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tab.depositodeseries.domain.LoginAuthentication;
import br.com.tab.depositodeseries.domain.User;
import br.com.tab.depositodeseries.operations.UserSignInRequest;
import br.com.tab.depositodeseries.operations.UserSignInResponse;
import br.com.tab.depositodeseries.operations.UserSignUpRequest;
import br.com.tab.depositodeseries.operations.UserSignUpResponse;
import br.com.tab.depositodeseries.operations.enums.ReturnCode;
import br.com.tab.depositodeseries.repository.LoginAuthenticationRepository;
import br.com.tab.depositodeseries.repository.UserRepository;

@Service
public class UserService
{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginAuthenticationRepository loginAuthenticationRepository;

	@Transactional
	public UserSignUpResponse executeUserSignUp(UserSignUpRequest userSignUpRequest)
	{
		UserSignUpResponse userSignUpResponse = null;

		try
		{
			try
			{
				String login = userSignUpRequest.getLogin();
				String password = userSignUpRequest.getPassword();
				LoginAuthentication loginAuthentication = new LoginAuthentication(login, password);

				String userName = userSignUpRequest.getUserName();
				String userEmail = userSignUpRequest.getUserEmail();
				User user = new User(null, userName, userEmail, loginAuthentication);

				loginAuthenticationRepository.save(loginAuthentication);
				User userSaved = userRepository.save(user);

				userSignUpResponse = new UserSignUpResponse(ReturnCode.OK, userSaved.getId());
			} catch (Exception e)
			{
				String errorMessage = "There was a problem trying to save the user into database. Contact technical support. "
						+ "Error: " + e.getMessage();
				throw new ServiceException(errorMessage, e);
			}
		} catch (ServiceException e)
		{
			userSignUpResponse = new UserSignUpResponse(ReturnCode.GENERAL_ERROR, e.getMessage());
		}

		return userSignUpResponse;
	}

	public List<User> findAll()
	{
		return userRepository.findAll();
	}

	public UserSignInResponse executeUserSignIn(UserSignInRequest userSignInRequest)
	{
		UserSignInResponse userSignInResponse = null;

		String login = userSignInRequest.getLogin();
		String password = userSignInRequest.getPassword();
		LoginAuthentication authenticated = loginAuthenticationRepository.findByLoginAndPassword(login, password);

		if (authenticated != null)
		{
			userSignInResponse = new UserSignInResponse(ReturnCode.OK, true);
		} else
		{
			userSignInResponse = new UserSignInResponse(ReturnCode.GENERAL_ERROR, false);
		}

		return userSignInResponse;
	}
}

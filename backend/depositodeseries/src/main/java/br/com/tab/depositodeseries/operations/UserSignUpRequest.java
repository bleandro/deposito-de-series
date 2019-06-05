package br.com.tab.depositodeseries.operations;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserSignUpRequest extends BaseRequest
{
	private static final long serialVersionUID = -7392415793025320894L;

	@NotBlank
	private String userName;
	@NotBlank
	@Email
	private String userEmail;
	@NotBlank
	private String login;
	@NotBlank
	private String password;

	public UserSignUpRequest()
	{
		this.userName = null;
		this.userEmail = null;
		this.login = null;
		this.password = null;
	}

	public UserSignUpRequest(String userName, String userEmail, String login, String password)
	{
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.login = login;
		this.password = password;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserEmail()
	{
		return userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}

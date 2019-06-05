package br.com.tab.depositodeseries.operations;

public class UserSignInRequest extends BaseRequest
{
	private static final long serialVersionUID = -2283723096647646908L;

	private String login;
	private String password;

	public UserSignInRequest()
	{}

	public UserSignInRequest(String login, String password)
	{
		super();
		this.login = login;
		this.password = password;
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

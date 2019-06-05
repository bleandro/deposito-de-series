package br.com.tab.depositodeseries.operations;

import br.com.tab.depositodeseries.operations.enums.ReturnCode;

public class UserSignInResponse extends BaseResponse
{
	private static final long serialVersionUID = -6026715526047041368L;
	private boolean userAuthenticatedSuccesfully;

	public UserSignInResponse(ReturnCode returnCode, boolean userAuthenticatedSuccesfully)
	{
		super(returnCode, null);
		this.userAuthenticatedSuccesfully = userAuthenticatedSuccesfully;
	}

	public UserSignInResponse(ReturnCode returnCode, boolean userAuthenticatedSuccesfully, String errorMessage)
	{
		super(returnCode, errorMessage);
		this.userAuthenticatedSuccesfully = userAuthenticatedSuccesfully;
	}

	public boolean isUserAuthenticatedSuccesfully()
	{
		return userAuthenticatedSuccesfully;
	}

	public void setUserAuthenticatedSuccesfully(boolean userAuthenticatedSuccesfully)
	{
		this.userAuthenticatedSuccesfully = userAuthenticatedSuccesfully;
	}

}

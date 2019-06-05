package br.com.tab.depositodeseries.operations;

import br.com.tab.depositodeseries.operations.enums.ReturnCode;

public class UserSignUpResponse extends BaseResponse
{
	private static final long serialVersionUID = -6026715526047041368L;
	private final Integer generatedUserId;

	public UserSignUpResponse(ReturnCode returnCode, Integer generatedUserId)
	{
		super(returnCode, null);
		this.generatedUserId = generatedUserId;
	}

	public UserSignUpResponse(ReturnCode returnCode, String errorMessage)
	{
		super(returnCode, errorMessage);
		this.generatedUserId = null;
	}

	public Integer getGeneratedUserId()
	{
		return generatedUserId;
	}
}

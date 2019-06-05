package br.com.tab.depositodeseries.operations;

import java.io.Serializable;

import br.com.tab.depositodeseries.operations.enums.ReturnCode;

public abstract class BaseResponse implements Serializable
{
	private static final long serialVersionUID = 8169366835994495876L;

	private final ReturnCode returnCode;
	private final String errorMessage;

	public BaseResponse(ReturnCode returnCode, String errorMessage)
	{
		this.returnCode = returnCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public ReturnCode getReturnCode()
	{
		return returnCode;
	}
}

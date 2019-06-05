package br.com.tab.depositodeseries.operations.enums;

public enum ReturnCode
{
	OK(1),
	GENERAL_ERROR(2);
	
	private int value;
	
	private ReturnCode(int value)
	{
		this.setValue(value);
	}

	public static ReturnCode toEnum(Integer value)
	{
		if (value == null)
			return null;
		
		for (ReturnCode returnCode : ReturnCode.values()) {
			if (value.equals(returnCode.getValue()))
				return returnCode;
		}
		
		throw new IllegalArgumentException("There's no ReturnCode with given value. Value: " + value);
	}
	
	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}
}

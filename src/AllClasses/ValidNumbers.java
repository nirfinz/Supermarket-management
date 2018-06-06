package AllClasses;

public class ValidNumbers {

	public static boolean IsPositive(int num,String msg) throws Exception{
		if (num < 0)
			throw new Exception(msg);
		
		return true;
	}
	
	public static boolean IsPositiveNoZero(int num,String msg) throws Exception{
		if (num <= 0)
			throw new Exception(msg);
		return true;
	}
	
	public static boolean HasMin(int num,int min, String msg) throws Exception{
		if (num < min)
			throw new Exception(msg);
		
		return true;
	}
	
	public static boolean checkString(String str, String msg) throws Exception{
		if (str == null || str.isEmpty())
			throw new Exception(msg);
		
		return true;
	}

}
import java.io.*;
import java.security.*;

public class Protection
{
	public static byte[] makeBytes(long t, double q) 
	{    
		try 
		{
			ByteArrayOutputStream out;
			DataOutputStream dataout;
			out = new ByteArrayOutputStream();
			dataout= new DataOutputStream(out);
			dataout.writeLong(t);
			dataout.writeDouble(q);
			return out.toByteArray();
		}
		catch (IOException e) 
		{
			return new byte[0];
		}
	}	
//second hashing 
	public static byte[] makeDigest(byte[] mush, long t2, double q2) throws NoSuchAlgorithmException 
	{
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(mush);
		md.update(makeBytes(t2, q2));
		return md.digest();
	}
	
 //first hashing 
	public static byte[] makeDigest(String user, String password,
									long t1, double q1)
									throws NoSuchAlgorithmException
	{
		
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(user.getBytes());      
		md.update(password.getBytes());  
		md.update(makeBytes(t1, q1));    
		return md.digest();	
	}
}
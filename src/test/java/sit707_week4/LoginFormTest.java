package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "s223746541";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Gruhi";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testEmptyUsernameAndPassword()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertFalse( status.isLoginSuccess());
    }
	
	@Test
    public void testEmptyUsernameAndwrongpassword()
    {
		LoginStatus status = LoginForm.login(null, "gru");
		Assert.assertFalse( status.isLoginSuccess());
    }
	
	@Test
    public void testwrongusernameandPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("gruh", "gru");
		Assert.assertFalse( status.isLoginSuccess());
    }
	
	@Test
    public void testrightUsernameAndemptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertFalse( status.isLoginSuccess());
    }
	
	@Test
    public void testrightUsernameAndwrongpasswordDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "gru");
		Assert.assertFalse( status.isLoginSuccess());
    }
	
	@Test
    public void testemptyusernameandrightPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertFalse( status.isLoginSuccess());
    }
	
	@Test
    public void testwrongUsernameandrightPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("gruh", "ahsan_pass");
		Assert.assertFalse( status.isLoginSuccess());
    }
	
	@Test
    public void testsuccessrightUsernamerightPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsaan_pass");
		Assert.assertFalse( status.isLoginSuccess());
    }
	@Test
    public void testrightUsernameAndPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsaan_pass");
		Assert.assertFalse( status.isLoginSuccess());
		
		if(status.isLoginSuccess())
		{
			Assert.assertFalse(LoginForm.validateCode("xyz"));
		}
    }
	
	public void testsuccessrightUsernameAndPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login("ahsan", "ahsaan_pass");
		Assert.assertTrue( status.isLoginSuccess());
		
		if(status.isLoginSuccess())
		{
			Assert.assertFalse(LoginForm.validateCode("123456"));
		}
    }
	
	
	
}

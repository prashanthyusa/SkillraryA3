package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
//This test fails
public class AddUserTest extends BaseClass {
	@Test
	public void addUserTest() {
		SoftAssert soft = new SoftAssert();
		home.clickUserTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewButton();
		soft.assertEquals(addUser.getPageHeader(), "Add User");

		Map<String, String> map = excel.readFromExcel("Sheet1", "Add User");
		addUser.setPwd(map.get("Password"));
		addUser.setFirstName(map.get("Firstname"));
		addUser.setLastName(map.get("Address"));
		addUser.setContact(map.get("Contact Info"));
		addUser.uploadPhoto(map.get("Photo"));
		addUser.clickSave();

		soft.assertTrue(users.getSuccessAlertMesssage().contains("Success"));
		soft.assertAll();
	}
}

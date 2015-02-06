package com.sl.applogic;

import ru.yandex.qatools.allure.annotations.Step;

import com.sl.model.User;


/**
 * Класс для выполнения общих комманд User.
 */
public class UserHelper extends DriverBasedHelper {

	public UserHelper(ApplicationManager applicationManager) {
		super(applicationManager.getWebDriver());
		
	}
	
	
	@Step("Login")
	public void loginAs(User user){
		pageManager.loginPage
		.setLogin(user.getLogin())
		.setPassword(user.getPassword())
		.clickButtonAutorization();	
		
	}
	
	public boolean isLoggin(){	
		return pageManager.loginPage.getButtonAutorization().isEnabled();
	}
	

}

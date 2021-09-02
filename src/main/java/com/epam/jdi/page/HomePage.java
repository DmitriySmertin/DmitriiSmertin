package com.epam.jdi.page;


import com.epam.jdi.enteties.User;
import com.epam.jdi.form.LoginForm;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @FindBy(id = "user-icon")
    public static Icon userIcon;
    @FindBy(css = "form")
    public static LoginForm loginForm;
    @FindBy(id = "user-name")
    public static Label userName;
    @UI(".btn-login")
    public static Button logoutButton;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }
    public static void logout() {
        userIcon.click();
        logoutButton.click();
    }

    public String getUserName() {
        return userName.getText();
    }


}

package com.epam.jdi.form;


import com.epam.jdi.enteties.User;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class LoginForm extends Form<User> {
    @FindBy(id = "name")
    TextField name;
    @FindBy(id = "password")
    TextField password;
    @FindBy(id = "login-button")
    Button submit;

}

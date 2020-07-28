package com.epam.mentorship.core.po;

import com.epam.mentorship.core.enums.Gender;
import com.epam.mentorship.core.enums.State;
import com.epam.mentorship.core.webelement.Checkbox;
import com.epam.mentorship.core.webelement.DropDown;
import com.epam.mentorship.core.webelement.Element;
import com.epam.mentorship.core.webelement.Input;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

import static com.epam.mentorship.core.enums.Gender.FEMALE;
import static com.epam.mentorship.core.enums.Gender.MALE;


@Getter
public class CreateAccountFormPO {

    @FindBy(id = "create-account_form")
    Element form;

    @FindBy(id = "email_create")
    Input emailCreateField;

    @FindBy(name = "SubmitCreate")
    Element createButton;

    @FindBy(id = "uniform-id_gender1")
    Element genderMrRadioButton;

    @FindBy(id = "uniform-id_gender2")
    Element genderMrsRadioButton;

    @FindBy(id = "customer_firstname")
    Input firstNameField;

    @FindBy(id = "customer_lastname")
    Input lastNameField;

    @FindBy(id = "passwd")
    Input passwordField;

    @FindBy(id = "days")
    DropDown dayOfBirth;

    @FindBy(id = "months")
    DropDown monthOfBirth;

    @FindBy(id = "years")
    DropDown yearOfBirth;

    @FindBy(id = "newsletter")
    Checkbox newsletterCheckbox;

    @FindBy(id = "optin")
    Checkbox optinCheckbox;

    @FindBy(id = "firstname")
    Input addressFirstNameField;

    @FindBy(id = "lastname")
    Input addressLastNameField;

    @FindBy(id = "company")
    Input companyField;

    @FindBy(id = "address1")
    Input addressField;

    @FindBy(id = "address2")
    Input secondAdressField;

    @FindBy(id = "city")
    Input cityField;

    @FindBy(id = "id_state")
    DropDown state;

    @FindBy(id = "postcode")
    Input zipCodeField;

    @FindBy(id = "id_country")
    DropDown country;

    @FindBy(id = "other")
    Input additionalInformationTextArea;

    @FindBy(id = "phone")
    Input homePhoneField;

    @FindBy(id = "phone_mobile")
    Input mobilePhoneField;

    @FindBy(id = "alias")
    Input assignAddressField;

    @FindBy(id = "submitAccount")
    Element registerButton;

    public CreateAccountFormPO fillEmailCreateField(String email) {
        emailCreateField.sendKeys(email);
        return this;
    }

    public CreateAccountFormPO submitCreation() {
        createButton.click();
        return this;
    }

    public CreateAccountFormPO selectGender(Gender gender) {
        if (gender.equals(MALE)) {
            genderMrRadioButton.click();
        } else if (gender.equals(FEMALE)) {
            genderMrsRadioButton.click();
        }
        return this;
    }

    public CreateAccountFormPO fillFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CreateAccountFormPO fillLastNameField(String lastName) {
        firstNameField.sendKeys(lastName);
        return this;
    }

    public CreateAccountFormPO fillPasswordField(String password) {
        firstNameField.sendKeys(password);
        return this;
    }

    public CreateAccountFormPO setDateOfBirth(LocalDate dateOfBirth) {
        dayOfBirth.selectByVisibleText(dateOfBirth.getDayOfMonth()+"");
        monthOfBirth.selectByValue(dateOfBirth.getMonth().getValue()+"");
        yearOfBirth.selectByValue(dateOfBirth.getYear()+"");
        return this;
    }

   public CreateAccountFormPO selectNewsletterCheckbox(){
        newsletterCheckbox.checkAll();
       return this;
    }

    public CreateAccountFormPO deselectNewsletterCheckbox(){
        newsletterCheckbox.unChecktAll();
        return this;
    }

  public CreateAccountFormPO deselectOptinCheckbox(){
        optinCheckbox.unCheckByIndexes();
      return this;
    }


    public CreateAccountFormPO fillAddressFirstNameField(String addressFirstName){
        addressFirstNameField.sendKeys(addressFirstName);
        return this;
    }


    public CreateAccountFormPO fillAddressLastNameField(String addressLastName){
        addressLastNameField.sendKeys(addressLastName);
        return this;
    }


    public CreateAccountFormPO fillCompanyField(String company){
        companyField.sendKeys(company);
        return this;
    }


    public CreateAccountFormPO fillAddressField(String adress){
        addressField.sendKeys(adress);
        return this;
    }

    public CreateAccountFormPO fillSecondAddressField(String secondAdress){
        secondAdressField.sendKeys(secondAdress);
        return this;
    }

    public CreateAccountFormPO fillCityField(String city){
        cityField.sendKeys(city);
        return this;
    }


    public CreateAccountFormPO selectState(State stateValue){
        state.selectByVisibleText(stateValue.getValue());
        return this;
    }

    public CreateAccountFormPO fillZipField(int zip){
        zipCodeField.sendKeys(zip+"");
        return this;
    }

    public CreateAccountFormPO selectCountry(String countyName){
        country.selectByVisibleText(countyName);
        return this;
    }

    public CreateAccountFormPO fillAdditionalInformationTextAreaField(String additionalInformation){
        additionalInformationTextArea.sendKeys(additionalInformation);
        return this;
    }

    public CreateAccountFormPO fillHomePhoneField(long homePhone){
        homePhoneField.sendKeys(homePhone+"");
        return this;
    }

    public CreateAccountFormPO fillMobilePhoneField(long phone){
        homePhoneField.sendKeys(phone+"");
        return this;
    }

    public CreateAccountFormPO fillAssignAddressField(int assignAddress){
        assignAddressField.sendKeys(assignAddress+"");
        return this;
    }

   public void clickRegister(){
       registerButton.click();
   }


}

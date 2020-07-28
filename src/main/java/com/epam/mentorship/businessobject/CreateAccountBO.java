package com.epam.mentorship.businessobject;

import com.epam.mentorship.core.models.User;
import com.epam.mentorship.core.po.CreateAccountFormPO;

public class CreateAccountBO {

    private CreateAccountFormPO createAccountFormPO;

   public void createWithRequiredFields(User user){
       createAccountFormPO = new CreateAccountFormPO()
               .fillEmailCreateField(user.getEmail())
               .fillFirstNameField(user.getFirstName())
               .fillLastNameField(user.getLastName())
               .fillPasswordField(user.getPassword())
               .fillAddressFirstNameField(user.getFirstName())
               .fillAddressLastNameField(user.getLastName())
               .fillCityField(user.getCity())
               .selectState(user.getState())
               .fillZipField(user.getZip())
               .selectCountry(user.getCountry())
               .fillMobilePhoneField(user.getMobilePhone());
    }
}

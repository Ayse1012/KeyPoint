package kyPointTest.stepDef;

import io.cucumber.java.en.*;
import kyPointTest.pages.QuestionCreatePage;
import kyPointTest.pages.SuperadminPage;
import kyPointTest.utilities.BrowserUtils;
import kyPointTest.utilities.Driver;

public class SuperadminStepDef {
    SuperadminPage superadminPage=new SuperadminPage();
     QuestionCreatePage questionCreatePage=new QuestionCreatePage();
    @When("the user navigates to {string} menu and {string} menu")
    public void the_user_navigates_to_menu_and_menu(String menu, String subMenu) {
      superadminPage.navigateMenu(menu,subMenu);

    }

    @When("the user clicks {string} button to create")
    public void the_user_clicks_button_to_create(String addModerator) {
        superadminPage.createAddButton(addModerator);

    }

    @When("User inputs the moderator information")
    public void user_inputs_the_moderator_information() {
        superadminPage.setCredential();
    }

    @When("User clicks {string} button")
    public void user_clicks_button(String save) {
       questionCreatePage.setSave_sendToApprove(save);

    }

    @Then("User verifies the created moderator")
    public void user_verifies_the_created_moderator() {
        superadminPage.verifyCreate();
    }


}

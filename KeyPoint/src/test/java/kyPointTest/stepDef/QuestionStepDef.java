package kyPointTest.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import kyPointTest.pages.DashboardPage;
import kyPointTest.pages.LoginPage;
import kyPointTest.pages.QuestionCreatePage;
import kyPointTest.utilities.BrowserUtils;
import kyPointTest.utilities.Driver;
import org.openqa.selenium.WebDriver;

public class QuestionStepDef extends DashboardPage {

         WebDriver driver= Driver.get();

        LoginPage loginPage=new LoginPage();
        QuestionCreatePage questionCreatePage=new QuestionCreatePage();

    @Given("user navigate landing page and logs in as {string} {string}")
    public void userNavigateLandingPageAndLogsInAs(String user, String password) {
        loginPage.setLoginButton(user,password);
    }
    @When("user goes to {string} page and clicks to add questions")
    public void user_goes_to_page_and_clicks_to_add_questions(String expectedMenu) {
        loginPage.getDashboardMenu(expectedMenu);
        questionCreatePage.allQuestions.click();
        questionCreatePage.addQuestion.click();


    }

    @And("user selects subject and selects {string}")
    public void userSelectsSubjectAndSelects(String topic) {
        questionCreatePage.getTopics(topic);
    }

    @And("user enters question {string}")
    public void userEntersQuestion(String questionText) {
        questionCreatePage.closePopap.click();
        Driver.get().switchTo().frame(questionCreatePage.ıframeText);
        questionCreatePage.questionText.sendKeys(questionText);
        Driver.get().switchTo().defaultContent();

    }

    @And("user enters choice {string} {string} {string} {string}")
    public void userEntersChoice(String A, String B, String C, String D) {
        BrowserUtils.waitFor(1);
        System.out.println("A = " + A);
       // questionCreatePage.getChoiceCreate(A,B,C,D);

    }

    @And("user enters answer {string}")
    public void userEntersAnswer(String answer) {
        questionCreatePage.setAnswerClick(answer);
    }
}

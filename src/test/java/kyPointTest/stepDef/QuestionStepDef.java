package kyPointTest.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kyPointTest.pages.DashboardPage;
import kyPointTest.pages.LoginPage;
import kyPointTest.pages.QuestionCreatePage;
import kyPointTest.utilities.BrowserUtils;
import kyPointTest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuestionStepDef extends DashboardPage {

         WebDriver driver= Driver.get();

        LoginPage loginPage=new LoginPage();
        QuestionCreatePage questionCreatePage=new QuestionCreatePage();

    @Given("user logs in as {string} {string}")
    public void userLogsInAs(String user, String password) {
        loginPage.setLoginButton(user,password);
        BrowserUtils.waitFor(6);
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

        questionCreatePage.setAddQuestionText(questionText);

    }

    @And("user enters choice {string} {string} {string} {string}")
    public void userEntersChoice(String A, String B, String C, String D) {
        BrowserUtils.waitFor(1);
        questionCreatePage.getChoiceCreate(A,B,C,D);

    }

    @And("user enters answer {string}")
    public void userEntersAnswer(String answer) {
        questionCreatePage.setAnswerClick(answer);
    }

    @And("user selects {string} {string}")
    public void userSelects(String questionType, String OneAnswer) {
        questionCreatePage.languageAndQuestionTypChoose(questionType,OneAnswer);
    }

    @And("user selects add question level {string} {string}")
    public void userSelectsAddQuestionLevel(String grateNum, String levelChar) {
        questionCreatePage.setAddQuestionLevel(grateNum,levelChar);
    }

    @Then("user  click to {string}")
    public void userClickTo(String save) {
        questionCreatePage.setSave_sendToApprove(save);
    }

    @When("user goes to {string} page and clicks to {string}")
    public void userGoesToPageAndClicksTo(String expectedMenu, String allQuestion) {
        loginPage.getDashboardMenu(expectedMenu);
        loginPage.getDashboardMenu(allQuestion);

    }

    @And("editor approved sends a question {string} and {string}")
    public void editorApprovedSendsAQuestionAnd(String create, String allquestion) {
       //  questionCreatePage.setRowSizeList(create,allquestion);
        questionCreatePage.addQuestionApproval(create,allquestion);
    }
}

package kyPointTest.pages;

import kyPointTest.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuestionCreatePage extends DashboardPage{



    @FindBy(css = ".MuiButton-label")
    public WebElement addQuestion;

    @FindBy(xpath = "//span[text()='MATHS ']")
    public WebElement subjectMaths;

    @FindBy(xpath = "//span[text()='ABSOLUTE VALUE ']")
    public WebElement topics;

    @FindBy(xpath = "//span[text()='Select']")
    public WebElement topicSelect;

    @FindBy(css = "#tinymce")
    public WebElement questionText;

    @FindBy(css = ".tox-edit-area__iframe")
    public WebElement ıframeText;

    public void getTopics(String topic){
        subjectMaths.click();
        WebElement element=driver.findElement(By.xpath("//span[text()='ABSOLUTE VALUE ']"));
        BrowserUtils.hover(topics);
        //topicSelect.click();
    }

    @FindBy(xpath = "//div[@class='tox-icon']")
    public WebElement closePopap;

    @FindBy(xpath = "//span[text()='Add Choice']")
    public WebElement addChoice;

    @FindBy(xpath = "(//span[@class='MuiButton-label'])[2]")
    public WebElement addChoice1;

    @FindBy(xpath = "(//div[@class='mce-content-body'])[1]")
    public WebElement choiceA;

    @FindBy(xpath = "//div[text()='A']")
    public WebElement choiceButton;

    public void getChoiceCreate(String A,String B,String C,String D){

        for (int i = 1; i < 5; i++) {
            addChoice1.click();
            choiceA.click();
            //BrowserUtils.clickWithJS(addChoice1);
            closePopap.click();
            if (i == 1) {
                WebElement element = driver.findElement(By.xpath("(//*[contains(@id,'tiny-react_')]/p)[" + i + "]"));
                element.sendKeys(A);
            } else if (i == 2) {

                WebElement element = driver.findElement(By.xpath("(//*[contains(@id,'tiny-react_')]/p)[" + i + "]"));
                element.sendKeys(B);
            } else if (i == 3) {

                WebElement element = driver.findElement(By.xpath("(//*[contains(@id,'tiny-react_')]/p)[" + i + "]"));
                element.sendKeys(C);
            } else {

                WebElement element = driver.findElement(By.xpath("(//*[contains(@id,'tiny-react_')]/p)[" + i + "]"));
                element.sendKeys(D);
            }

        }


    }

    public void setAnswerClick(String answer){

        WebElement element=driver.findElement(By.xpath("//div[text()='"+answer+"']"));

    }
}








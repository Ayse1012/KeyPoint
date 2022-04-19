package kyPointTest.pages;

import kyPointTest.utilities.BrowserUtils;
import kyPointTest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class QuestionCreatePage extends DashboardPage {

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
    @FindBy(xpath = "//span[text()='Add Question Level']")
    public WebElement addQuestionLevel;
    @FindBy(xpath = "//select[@id='questionLevels[0].examTypeId']")
    public WebElement selectExamType;
    @FindBy(xpath = "//ul[@role='listbox']/li[10]")
    public WebElement grateList;
    @FindBy(xpath = "(//div[@id='Select-outlined'])[1]")
    public WebElement grate;
    @FindBy(xpath = "//div[@id='questionLevels[2].questionLevel']")
    public WebElement levelList;
    @FindBy(xpath = "//li[text()='C']")
    public WebElement levelChar;
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
    @FindBy(css = "#outlined-questionType-native-simple")
    public WebElement questionType;
    @FindBy(css = "outlined-language-native-simple")
    public WebElement languageSelect;
    @FindBy(xpath = "//*[text()='Send To Approve']")
    public WebElement save_sendToApprove;
    @FindBy(xpath = "//table/tbody/tr[1]/td[5]")
    public WebElement status;
    @FindBy(xpath = "(//table/tbody/tr[1]/td[6]//button)[1]")
    public WebElement editQuestion;
    @FindBy(xpath = "//table/tbody/tr") //row sayısı
    public WebElement rowSizeList;
    @FindBy(xpath = "//tr/td/div/div[2]")
    public WebElement rowMaxChoice;
    @FindBy(xpath = "//li[@data-value='20']")
    public WebElement maxRowClick;
    @FindBy(xpath = "//table/tfoot/tr/td/div/div[3]/span[4]")
    public WebElement nextPage;

    public void getTopics(String topic) {
        subjectMaths.click();
        BrowserUtils.waitFor(1);
        WebElement element = driver.findElement(By.xpath("//span[text()='" + topic + "']"));
        BrowserUtils.hover(element);
        BrowserUtils.clickWithJS(topicSelect);
        //topicSelect.click();
    }

    public void getChoiceCreate(String A, String B, String C, String D) {
        String[] chs = {A, B, C, D};

        for (int i = 0; i < 4; i++) {

            addChoice.click();
            WebElement choiceInput = driver.findElement(By.xpath("(//div[@class='mce-content-body'])[" + (i + 1) + "]"));
            choiceInput.click();
            closePopap.click();
            WebElement element = driver.findElement(By.xpath("(//*[contains(@id,'tiny-react_')]/p)[" + (i + 1) + "]"));
            element.sendKeys(chs[i]);
        }

    }

    public void setAnswerClick(String answer) {

        WebElement element = driver.findElement(By.xpath("//div[text()='" + answer + "']"));
        element.click();
        BrowserUtils.waitFor(2);
    }

    public void setAddQuestionText(String expectedQuestion) {

        closePopap.click();
        Driver.get().switchTo().frame(ıframeText);
        questionText.sendKeys(expectedQuestion);
        Driver.get().switchTo().defaultContent();
    }

    public void languageAndQuestionTypChoose(String questionType, String OneAnswer) {
        WebElement element = driver.findElement(By.cssSelector("#outlined-" + questionType + "-native-simple"));
        Select select = new Select(element);
        select.selectByValue(OneAnswer);
    }

    public void setAddQuestionLevel(String grateNum, String levelChar) {
        for (int i = 0; i < 3; i++) {
            addQuestionLevel.click();
            BrowserUtils.waitFor(2);
            WebElement element = driver.findElement(By.xpath("//select[@id='questionLevels[" + i + "].examTypeId']"));
            Select select = new Select(element);
            select.selectByIndex(i + 1);
            WebElement element1 = driver.findElement(By.xpath("(//div[@id='Select-outlined'])[" + (i + 1) + "]"));
            element1.click();
            WebElement element2 = driver.findElement(By.xpath("//ul[@role='listbox']/li[" + grateNum + "]"));
            element2.click();
            WebElement element3 = driver.findElement(By.xpath("//div[@id='questionLevels[" + i + "].questionLevel']"));
            element3.click();
            WebElement element4 = driver.findElement(By.xpath("//li[@data-value='" + levelChar + "']"));
            element4.click();
        }
    }

    public void setSave_sendToApprove(String save) {
        WebElement element = driver.findElement(By.xpath("//*[text()='" + save + "']"));
        BrowserUtils.clickWithJS(element);

        //  String itemLocator = "//span[text()='" + save + "']";
        //  BrowserUtils.waitForVisibility(By.xpath(itemLocator), 2);
        // Driver.get().findElement(By.xpath(itemLocator)).click();
        // BrowserUtils.waitFor(2);

    }
    public void setRowSizeList(String create,String save){
        List<WebElement> rowSize = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));
        int size = rowSize.size();
        System.out.println("rowSize.size() = " + rowSize.size());
        int i=1;
        while (i<=size){
            WebElement element = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[5]"));
            System.out.println("element.getText() = " + element.getText());
            if (element.getText().equals(create) && element.isEnabled()) {
                System.out.println("element.getText()2 = " + element.getText());
                WebElement element1 = driver.findElement(By.xpath("(//table/tbody/tr[" + i +"]/td[6]//button)[1]"));
                element1.click();
                BrowserUtils.waitFor(1);
                setSave_sendToApprove(save);
                BrowserUtils.waitFor(2);
                allQuestions.click();
            }
            
        }
        BrowserUtils.waitFor(1);
       rowSize.clear();

    }

    public void addQuestionApproval(String created, String save) {
        setRowSizeList(created,save);
        nextPage.click();
      while (nextPage.isEnabled()){

            setRowSizeList(created,save);
          nextPage.click();

        }
    }


}

/**
@FindBy(xpath = "//tr/td/div/div[2]")  //input[@class='MuiSelect-
    //table/tfoot/tr/td/div/div[2]
    Fatih Tosun Kişisinden Herkese 07:15PM
@FindBy(xpath = "//li[@data-value='20']")
public WebElement choice_rowMax_loc;
@FindBy(xpath = "//span[text()='Send To Approve']")
public WebElement sendToApprove_loc;


public void clicks_Row_Max(){
        BrowserUtils.scrollToElement(rowButton_loc);
        BrowserUtils.waitFor(2);
        rowButton_loc.click();
        choice_rowMax_loc.click();
        BrowserUtils.scrollToElement(rowButton_loc);
        BrowserUtils.waitFor(5);

        }

public void clicks_Edit(String status){


        for(int i=1;i<=20;i++){
        WebElement question_Status=Driver.get().findElement(By.xpath("//tbody/tr["+i+"]/td[5]"));
        WebElement editQuestion=Driver.get().findElement(By.xpath("(//tr/td/div/button[1])["+i+"]"));
        clicks_Row_Max();


        if(question_Status.getText().contains(status)){
        System.out.println("question_Status.getText() = "+question_Status.getText());
        editQuestion.click();
        BrowserUtils.waitFor(2);
        sendToApprove_loc.click();
        BrowserUtils.waitFor(2);

        }

        }
        }

//table/tbody/tr[@level='0']


 */









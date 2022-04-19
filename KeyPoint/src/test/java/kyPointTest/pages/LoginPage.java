package kyPointTest.pages;

import kyPointTest.utilities.BrowserUtils;
import kyPointTest.utilities.ConfigurationReader;
import kyPointTest.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DashboardPage{

    WebDriver driver= Driver.get();

   public LoginPage(){PageFactory.initElements(driver,this);}

    @FindBy(css = "#email")
    public WebElement usernameInput;

    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//h4[text()='Dashboard']")
    public WebElement messageText;

    @FindBy(xpath = "//p[text()='Username or password not correct']")
    public WebElement errorMessage;

    public void navigateLandingPage(){
    driver.get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(1);
    }
    public void setLoginButton(String username,String password){
       usernameInput.sendKeys(username);
       passwordInput.sendKeys(password);
       BrowserUtils.waitFor(1);
       BrowserUtils.clickWithJS(loginButton);

    }
    public void verifyMessage(String expectedMessage){
        String actualUrl=messageText.getText();
        Assert.assertEquals(expectedMessage,actualUrl);

    }
    public void verifyErrorMessage(String expectedMessage){
       WebElement errorMessagElmnt=driver.findElement(By.xpath("//p[text()='"+expectedMessage+"']"));
        String actualErrorMessage=errorMessagElmnt.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertEquals(expectedMessage,actualErrorMessage);
    }



}

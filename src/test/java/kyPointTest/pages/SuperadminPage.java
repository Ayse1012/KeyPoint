package kyPointTest.pages;

import com.github.javafaker.Faker;
import kyPointTest.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class SuperadminPage extends DashboardPage{

    Faker faker=new Faker();
    String expectedEmail;
    @FindBy(css = ".MuiInputBase-input.MuiOutlinedInput-input")
    public List<WebElement> moderatorCredential;
    @FindBy(xpath = "(//tbody/tr/td[3])[1]")
    public WebElement tableEmail;
    @FindBy(xpath = "//button[@title='Refresh Data']")
    public WebElement refresh;

    public void setCredential(){
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        expectedEmail=firstName.toLowerCase()+"_"+lastName.toLowerCase()+"@example.com";
        String mobile=faker.number().digits(10);
        String password="Test123456!";

        moderatorCredential.get(0).sendKeys(expectedEmail);
        moderatorCredential.get(1).sendKeys(firstName);
        moderatorCredential.get(2).sendKeys(lastName);
        moderatorCredential.get(3).sendKeys(mobile);
        moderatorCredential.get(4).sendKeys(password);
        BrowserUtils.waitFor(1);

    }

    public void verifyCreate(){
      refresh.click();
      String actualEmail=tableEmail.getText();
        Assert.assertEquals(actualEmail,expectedEmail);

    }




}

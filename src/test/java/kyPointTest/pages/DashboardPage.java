package kyPointTest.pages;

import kyPointTest.utilities.BrowserUtils;
import kyPointTest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class DashboardPage {

        WebDriver driver= Driver.get();

    public DashboardPage(){
        PageFactory.initElements(driver,this);
        }


    @FindBy(xpath = "//span[text()='Dashboard']")
    public WebElement dashboardMenu;

    @FindBy(xpath ="//span[text()='All Questions']")
    public WebElement allQuestions;

    public void navigateMenu(String menu,String subMenu ){
        WebElement element=driver.findElement(By.xpath("//span[text()='"+menu+"']"));
        element.click();
        BrowserUtils.waitFor(1);
        WebElement element1=driver.findElement(By.xpath("//span[text()='"+subMenu+"']"));
        element1.click();

    }
    public void createAddButton(String addButton){
        WebElement element=driver.findElement(By.xpath("//span[text()='"+addButton+"']"));
        element.click();

    }
    public void getDashboardMenu(String menu){
        WebElement element=driver.findElement(By.xpath("//span[text()='"+menu+"']"));
        element.click();

    }



}

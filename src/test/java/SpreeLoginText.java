import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SpreeLoginText {

    private WebDriver driver = null;

    @Before
    public void setUP() throws Exception{
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/driver/geckodriver");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.navigate().to("http://spree.shiftedtech.com/");


    }

    @Test
    public void validEmailAndPassword(){

        driver.findElement(By.linkText("Login")).click();
        WebElement emailElement = driver.findElement(By.id("spree_user_email"));
        emailElement.sendKeys("nafibutex@gmail.com");
        String userid = emailElement.getAttribute("value");
        System.out.println("Email entered: " + userid);

        WebElement passwordElement = driver.findElement(By.id("spree_user_password"));
        passwordElement.sendKeys("dhakausa");

        driver.findElement(By.name("commit")).click();

        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();

        WebElement edit = driver.findElement(By.linkText("Edit"));
        String actualText = edit.getText();
        Assert.assertEquals("Edit",actualText);

    }
    @Test
    public void invalidEmailAndInvalidPassword(){
        driver.findElement(By.linkText("Login")).click();
        WebElement emailElement = driver.findElement(By.id("spree_user_email"));
        emailElement.sendKeys("nafibutex@gmail.com1");
        String userid = emailElement.getAttribute("value");
        System.out.println("Email entered: " + userid);

        WebElement passwordElement = driver.findElement(By.id("spree_user_password"));
        passwordElement.sendKeys("dhakausa1");

        driver.findElement(By.name("commit")).click();
    }

    @Test
    public void invalidEmailAndValidPassword(){
        driver.findElement(By.linkText("Login")).click();
        WebElement emailElement = driver.findElement(By.id("spree_user_email"));
        emailElement.sendKeys("nafibutex@gmail.com1");
        String userid = emailElement.getAttribute("value");
        System.out.println("Email entered: " + userid);

        WebElement passwordElement = driver.findElement(By.id("spree_user_password"));
        passwordElement.sendKeys("dhakausa");

        driver.findElement(By.name("commit")).click();
    }
    @Test
    public void validEmailAndInvalidPassword(){
        driver.findElement(By.linkText("Login")).click();
        WebElement emailElement = driver.findElement(By.id("spree_user_email"));
        emailElement.sendKeys("nafibutex@gmail.com");
        String userid = emailElement.getAttribute("value");
        System.out.println("Email entered: " + userid);

        WebElement passwordElement = driver.findElement(By.id("spree_user_password"));
        passwordElement.sendKeys("dhakausa1");

        driver.findElement(By.name("commit")).click();
    }


    @After
    public void tearDown() throws Exception{
       //driver.close();
       //driver.quit();
    }
}

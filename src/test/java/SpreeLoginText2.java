import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SpreeLoginText2 {

    private static WebDriver driver = null;

    @BeforeClass
    public static void beforeClass() {

        //System.setProperty("webdriver.gecko.driver", "/Users/ishratzaman/IdeaProjects/SpreeCommerceTest/driver/geckodriver");
        //System.out.println("Driver Path: " + System.getProperty("webdriver.gecko.driver"));

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        //FirefoxDriverManager.getInstance().arch32().setup();
        //driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @Before
    public void setUP() throws Exception {

        driver.navigate().to("http://spree.shiftedtech.com/");


    }

    @Test
    public void validEmailAndPassword() {

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
        Assert.assertEquals("Edit", actualText);

    }

    @Test
    public void invalidEmailAndInvalidPassword() {
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
    public void invalidEmailAndValidPassword() {
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
    public void validEmailAndInvalidPassword() {
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
    public void tearDown() {
        try {
            WebElement logout = driver.findElement(By.linkText("Logout"));
            logout.click();
        } catch (Exception ex) {

        }
    }

    @AfterClass
    public static void afterClass(){
        //driver.close();
    }

}

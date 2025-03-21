import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class seleniumWebSignupTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        // locate where the chromedriver is
        System.setProperty("webdriver.chromedriver", "C:\\Users\\HP\\Documents\\FacebookTest\\resources\\chromedriver-win64");
        //1. open chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo page URL https://selenium-blog.herokuapp.com/
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test1. Verify the user input the right url and is on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(Duration.ofMillis(5000));
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(Duration.ofMillis(5000));
    }

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test7. Verify that user is successfully signed up when valid details are inputted
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Pelumi144");
        //6. Input your email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("aishatoluwapelumi144@gmail.com");
        //7. Locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("aishat");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(Duration.ofMillis(5000));
    }

    @Test (priority = 1)
    public void clickUserItem() throws InterruptedException {
        //9. Click on User item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/div/div/li[1]")).click();
        //Test2. Verify that user clicks on the signup button, the user is directed to the signup page
        String expectedURL = "https://selenium-blog.herokuapp.com/signup";
        String actualUrL = driver.getCurrentUrl();
        if (actualUrL.contains(expectedURL))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        Thread.sleep(Duration.ofMillis(5000));
    }

    @Test (priority = 5)
    public void negativeSignupforEmail() throws InterruptedException {
        //Test4. Verify that user cannot signup with invalid email
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Pelumi865");
        //6. Input your email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("aishatoluwapelumi865gmail.com");
        //7. Locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("aishat");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(Duration.ofMillis(5000));
        //Clear Username field
        driver.findElement(By.id("user_username")).clear();
        //Clear User email
        driver.findElement(By.id("user_email")).clear();
        //Clear User password
        driver.findElement(By.id("user_password")).clear();
    }

    @Test (priority = 6)
    public void negativeSignupforPassword() throws InterruptedException {
        //Test5. Verify that user cannot signup with password less than 1 characters
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Pelumi772");
        //6. Input your email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("aishatoluwapelumi772@gmail.com");
        //7. Locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(Duration.ofMillis(5000));
        //Clear Username field
        driver.findElement(By.id("user_username")).clear();
        //Clear User email
        driver.findElement(By.id("user_email")).clear();
        //Clear User password
        driver.findElement(By.id("user_password")).clear();
    }

    @Test (priority = 7)
    public void negativeSignupBlankfield() throws InterruptedException {
        //Test6. Verify that user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //6. Input your email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7. Locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(Duration.ofMillis(5000));
        //Clear Username field
        driver.findElement(By.id("user_username")).clear();
        //Clear User email
        driver.findElement(By.id("user_email")).clear();
        //Clear User password
        driver.findElement(By.id("user_password")).clear();
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //Test9. Verify that the item searched for on the user page is present
        //10. Search for an item(using python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        String expectedPageURL = "https://selenium-blog.herokuapp.com/users/2";
        String actualPageURL = driver.getCurrentUrl();
        if (actualPageURL.contains(expectedPageURL))
            //Pass
            System.out.println("Correct Userpage");
        else
            //Fail
            System.out.println("Wrong Userpage");
        Thread.sleep(Duration.ofMillis(5000));
    }

    @Test (priority = 3)
    public void LogoutSuccessfully() {
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10. Verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
    }

    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        //Click on the Signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(Duration.ofMillis(5000));
        //Test3. Verify that user cannot signup with username less than 3 characters
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("Pi");
        //6. Input your email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("aishatoluwapelumi787@gmail.com");
        //7. Locate the password field and input your password on the username field
        driver.findElement(By.id("user_password")).sendKeys("aishat");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(Duration.ofMillis(5000));
        //Clear Username field
        driver.findElement(By.id("user_username")).clear();
        //Clear User email
        driver.findElement(By.id("user_email")).clear();
        //Clear User password
        driver.findElement(By.id("user_password")).clear();
    }

    @AfterTest
    public void closeBrowser() {
        //Quit
    driver.quit();
    }
}
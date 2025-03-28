import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;




public class KongaTest {
    private WebDriverManager driver;
@BeforeTest
    public void main() throws InterruptedException {
        //locate where chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //open chromedriver
        WebDriver driver = new ChromeDriver();
        //input the konga page URL
        driver.get("https://www.konga.com/");
        //maximize homepage
        driver.manage().window().maximize();
        //Thread.sleep(7000);
        //click on login button to open the login page
        driver.findElement(By.xpath("//a[text()='Login / Signup']")).click();
        Thread.sleep(5000);
        //input email address
        driver.findElement(By.id("username")).sendKeys("");
        //input password
        driver.findElement(By.id("password")).sendKeys("");
        //click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);

        //Homepage

        //on the homepage click on all categories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]")).click();
        Thread.sleep(10000);

        //click on computer and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);

        //click on laptop
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(10000);

        //click on Apple Macbooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(10000);

        //click on item name
        driver.findElement(By.xpath("//a[@href='/product/apple-macbook-pro-14-m2-max-32gb-ram-1tb-space-grey-6597644?cid=8158']")).click();
        Thread.sleep(10000);

        //click on add to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(10000);

        //click on popup
        driver.findElement(By.xpath("/html/div/div/div[1]/button")).click();
        Thread.sleep(10000);

        //click on continue to checkout
        WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(10000);

        //click on payment
        driver.findElement(By.xpath("//input[@type='radio' and @value='kpaygateway']")).click();
        Thread.sleep(10000);

        //click on continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(15000);

        //switch to iFrame
       // Switch to iFrame using XPath
       WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]"));
       driver.switchTo().frame(iframeElement);
       Thread.sleep(10000);

        //click on card number
        driver.findElement(By.id("card-number")).sendKeys("9043567723415590");
        Thread.sleep(10000);

        //error message
        // Locate the error message element
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"card-number_unhappy\"]"));

        // Print the error message text
        System.out.println("Error Message: " + errorMessage.getText());
        Thread.sleep(10000);

        //close the iFrame
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(10000);
    }
@AfterTest
    public void closeBrowser() {
        //quit browser
    driver.quit();
    }


}





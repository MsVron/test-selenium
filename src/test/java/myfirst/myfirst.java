package myfirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myfirst {

    WebDriver driver;

    @BeforeTest
    public void main() {
        // no System.setProperty needed, selenium manager handles it
        // System.setProperty("webdriver.chrome.driver", "src/chromedriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void Test() {
        var title = driver.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertTrue(title.contains("Udemy"), "title should contain 'Udemy'");
    }

    @AfterTest
    public void closeSession() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
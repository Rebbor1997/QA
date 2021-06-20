import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GuiTests {
    @Test
    public void openGoogleTest() throws InterruptedException {
        DriverManagerType driverManagerType = DriverManagerType.CHROME;
        WebDriverManager.getInstance(driverManagerType).setup();

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.by/");
        chromeDriver.findElement(By.name("q")).sendKeys("TechMeSkills" + Keys.ENTER);

        Thread.sleep(3000);
        Assert.assertTrue(chromeDriver.findElement(By.xpath("//a[@href='https://teachmeskills.by/']")).isDisplayed());
        chromeDriver.quit();

    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class SmokeTest {

    @Test
    public void smokeTest1(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");
        WebElement heightInput = driver.findElement(By.id("bmiVar1"));
        heightInput.sendKeys("183");

        WebElement weightInput  = driver.findElement(By.id("bmiVar2"));
        weightInput.sendKeys("58");

        WebElement calculateButton = driver.findElement(By.className("btn-calculate"));
        calculateButton.click();
/*
        List<WebElement> webElementList = driver.findElements(By.tagName("section"));
        Assert.assertEquals(webElementList.size(), 2);

        WebElement customCalculator = driver.findElement(By.linkText("Таможенные калькуляторы"));
        Assert.assertTrue(customCalculator != null);

        WebElement otherCalculator = driver.findElement(By.partialLinkText("Прочие"));
        Assert.assertTrue(otherCalculator != null);
*/
        String expectedImtResult = "17.32";
        WebElement actualImtResultElement = driver.findElement(By.id("AnswerBMI"));
        String actualImtResult = actualImtResultElement.getText();
        Assert.assertEquals(actualImtResult, expectedImtResult);

        String expectedImtMessage = "Недостаточной массе тела";
        WebElement actualImtMessageElement = driver.findElement(By.id("AnswerBMI1"));
        String actualImtMessage = actualImtMessageElement.getText();
        Assert.assertEquals(actualImtMessage, expectedImtMessage);


        driver.quit();
    }
}

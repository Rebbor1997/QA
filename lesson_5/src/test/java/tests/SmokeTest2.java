package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class SmokeTest2 {
    @Test
    public void smokeTest2() throws InterruptedException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        //1
        System.setProperty("webdriver.chrome.driver", absolutePath);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://calc.by/building-calculators/laminate.html");

        //
        WebElement layingMethodLaminateElement = driver.findElement(By.tagName("select"));
        Select layingMethodLaminate = new Select(layingMethodLaminateElement);

        layingMethodLaminate.selectByIndex(0);
        layingMethodLaminate.selectByValue("1");
        layingMethodLaminate.selectByVisibleText("с использованием отрезанного элемента");

        //2
        WebElement lengthInput = driver.findElement(By.id("ln_room_id"));
        lengthInput.clear();
        lengthInput.sendKeys("500");


        //3
        WebElement widthInput = driver.findElement(By.id("wd_room_id"));
        widthInput.clear();
        widthInput.sendKeys("400");

        //4
        WebElement panelLengthInput = driver.findElement(By.id("ln_lam_id"));
        panelLengthInput.clear();
        panelLengthInput.sendKeys("2000");

        //5
        WebElement panelWidthInput = driver.findElement(By.id("wd_lam_id"));
        panelWidthInput.clear();
        panelWidthInput.sendKeys("200");


        //6
        WebElement widthOfTheRoom= driver.findElement(By.id("direction-laminate-id1"));
        widthOfTheRoom.click();


        //7
        WebElement calculate= driver.findElement(By.partialLinkText("Рассчитать"));
        calculate.click();
        Thread.sleep(3000);

        //8
        String expectedImtResult = "53";
        WebElement actualImtResultElement = driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]/span"));
        String actualImtResult = actualImtResultElement.getText();
        Assert.assertEquals(actualImtResult, expectedImtResult);

        //9
        String expectedImtResult2 = "7";
        WebElement actualImtResultElement2= driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[2]/span"));
        String actualImtResult2 = actualImtResultElement2.getText();
        Assert.assertEquals(actualImtResult2, expectedImtResult2);


        driver.quit();
    }
}

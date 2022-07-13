package com.zap.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWithZapTest extends BaseTest {
    @Test
    public void loginAndLogoutShouldSucceed() {
        driver.get("http://192.168.56.10/login.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Damn"));

        driver.findElement(By.cssSelector("input.loginInput[type='text']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input.loginInput[type='password']")).sendKeys("password");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        driver.findElement(By.cssSelector("a[href*='logout']")).click();
    }
}

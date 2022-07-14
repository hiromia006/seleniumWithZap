package com.zap.test;

import com.zap.util.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumWithZapTest extends BaseTest {
    @Test
    public void injectSqlShouldSucceed() {
        WebElement webElement = driver.findElement(By.cssSelector("ul > li a[href*='sqli/']"));
        webElement.isDisplayed();
        webElement.click();

        driver.findElement(By.cssSelector("input[name='id']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[name='Submit']")).click();
        GeneralUtil.longWaitForDomStable();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.vulnerable_code_area pre")).isDisplayed());
    }

    @Test
    public void executeCommandShouldSucceed() {
        WebElement webElement = driver.findElement(By.cssSelector("ul > li a[href*='exec/']"));
        webElement.isDisplayed();
        webElement.click();

        driver.findElement(By.cssSelector("input[name='ip']")).sendKeys("127.0.0.1");
        driver.findElement(By.cssSelector("input[name='submit']")).click();
        GeneralUtil.longWaitForDomStable();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.vulnerable_code_area pre")).isDisplayed());
    }

    @Test
    public void attackBruteForceShouldSucceed() {
        WebElement webElement = driver.findElement(By.cssSelector("ul > li a[href*='brute/']"));
        webElement.isDisplayed();
        webElement.click();

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password");
        driver.findElement(By.cssSelector("input[name='Login']")).click();
        GeneralUtil.longWaitForDomStable();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.vulnerable_code_area img")).isDisplayed());
    }
}

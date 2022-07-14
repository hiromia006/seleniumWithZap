package com.zap.test;

import com.zap.util.GeneralUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.time.Duration;

public abstract class BaseTest {
    static final String ZAP_PROXY_ADDRESS = "localhost";
    static final int ZAP_PROXY_PORT = 8086;
    static final String ZAP_API_KEY = "6vi1kh8cl38et15pb9v7bbsb49";
    protected WebDriver driver;
    protected ClientApi api;

    @BeforeClass
    public void setUp() {
        String proxyServerUrl = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;

        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyServerUrl);
        proxy.setSslProxy(proxyServerUrl);

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.setProxy(proxy);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(firefoxOptions);

        api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);

        driver.get("http://192.168.56.10/login.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtil.WAIT_TIME));
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Damn"));

        WebElement usernameEl = driver.findElement(By.cssSelector("input.loginInput[type='text']"));
        usernameEl.isDisplayed();
        usernameEl.sendKeys("admin");
        driver.findElement(By.cssSelector("input.loginInput[type='password']")).sendKeys("password");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
    }


    @AfterClass
    public void tearDown() {
        driver.findElement(By.cssSelector("a[href*='logout']")).click();

        if (api != null) {
            String title = "Damn Vulnerable Web Application (DVWA)";
            String template = "traditional-html";
            String description = "Damn Vulnerable Web Application (DVWA)";
            String reportFileName = "dvwa.html";
            String targetFolder = System.getProperty("user.dir") + "/build/";
            System.out.println(targetFolder);

            try {
                ApiResponse response = api.reports.generate(title, template, null, description, null, null, null, null,
                        null, reportFileName, null, targetFolder, null);
                System.out.println("Zap Report : " + response.toString());
            } catch (ClientApiException e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}

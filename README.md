## Prerequisite Security Testing Selenium With OWASP ZAP.
 OWASP ZAP must open during run test case
- [Download & Install JDK](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Download & Install IntelliJ IDEA Community Version](https://www.jetbrains.com/idea/download/)
- [Download & Install OWASP ZAP](https://www.zaproxy.org/download/)
- Set environment variable(path) -  Set JAVA_HOME
- **Create TestNG XML** plugin install from Marketplace - File >> Settings >> plugin >> Marketplace >> search 'Create
  TestNG XML' & install

## Gradle Dependencies
- [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
- [OWASP ZAP API Client](https://mvnrepository.com/artifact/org.zaproxy/zap-clientapi)
- [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)
- [TestNG](https://mvnrepository.com/artifact/org.testng/testng)

## OWASP ZAP Integration
- Open OWASP ZAP
- Address & Port : Go to Main Menu >> Tools >> Options >> Local Proxies
- API Key : Go to Main Menu >> Tools >> Options >> API
- Add Address, Port & API Key in BaseTest class [./src/test/java/com/zap/test/BaseTest.java]

## Report Location
- ./build/dvwa.html

## Caution
- It is very important to note that you should only use ZAP on your own Applications or the ones you have permission to test

## Run Test Case
- Run Test Case - Go to desired Java Class where has Test Case, Right click of mouse on Test Case >> click on Run
- Run XML File - After create TestNG file, Right click of mouse on TestNG xml >> click on Run
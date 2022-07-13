## Prerequisite Security Testing Selenium With OWASP ZAP.
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
- Address & Port : Main Menu >> Tools >> Options >> Local Proxies
- API Key : Main Menu >> Tools >> Options >> API
- Add Address, Port & API Key in BaseTest class [./src/test/java/com/zap/test/BaseTest.java]
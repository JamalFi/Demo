package com.mccollege.student.amazon.homepage.Chrome;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import com.mccollege.student.amazon.AmazonHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
public class HomePageSearchSubmissionChromeTest {
    
     WebDriver myWebDriver;
   

    @BeforeEach
    public void setupChromeDriver(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");

        //create webdriver
        WebDriverManager.chromedriver().setup();
        this.myWebDriver = new ChromeDriver(chromeOptions);
    
    }

    @AfterEach
    public void cleanup(){
        //close broswer conection
        this.myWebDriver.quit();
    }


    @Test
    public void Chrome_amazon_homepage_user_can_search() throws Exception{ 

        // get page
        this.myWebDriver.get(AmazonHelper.PAGE_URL_HOME);

        //query object
        By myTextInputSearchBy = By.id("twotabsearchtextbox");

        // get element 
        WebElement myTextInputElement = this.myWebDriver.findElement(myTextInputSearchBy);

        // set value 
        myTextInputElement.sendKeys("guitar picks");

        //query object
        By mySearchSubmitButtonBy = By.id("nav-search-submit-button");

         // get element 
         WebElement mySearchSubmitElement = myWebDriver.findElement(mySearchSubmitButtonBy);

        //click 
        mySearchSubmitElement.click();

        //query object
        By mySearchResultWidgetBy = By.cssSelector("[data-cel-widget=search_result_6]");

        //get element 
        WebElement mySearchResultWidgetElement= myWebDriver.findElement(mySearchResultWidgetBy);

        //verify element 
        Assertions.assertThat(mySearchResultWidgetElement).isNotNull();

    }



}

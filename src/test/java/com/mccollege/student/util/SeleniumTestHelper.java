package com.mccollege.student.util;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestHelper {
    
    /**
     * @paran webDriver
     * @paran url
     * @paran myElementSearchBys
     */


    public static void webdriver_element_exists(WebDriver webDriver, String url, List<By> myElementSearchBys) throws Exception{

        //get page
        webDriver.get(url);

        // loop through element search bar bys
        for(By myElementSearchBy : myElementSearchBys){

        // get element 
        WebElement myWebElement = webDriver.findElement(myElementSearchBy);
        
        //verify element exist
        Assertions.assertThat(myWebElement).isNotNull();

        }

    }
    /**
     * 
     * @param url
     * @param elementId
     * @throws Exception
     */
    public static void Chrome_element_with_id_exists_on_page(String url, String elementId) throws Exception{

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");

        // biuld webdriver 
        WebDriverManager.chromedriver().setup();
        WebDriver myWebDriver = new ChromeDriver(chromeOptions);

        // get page\
        myWebDriver.get(url);

        // build element search by
        By myElementSearchBy = By.id(elementId);

        // get element
        WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);
            
        //verify element exist
        Assertions.assertThat(myWebElement).isNotNull();

        // close/quit browser connection
        myWebDriver.quit();

    }



}

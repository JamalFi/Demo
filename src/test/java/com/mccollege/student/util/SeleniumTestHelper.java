package com.mccollege.student.util;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.web.service.invoker.UrlArgumentResolver;

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





}

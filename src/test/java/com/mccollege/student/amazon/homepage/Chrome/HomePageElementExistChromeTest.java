package com.mccollege.student.amazon.homepage.Chrome;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import com.mccollege.student.amazon.AmazonHelper;
import com.mccollege.student.util.SeleniumTestHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
public class HomePageElementExistChromeTest {
    
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
    public void Chrome_amazon_homepage_top_navbar_exist() throws Exception{

        // build list of element queries
        final List<By> myElementSearchBys = new ArrayList<By>();
        myElementSearchBys.add(By.id("navbar"));

        //verify element exists 
        SeleniumTestHelper.webdriver_element_exists(this.myWebDriver, AmazonHelper.PAGE_URL_HOME, myElementSearchBys);

    }

    @Test
    public void Chrome_amazon_homepage_navbar_search_exist() throws Exception{

    // build list of element queries
    final List<By> myElementSearchBys = new ArrayList<By>();
    myElementSearchBys.add(By.id("twotabsearchtextbox"));

    //verify element exists 
    SeleniumTestHelper.webdriver_element_exists(this.myWebDriver, AmazonHelper.PAGE_URL_HOME, myElementSearchBys);
    }

    @Test
    public void Chrome_amazon_homepage_main_navbar_element_exist() throws Exception{

    // build list of element queries
    final List<By> myElementSearchBys = new ArrayList<By>();
    myElementSearchBys.add(By.id("navbar"));
    myElementSearchBys.add(By.id("twotabsearchtextbox"));
    myElementSearchBys.add(By.id("icp-nav-flyout"));
    myElementSearchBys.add(By.id("nav-link-accountList"));
    myElementSearchBys.add(By.id("nav-orders"));
    myElementSearchBys.add(By.id("nav-cart"));

    //verify element exists 
    SeleniumTestHelper.webdriver_element_exists(this.myWebDriver, AmazonHelper.PAGE_URL_HOME, myElementSearchBys);
    }
  
   


}

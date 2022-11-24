/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.uniqueidea.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author lequa
 */
public class Guru99Test {

    private static WebDriver myBrowser;

    // chi chayj 1 lan duy nhat truoc tat ca cac ham @Test => khoi dong data / value cua cac bien de san dung cho cac ham @Test
    @BeforeAll
    public static void setUpClass() {
        //star webbrowser
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();

    }

    @Test
    public void checkLoginGivenRightAccountShowWelcomeMsg() throws InterruptedException {
        //cac ham test chay o dau
        // di tim cac o nhap user/pass, dua data vao, nhan login
        String username = "mngr451807";
        String password = "juzazAh";
        myBrowser.get("https://demo.guru99.com/v4/");
        WebElement txtUsername = myBrowser.findElement(By.cssSelector("input[name='uid']"));
        txtUsername.sendKeys(username);
        WebElement txtPassword = myBrowser.findElement(By.cssSelector("input[name='password']"));
        txtPassword.sendKeys(password);
        WebElement btnLogin = myBrowser.findElement(By.cssSelector("input[value='LOGIN']"));
        btnLogin.click();
        // must be waitting until website is in new blank or u will get notify NoSuchElementException 
        Thread.sleep(3000);
        WebElement lbWelcomeMsg = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        System.out.println("Welcome msg: " + lbWelcomeMsg.getText());
        //You are finish wirrting a bot which crawler data
        assertEquals("Manger ID : " + username, lbWelcomeMsg.getText());
        Thread.sleep(3000);
    }

    //nghia la tat ca cac ham @Test xong xuoi , moi den luot no 
    // no ding de don deo cac bien, don dep data dc bay ra boi cac @Test
    //ham reset()
    @AfterAll
    public static void tearDownClass() {
        //close webbrowser
        myBrowser.close();
    }

}

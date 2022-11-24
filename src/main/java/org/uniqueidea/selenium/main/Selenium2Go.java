package org.uniqueidea.selenium.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
/**
 *
 * @author lequa
 */
public class Selenium2Go {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Please wait 2s before launching the browser!");
        Thread.sleep(2000);
        playWithGoogleSearch();
    }
    
    public static void playWithGoogleSearch() throws InterruptedException {
        WebDriver myBrowser;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
        myBrowser.get("https://google.com");
        //dinh vi the can de tac dong len no bang code vd: tim nc nut nhan thi action = click, input => nhap data
        // moi tag tim thay su dung tren trang web de laf 1 object thuoc class webelement
        WebElement txtSearch = myBrowser.findElement(By.name("q"));
        txtSearch.sendKeys("BTS");
        txtSearch.submit();
        Thread.sleep(10000);
        myBrowser.quit();
    }
    
    public static void playWithYutube() throws InterruptedException {
        //Khai bao bien object de tro vao vung RAM noi ta new 
        //1 cai trinh duyet
        WebDriver myBrowser;
        //Khai bao driver voi may ao java | nap class dieu khien trinh duyet vao trong may ao java
        //de dieu khien 1 cai tap trinh duyet se duoc mo
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        // trinh duyet xuat hien, new 1 object, ton ram, nam trong heap
        ChromeOptions opt = new ChromeOptions();
        //thiet lap 1 vai thong so truoc khi mo tt
        opt.addArguments("--incognito");
        opt.addArguments("--lang=ja-JP");
        myBrowser = new ChromeDriver(opt);//lingoes.net
        myBrowser.get("https://youtube.com");
        
        Thread.sleep(10000);
        
        myBrowser.quit();//dọn vùng ram sau khi xài song browser
    }
}

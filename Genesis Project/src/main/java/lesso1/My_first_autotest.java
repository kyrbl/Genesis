package lesso1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;

public class My_first_autotest {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Busk\\Desktop\\Genesis\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        driver.findElement(By.cssSelector("[name='q']")).clear();
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Hello, World");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector(".g h3")).click();

        System.out.print(driver.getTitle());

    }
}

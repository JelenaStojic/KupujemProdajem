//Domaći: Otići na kupujemprodajem.com, u pretragu ukucati iphone 13, kliknuti na prvi rezultat.
// Proveriti da je naslov oglasa onaj koji smo uočili i tokom manuelnog izvođenja kejsa.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class domaci {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.kupujemprodajem.com");

        driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]")).click();

        WebElement inputSearch = driver.findElement(By.id("searchKeywordsInput"));
        inputSearch.sendKeys("iphone 13");
        inputSearch.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"adDescription7321776\"]/div/section[2]/div[1]/div[1]/a")).click();


        String title = driver.getTitle();
        String expected = "iPhone 13, iPhone 12, iPhone 11 - NOVO! - KupujemProdajem";

        if (title.equals(expected)) {
            System.out.println("Validno");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.close();

        }
    }
}

package ua.edu.ukma;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTests {
    WebDriver driver;

    @BeforeEach
    void startDriver(){
        driver = new ChromeDriver();
    }

    @AfterEach
    void stopDriver(){
        driver.quit();
    }

    @Test
    void testYTMusicNotLoggedIn(){
        driver.get("https://music.youtube.com/watch?v=Vd_nkokQwnQ&list=OLAK5uy_momGwUZ9oagpTGS8PsTOoaJb2hatdutg0");
        List<WebElement> name = driver.findElements(By.cssSelector(".sign-in-link.app-bar-button.style-scope.ytmusic-nav-bar"));
        assertThat(name).isNotEmpty();
    }

    @Test
    void testNaukmaFaculties(){
        driver.get("https://www.ukma.edu.ua/index.php/osvita/fakulteti");
        List<WebElement> elements = driver.findElements(By.className("cbp-ig-grid"));
        WebElement list = elements.get(0);
        String text = list.getText();
        text = text.replaceAll("\n", " ");
        assertThat(text).isEqualTo("Факультет гуманітарних наук " +
                "Факультет економічних наук " +
                "Факультет соціальних наук та соціальних технологій " +
                "Факультет інформатики " +
                "Факультет правничих наук " +
                "Факультет природничих наук " +
                "Факультет «Києво-Могилянська школа професійної та неперервної освіти» " +
                "Факультет охорони здоров’я, соціальної роботи та психології " +
                "Києво-Могилянська Бізнес-Школа (kmbs)");
    }

    @Test
    void testGit(){
        driver.get("https://github.com/andrewromanyk?tab=repositories");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li/div[1]/div[1]/h3/a"));
        String[] names = elements.stream().map(WebElement::getText).toArray(String[]::new);
        for (String name : new String[]{"CICD", "Annotations", "Maven-Archetype", "GradleTestProject", "HashProject"}){
            assertThat(names).contains(name);
        }
    }
}

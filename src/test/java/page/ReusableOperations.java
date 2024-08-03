package page;

import globalVariables.GlobalVariables;
import io.cucumber.java.lv.Ja;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.FitpeoPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import stepdefinitions.Hooks;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ReusableOperations
{
    static WebDriver driver;


    public void click(By by)
    {
        this.driver = Hooks.getDriver();
        try{
            driver.findElement(by).click();
        }catch(Exception e){}

    }
    public  void jsClick(By by)
    {
        WebElement ele =driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",ele);

    }
    public  String getText(By by)
    {
        String text="";
        try{
            text =driver.findElement(by).getText();

        }catch(Exception e){
            e.printStackTrace();
        }
        return text;
    }

    public  void takeScreenshot(By by)
    {
        try{

            WebElement ssofElement = driver.findElement(by);
            File scrfile = ssofElement.getScreenshotAs(OutputType.FILE);
            File destfile =new File("target/screenshots/"+ GlobalVariables.scenarioname+"_"+GlobalVariables.sscount+".png");
            scrfile.renameTo(destfile);
            GlobalVariables.sscount++;

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public  void takeScreenshot()
    {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);

        // Save the screenshot
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("target/screenshots/"+ GlobalVariables.scenarioname+"_"+GlobalVariables.sscount+".png"));
            GlobalVariables.sscount++;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void moveToElement(By by){
        try{
            WebElement e = driver.findElement(by);
            Actions action = new Actions(driver);
            action.moveToElement(e).perform();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  void waitforSeconds(int timeunit)
    {
        try{
            Thread.sleep(timeunit*1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public  void waitForExpectedElement(By by, int timeunit)
    {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeunit));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  void VerifyText(By by, String expectedtext){
        try{
            String actualtext = driver.findElement(by).getText();
           Assert.assertEquals(actualtext,expectedtext,"Text does not matched");

        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();

        }
    }

    public  void sendText(By by,String text)
    {
        try{
            driver.findElement(by).sendKeys(text);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public  void sendText(By by,int text)
    {
        try{
            driver.findElement(by).click();
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(String.valueOf(text));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void jsSendText(By by,String text)
    {
        try{

            WebElement inputElement = driver.findElement(by);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if(text.isEmpty()) {
                js.executeScript("arguments[0].value=''", inputElement);
            }else {
                js.executeScript("arguments[0].value='" + text + "'", inputElement);
            }
        }catch(Exception e){

        }
    }
    public void moveByOffset(By by,int xoffset,int yoffset)
    {
        try{
            WebElement target = driver.findElement(by);
            Actions act = new Actions(driver);
            act.clickAndHold(target).moveByOffset(xoffset,yoffset).release().build().perform();
            waitforSeconds(4);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void scrollDown()
    {
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        }catch(Exception e){
            e.printStackTrace();
        }
    }



}

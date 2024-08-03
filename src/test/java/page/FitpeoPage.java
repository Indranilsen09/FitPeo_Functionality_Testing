package page;

import locators.PageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import stepdefinitions.Hooks;

import java.util.*;

import static page.ReusableOperations.*;

public class FitpeoPage
{
    static WebDriver driver;
    ReusableOperations bot = new ReusableOperations();
    public void setDriver(){
        this.driver = Hooks.getDriver();
    }
    public void navigateTo(String pagename)
    {
        setDriver();
        try{
            System.out.println("User navigating to page: "+ pagename);
            if(pagename.contains("Revenue Calculator")) {
                bot.click(PageLocators.btn_revenueCalc);
            }
            bot.takeScreenshot();
            bot.waitforSeconds(5);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void moveToSlider()
    {
        try{

            bot.moveToElement(PageLocators.btn_slider);
            bot.waitForExpectedElement(PageLocators.input_patientnum,20);
            bot.takeScreenshot();
            bot.jsClick(PageLocators.input_patientnum);


         }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
         }
    }

    public void SetTheSlider(String patientcount)
    {
        try{
            int countofPatient = Integer.parseInt(patientcount);
            //calculating the xoffsetvalue
            int xoffsetval = (int)Math.round(countofPatient/6.62);
            WebElement xy = driver.findElement(PageLocators.btn_Slider_thumb);
            //System.out.println(x+"   "+ y);//675   695
            WebElement patientNum = driver.findElement(PageLocators.input_patientnum);
            int patients = Integer.parseInt(patientNum.getAttribute("value"));
            bot.moveToElement(PageLocators.input_patientnum);
            bot.waitforSeconds(6);
            bot.takeScreenshot(PageLocators.eligible_patient_view);
            //Setting the Slider Value to 0
            bot.moveByOffset(PageLocators.btn_Slider_thumb,-100,0);

            //Setting the Slider value to 822; since 820 is very difficult & //peroffsetvalue: 1 offset = 6.62 patients
            //which means we have to give offset value as 123.7672f -- moveByOffset only takes integer value
            bot.moveByOffset(PageLocators.btn_Slider_thumb,xoffsetval,0); //816
            bot.takeScreenshot(PageLocators.eligible_patient_view);
            System.out.println("Patient Number is: "+driver.findElement(PageLocators.input_patientnum).getAttribute("value"));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setThePatient(String patients){
        try{
            bot.waitForExpectedElement(PageLocators.input_patientnum,20);
            bot.takeScreenshot();
            bot.takeScreenshot(PageLocators.eligible_patient_view);
            String script = Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+patients;
            bot.sendText(PageLocators.input_patientnum,script);
            bot.takeScreenshot(PageLocators.eligible_patient_view);
           bot.waitforSeconds(2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void selectCodes(String code1,String code2,String code3,String code4)
    {

        try{
            if(driver.findElements(PageLocators.cpt_Checkbox(code1)).size()>0)
            {
                bot.moveToElement(PageLocators.cpt_Checkbox(code1));
                bot.jsClick(PageLocators.cpt_Checkbox(code1));
                bot.takeScreenshot(PageLocators.cpt_code_view(code1));
                bot.waitforSeconds(2);
            }else{
                System.out.println("CPT Code: "+ code1+ " is Not Available");
            }
            if(driver.findElements(PageLocators.cpt_Checkbox(code2)).size()>0)
            {
                bot.moveToElement(PageLocators.cpt_Checkbox(code2));
                bot.jsClick(PageLocators.cpt_Checkbox(code2));
                bot.takeScreenshot(PageLocators.cpt_code_view(code2));
                bot.waitforSeconds(2);
            }else{
                System.out.println("CPT Code: "+ code2+ " is Not Available");
            }
            if(driver.findElements(PageLocators.cpt_Checkbox(code3)).size()>0)
            {
                bot.moveToElement(PageLocators.cpt_Checkbox(code3));
                bot.jsClick(PageLocators.cpt_Checkbox(code3));
                bot.takeScreenshot(PageLocators.cpt_code_view(code3));
                bot.waitforSeconds(2);
            }else{
                System.out.println("CPT Code: "+ code3+ " is Not Available");
            }
            if(driver.findElements(PageLocators.cpt_Checkbox(code4)).size()>0)
            {
                bot.moveToElement(PageLocators.cpt_Checkbox(code4));
                bot.jsClick(PageLocators.cpt_Checkbox(code4));
                bot.takeScreenshot(PageLocators.cpt_code_view(code4));
                bot.waitforSeconds(2);
            }else{
                System.out.println("CPT Code: "+ code4+ " is Not Available");
            }
            bot.moveToElement(PageLocators.txt_SelectedCodes);
            bot.takeScreenshot(PageLocators.selectedCodes_view);
            List<WebElement> chipCodes = driver.findElements(PageLocators.btn_MuiChipCodes);
            List<String> userCodes = new ArrayList<>();
            userCodes.add(code1.replace("-",""));
            userCodes.add(code2.replace("-",""));
            userCodes.add(code3.replace("-",""));
            userCodes.add(code4.replace("-",""));
            for(int i=0;i<chipCodes.size();i++)
            {
                Assert.assertEquals(chipCodes.get(i).getText().toUpperCase(),userCodes.get(i),": Code is Not Selected ");
                System.out.println(chipCodes.get(i).getText()+ " Selected Properly");
            }



        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void validateReimbursement(String value)
    {
        try{

            bot.scrollDown();
            bot.scrollDown();
            if(driver.findElements(PageLocators.header_view).size()>0) {
                bot.takeScreenshot(PageLocators.header_view);
                bot.takeScreenshot();
                bot.waitforSeconds(3);
            }else{
                bot.scrollDown();
            }
            bot.takeScreenshot(PageLocators.header_view);
            String TIRforallpatient = bot.getText(PageLocators.txt_valuesheader("Total Recurring Reimbursement"));
            String TIV = bot.getText(PageLocators.txt_valuesheader("Total Individual Patient/Month"));
            String OTRforallpatient = bot.getText(PageLocators.txt_valuesheader("One Time Reimbursement"));
            String TGRperyear = bot.getText(PageLocators.txt_valuesheader("Total Gross Revenue Per Year"));
            System.out.println("Total Recurring Reimbursement for all Patients Per Month: " + TIRforallpatient);
            System.out.println("Total Individual Patient/Month: " + TIV);
            System.out.println("One Time Reimbursement for all Patients Annually: " + OTRforallpatient);
            System.out.println("Total Gross Revenue Per Year: " + TGRperyear);

            Assert.assertEquals(TIRforallpatient.replace("$",""),value,"Total Recurring Re-imbursement for all patient is not matching");


        }catch(Exception e){

        }


    }



}

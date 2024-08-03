package locators;

import org.openqa.selenium.By;

public class PageLocators
{
    public static By btn_revenueCalc= By.xpath("//a[contains(@href,'revenue-calculator')]/div");
    public static By btn_slider = By.xpath("//span[contains(@class,'MuiSlider-thumb')]/input");
    public static By btn_Slider_thumb = By.xpath("//span[contains(@class,'MuiSlider-thumb')]");
    public static By input_patientnum = By.xpath("//div[contains(@class,'MuiInputBase')]//input");
    public static By cpt_Checkbox(String code){
        return By.xpath("//p[text()='"+code+"']//parent::div//label/span[contains(@class,Muicheckbox-root)]/input");
    }
    public static By txt_valuesheader(String text){
        return By.xpath("//p[contains(text(),'"+text+"')]/p");
    }

    public static By txt_SelectedCodes = By.xpath("//div/p[text()='Selected CPT Codes']");
    public static By btn_MuiChipCodes = By.xpath("//div[contains(@class,MuiChip-deletable) and @role='button']//span");

    //Screenshot ViewPorts
    public static By selectedCodes_view= By.xpath("(//div/p[text()='Selected CPT Codes']//parent::div//parent::div[contains(@class,'MuiBox-root')])[1]");
    public static By cpt_code_view(String codes){return
            By.xpath("//p[text()='"+codes+"']//parent::div");
    }
    public static By eligible_patient_view= By.xpath("//h4[text()='Medicare Eligible Patients']//parent::div");
    public static By header_view= By.xpath("(//header[contains(@class,'MuiPaper-elevation')])[2]");

}

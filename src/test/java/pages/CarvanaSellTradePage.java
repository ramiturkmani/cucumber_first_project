package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaSellTradePage {
    public CarvanaSellTradePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "kjhwtS")
    public WebElement realOfferHeading;

    @FindBy(className = "lnhlkr")
    public WebElement wePickUpText;

    @FindBy(className = "dkObNV")
    public WebElement vinButton;

    @FindBy(className = "jLejJf")
    public WebElement vinInputBox;

    @FindBy(className = "withVin")
    public WebElement getOfferButton;

    @FindBy(className = "kjoUgV")
    public WebElement vinErrorMessage;
}

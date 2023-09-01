package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaLoanPage {
    public CarvanaLoanPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement carPriceInput;

    @FindBy(css = "select[name='creditScoreIndex']")
    public WebElement creditScoreDropdown;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTermDropdown;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInput;

    @FindBy(className = "loan-calculator-display-value")
    public WebElement monthlyPayment;
}
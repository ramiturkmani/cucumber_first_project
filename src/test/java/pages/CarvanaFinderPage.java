package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaFinderPage {

    public CarvanaFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div>h1")
    public WebElement whatCarH1;

    @FindBy(css = "div>h3")
    public WebElement carFinderH3;

    @FindBy(css = ".leftSide>a")
    public WebElement carFinderLink;

    @FindBy(className = "jXLVsd")
    public WebElement mostImportantHeading;

    @FindBy(className = "esZOxN")
    public WebElement select4Text;
}

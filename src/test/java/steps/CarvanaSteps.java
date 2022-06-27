package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.CarvanaFinderPage;
import pages.CarvanaHomePage;
import pages.CarvanaLoanPage;
import pages.CarvanaSellTradePage;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

import javax.rmi.CORBA.Util;

public class CarvanaSteps {
    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaFinderPage carvanaFinderPage;
    CarvanaSellTradePage carvanaSellTradePage;
    CarvanaLoanPage carvanaLoanPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaFinderPage = new CarvanaFinderPage();
        carvanaSellTradePage = new CarvanaSellTradePage();
        carvanaLoanPage = new CarvanaLoanPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String key) {
        switch (key){
            case "CAR FINDER":
                carvanaHomePage.carFinderLink.click();
                break;
            case "SELL/TRADE":
                carvanaHomePage.sellTradeLink.click();
                break;
            case "AUTO LOAN CALCULATOR":
                carvanaHomePage.loanCalculatorLink.click();
                break;
            default:
                throw new NotFoundException("Menu item element not found!!!");
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertEquals(text, carvanaFinderPage.whatCarH1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertEquals(text, carvanaFinderPage.carFinderH3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertEquals(text, carvanaFinderPage.mostImportantHeading.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertEquals(text, carvanaFinderPage.select4Text.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertEquals(text, carvanaSellTradePage.realOfferHeading.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertEquals(text, carvanaSellTradePage.wePickUpText.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.waitUntilTextToBePresentInElement(driver,15, carvanaSellTradePage.vinErrorMessage, text);
                Assert.assertEquals(text, carvanaSellTradePage.vinErrorMessage.getText());
                break;
            default:
                throw new NotFoundException("Text not defined properly in the feature file!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String link) {
        Assert.assertTrue(carvanaFinderPage.carFinderLink.isDisplayed());
        Assert.assertEquals(link, carvanaFinderPage.carFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        carvanaFinderPage.carFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button){
            case "VIN":
                carvanaSellTradePage.vinButton.click();
                break;
            case "GET MY OFFER":
                carvanaSellTradePage.getOfferButton.click();
                break;
            default:
                throw new NotFoundException("Button not found!!!");
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String string) {
        carvanaSellTradePage.vinInputBox.sendKeys(string);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String string) {
        ActionsUtil.moveToElement(carvanaHomePage.financingDropdown);
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String inputBox, String entry) {
        switch (inputBox){
            case "Cost of Car I want":
                carvanaLoanPage.carPriceInput.sendKeys(entry);
                break;
            case "What is Your Down Payment?":
                carvanaLoanPage.downPaymentInput.sendKeys(entry);
                break;
            default:
                throw new NotFoundException("Input Box not found!!!");
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String dropdown, String selection) {
        switch (dropdown){
            case "What’s Your credit Score?":
                DropdownHandler.selectOptionByVisibleText(carvanaLoanPage.creditScoreDropdown, selection);
                break;
            case "Choose Your Loan Terms":
                DropdownHandler.selectOptionByVisibleText(carvanaLoanPage.loanTermDropdown, selection);
                break;
            default:
                throw new NotFoundException("Dropdown not found!!!");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String string) {
        Assert.assertEquals(string, carvanaLoanPage.monthlyPayment.getText());
    }
}

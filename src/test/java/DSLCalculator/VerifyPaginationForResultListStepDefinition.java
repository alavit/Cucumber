package DSLCalculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class VerifyPaginationForResultListStepDefinition extends AbstractTest {

    MainPage mainPage;
    SearchResultPage searchResultPage;

    // TODO: Call steps from Scenario 1 to avoid duplication

    @Given("^the User is on the DSL Result List-(\\d+)$")
    public void theUserIsOnTheDSLResultList(int arg0) {
        mainPage = open(url, MainPage.class);
        mainPage.checkMainPageLoad();

        // if accept cookies button is displayed, click on it
        if (mainPage.acceptCookiesButton.exists()) {
            mainPage.acceptCookiesButton.click();
        }

        mainPage.setPostCode("030");
        mainPage.speed16Mbps.click();
        searchResultPage = mainPage.searchForProducts();
    }

    @When("^there are more than (\\d+) tariffs available for the provided Vorwahl and bandwidth$")
    public void thereAreMoreThanTariffsAvailableForTheProvidedVorwahlAndBandwidth(int arg0) {
        searchResultPage.checkNumberOfProductsIsGreaterThanOrEqual(20);
    }

    @Then("^the User should a button labeled as \"([^\"]*)\"$")
    public void theUserShouldAButtonLabeledAs(String arg0) {
        searchResultPage.next20ProductsButton.shouldBe(visible);
    }

    @When("^he/she clicks on this button$")
    public void heSheClicksOnThisButton() {
        searchResultPage.next20ProductsButton.click();
    }

    @Then("^the list should be appended with next (\\d+) tariffs and so on until all Tariffs are loaded$")
    public void theListShouldBeAppendedWithNextTariffsAndSoOnUntilAllTariffsAreLoaded(int arg0) throws InterruptedException {
        int productsOnPage = searchResultPage.productList.size(); // 21
        int i = 1;

        while (searchResultPage.next20ProductsButton.isDisplayed()) {
            i++;
            searchResultPage.next20ProductsButton.click();
            searchResultPage.productList.shouldHaveSize(productsOnPage * i - (i-1));
        }
    }
}

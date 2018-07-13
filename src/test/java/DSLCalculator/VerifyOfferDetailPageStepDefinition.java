package DSLCalculator;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class VerifyOfferDetailPageStepDefinition extends AbstractTest {

    MainPage mainPage;
    SearchResultPage searchResultPage;
    TariffPage tariffPage;

    // TODO: call step from Scenario 1 instead of duplication

    @Given("^the User is on the DSL Result List$")
    public void theUserIsOnTheDSLResultList() {
        mainPage = open(url, MainPage.class);
        mainPage.checkMainPageLoad();
        mainPage.setPostCode("030");
        mainPage.speed16Mbps.click();
        searchResultPage = mainPage.searchForProducts();
        searchResultPage.checkNumberOfProductsIsGreaterThanOrEqual(5);
    }

    @When("^he selects one of the listed Tariffs$")
    public void heSelectsOneOfTheListedTariffs() {
        // no user's action here, only selecting a tariff visually
    }

    @And("^clicks on \"([^\"]*)\" button$")
    public void clicksOnButton(String arg0) {
        tariffPage = searchResultPage.openTariff(1);
    }

    @Then("^he should be able see the details of the selected Tariff$")
    public void heShouldBeAbleSeeTheDetailsOfTheSelectedTariff() {
        tariffPage.price.shouldHave(exactText("10,41 €"));
        tariffPage.tariffName.shouldHave(exactText("Red Internet & Phone 32 Cable"));
        tariffPage.providerName.shouldHave(exactText("Vodafone Kabel Deutschland GmbH"));
        tariffPage.tariffCostsHeader.shouldBe(visible);
        tariffPage.totalCostsAfter24Months.shouldHave(exactText("249,81 Euro"));
    }

    @And("^he should also see a button labeled as \"([^\"]*)\"$")
    public void heShouldAlsoSeeAButtonLabeledAs(String arg0) {

        // check "In 5 Minuten online wechseln" buttons
        tariffPage.switchIn5MinButtons.shouldHave(size(2));
        tariffPage.switchIn5MinButtons.get(0).shouldBe(visible);
        tariffPage.switchIn5MinButtons.get(1).shouldBe(visible);
    }
}

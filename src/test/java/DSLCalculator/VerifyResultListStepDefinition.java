package DSLCalculator;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static com.codeborne.selenide.Selenide.*;

public class VerifyResultListStepDefinition extends AbstractTest{

    MainPage mainPage;
    SearchResultPage searchResultPage;

    @Given("^the User is on www\\.verivox\\.de$")
    public void the_User_is_on_www_verivox_de() {
        mainPage = open(url, MainPage.class);
    }

    @When("^he is on the DSL calculator$")
    public void he_is_on_the_DSL_calculator() {
        mainPage.checkMainPageLoad();
    }

    @And("^he enters prefix/code “Ihre Vorwahl” as (\\d+) with (\\d+) Mbit/s bandwidth selection$")
    public void heEntersPrefixCodeIhreVorwahlAsWithMbitSBandwidthSelection(int arg0, int arg1) {
        mainPage.setPostCode("030");
        mainPage.speed16Mbps.click();
    }

    @And("^clicks on the button labeled as \"([^\"]*)\"$")
    public void clicks_on_the_button_labeled_as(String arg1) {
        searchResultPage = mainPage.searchForProducts();
    }

    @Then("^he should be able see the Result List page with all the available Tariffs$")
    public void he_should_be_able_see_the_Result_List_page_with_all_the_available_Tariffs() {
        searchResultPage.checkNumberOfProductsIsGreaterThanOrEqual(5);
    }
}
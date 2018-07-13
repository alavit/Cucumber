package DSLCalculator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.CSS, using = ".page-container")
    public SelenideElement pageContainer;

    @FindBy(how = How.NAME, using = "Prefix")
    public SelenideElement postCode;

    @FindBy(how = How.XPATH, using = "//label[contains(@id, 'calc-dsl-option-2')]")
    public SelenideElement speed16Mbps;

    @FindBy(how = How.XPATH, using = "//button[@class = 'page-button'][text() = 'Jetzt vergleichen']")
    public SelenideElement searchButton;

    public void checkMainPageLoad() {
        pageContainer.shouldBe(Condition.visible);
    }

    public void setPostCode(String vorwhal) {
        postCode.setValue(vorwhal);
    }

    public SearchResultPage searchForProducts() {
        searchButton.click();
        return page(SearchResultPage.class);
    }

}



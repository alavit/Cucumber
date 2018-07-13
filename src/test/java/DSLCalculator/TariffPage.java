package DSLCalculator;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TariffPage {

    @FindBy(how = How.CLASS_NAME, using = "price")
    public SelenideElement price;

    @FindBy(how = How.XPATH, using = "//a[@class = 'responsive-label-txt offer-page-cta']")
    public ElementsCollection switchIn5MinButtons;

    @FindBy(how = How.XPATH, using = "//h3[@class = 'group-header']")
    public SelenideElement tariffName;

    @FindBy(how = How.XPATH, using = "//strong[@data-description = 'providerName']")
    public SelenideElement providerName;

    @FindBy(how = How.XPATH, using = "//tr/th[text() = 'Tarifkosten']")
    public SelenideElement tariffCostsHeader;

    @FindBy(how = How.XPATH, using = "//span[@ng-bind-html][contains(., 'Euro')]")
    public SelenideElement totalCostsAfter24Months;
}

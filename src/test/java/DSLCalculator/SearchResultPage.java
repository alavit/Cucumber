package DSLCalculator;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.page;

public class SearchResultPage {

    @FindBy(how = How.XPATH, using = "//ul[@class = 'product-list']/li")
    public ElementsCollection productList;

    @FindBy(how = How.XPATH, using = "//button[@class = 'responsive-label-txt resultlist-cta']")
    public ElementsCollection moreAboutTariffButtons;

    @FindBy(how = How.XPATH, using = "//button[@ng-click][contains(., '20')]")
    public SelenideElement next20ProductsButton;

    public void checkNumberOfProductsIsGreaterThanOrEqual(int expectedNumber) {
        productList.shouldHave(sizeGreaterThanOrEqual(expectedNumber));
    }

    public TariffPage openTariff(int tariffIndex){
        moreAboutTariffButtons.get(1).click();
        return page(TariffPage.class);
    }
}

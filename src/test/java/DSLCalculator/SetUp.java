package DSLCalculator;

import com.codeborne.selenide.Configuration;
import cucumber.api.java.Before;

public class SetUp {

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
    }
}
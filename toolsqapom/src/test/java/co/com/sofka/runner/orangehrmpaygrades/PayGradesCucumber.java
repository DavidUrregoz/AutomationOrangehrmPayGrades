package co.com.sofka.runner.orangehrmpaygrades;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty","html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features.webui.orangehrmpaygrades/payGrades.feature"},

        glue = {"co.com.sofka.stepdefinition.orangehrm.opt3"},
        tags = "not @ignore"
)
public class PayGradesCucumber{
}

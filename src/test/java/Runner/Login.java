package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import java.awt.*;

@CucumberOptions(
        features = {"src/test/resources/Feature/Login.feature"},
        snippets = SnippetType.CAMELCASE,
        glue = {"StepDefinition"}
)
public class Login extends AbstractTestNGCucumberTests {
}

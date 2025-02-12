package runner;

import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources/features/Login.feature",
glue= {"stepDefinitions","hooks"},
publish=true,
plugin={"pretty","html:target/CucumberReports/CucumberReport.html"})

public class MyRunner {

}

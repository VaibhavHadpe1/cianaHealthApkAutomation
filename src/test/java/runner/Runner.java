package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/BookAppointment.feature") // Path to your feature files in src/test/resources/features
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/cucumber.json, html:target/cucumber-html-reports.html,html:target/cucumber-jvm-report")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps") // Package of your step definitions
@ConfigurationParameter(key = "tags", value = "@run")

public class Runner {

}


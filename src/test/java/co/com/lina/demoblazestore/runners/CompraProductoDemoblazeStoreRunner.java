package co.com.lina.demoblazestore.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/compra_producto_demoblaze_store.feature",
        glue = "co.com.lina.lara.blaze.store.definitions",
        snippets = SnippetType.CAMELCASE
)
public class CompraProductoDemoblazeStoreRunner {
}

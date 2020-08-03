package co.com.lina.lara.blaze.store.steps;

import co.com.lina.lara.blaze.store.pages.PaginaPrincipalPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

public class SeleccionProductoStep extends ScenarioSteps {

    @Page
    PaginaPrincipalPage paginaPrincipalPage;

    @Step
    public void abrirPaginaDemoblazeStore() {
        paginaPrincipalPage.open();
    }

    @Step
    public void seleccionarProducto(String categoria, String producto) {
        paginaPrincipalPage.seleccionarCategoriaMenu(categoria);
        paginaPrincipalPage.seleccionarProducto(producto);
    }
}

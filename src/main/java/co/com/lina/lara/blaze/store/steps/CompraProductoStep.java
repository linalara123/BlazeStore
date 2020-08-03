package co.com.lina.lara.blaze.store.steps;

import co.com.lina.lara.blaze.store.pages.CarritoComprasPage;
import co.com.lina.lara.blaze.store.pages.DetalleProductoPage;
import co.com.lina.lara.blaze.store.pages.PaginaPrincipalPage;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.MatcherAssert;

import static co.com.lina.lara.blaze.store.utils.Constantes.*;

public class CompraProductoStep extends ScenarioSteps {

    @Page
    PaginaPrincipalPage paginaPrincipalPage;

    @Page
    DetalleProductoPage detalleProductoPage;

    @Page
    CarritoComprasPage carritoComprasPage;

    @Step
    public void adicionarProductoAlCarrito() {
        detalleProductoPage.adicionarProductoAlCarrito();
        paginaPrincipalPage.seleccionarOpcionMenuPrincipal(OPCION_CART);
    }

    @Step
    public void finalizarCompraProducto(DataTable datosCompra) {
        carritoComprasPage.realizarPedidoProducto();
        carritoComprasPage.ingresarNombre(datosCompra.cells(LISTA_DATOS).get(FILA_DATOS).get(0));
        carritoComprasPage.ingresarPais(datosCompra.cells(LISTA_DATOS).get(FILA_DATOS).get(1));
        carritoComprasPage.ingresarCiudad(datosCompra.cells(LISTA_DATOS).get(FILA_DATOS).get(2));
        carritoComprasPage.ingresarNumeroTarjetaCredito(datosCompra.cells(LISTA_DATOS).get(FILA_DATOS).get(3));
        carritoComprasPage.ingresarMes(datosCompra.cells(LISTA_DATOS).get(FILA_DATOS).get(4));
        carritoComprasPage.ingresarAnio(datosCompra.cells(LISTA_DATOS).get(FILA_DATOS).get(5));
        carritoComprasPage.confirmarCompra();
    }

    @Step
    public void validarCompraExitosa() {
        MatcherAssert.assertThat("Error: Se esperaba el mensaje de respuesta exitosa: <" + SUCCESS_PURCHASE + ">, pero se obtuvo el mensaje: <" + carritoComprasPage.obtenerMensajeCompra() + ">.",
                SUCCESS_PURCHASE.equals(carritoComprasPage.obtenerMensajeCompra()));
    }

    @Step
    public void validarInformacionCarrito(String producto) {
        MatcherAssert.assertThat("Error: Se esperaba el siguiente producto en el carrito: <" + producto + ">, pero se obtuvo el siguiente: <" + carritoComprasPage.obtenerInformacionProductoCarrito() + ">.",
                producto.equals(carritoComprasPage.obtenerInformacionProductoCarrito()));
    }
}

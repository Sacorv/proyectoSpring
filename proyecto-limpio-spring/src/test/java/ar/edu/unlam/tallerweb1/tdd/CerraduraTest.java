package ar.edu.unlam.tallerweb1.tdd;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CerraduraTest {

    public static final int CODIGO_DE_APERTURA = 3434;
    public static final int CODIGO_INCORRECTO = 8585;

    @Test
    public void cuandoSeCreaLaCajaFuerteDebeEstarAbierta(){
        //preparacion Given (dado)

        //ejecucion When (cuando)
        CajaFuerte caja = whenCreoUnaCajaFuerte();

        //comprobacion Then (entonces)
        thenLaCajaFuerteEstaAbierta(caja);

    }

    /*@Test
    public void alCerrarLaCajaFuerteDebeEstarCerrada(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();

        whenCierroLaCajaFuerte(caja);

        thenLaCajaFuerteEstaCerrada(caja);

    }*/

    @Test
    public void alCerrarConCodigoLaCajaFuerteDebeEstarCerrada(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();

        whenCierroLaCajaFuerteConCodigo(caja, CODIGO_DE_APERTURA);

        thenLaCajaFuerteEstaCerrada(caja);

    }

    @Test
    public void alIngresarElCodigoCorrectoLaCajaSeAbre(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO_DE_APERTURA);

        whenAbroLaCajaConCodigo(caja, CODIGO_DE_APERTURA);

        thenLaCajaFuerteEstaAbierta(caja);
    }

    @Test
    public void alIngresarElCodigoIncorrectoLaCajaNoSeAbre(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO_DE_APERTURA);

        whenAbroLaCajaConCodigo(caja, CODIGO_INCORRECTO);

        thenLaCajaFuerteEstaCerrada(caja);
    }

    @Test
    public void alCerrarUnaCajaFuerteCerradaConElCodigoDeAperturaLaCajaSeAbre(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO_DE_APERTURA);

        caja.cerrar(CODIGO_DE_APERTURA);

        thenLaCajaFuerteEstaAbierta(caja);
    }

    @Test
    public void alCerrarUnaCajaFuerteCerradaConUnCodigoIncorrectoLaCajaNoSeAbre(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO_DE_APERTURA);

        caja.cerrar(CODIGO_INCORRECTO);

        thenLaCajaFuerteEstaCerrada(caja);
    }

    @Test
    public void alAbrirConCodigoErroneoTresVecesConsecutivasLaCerraduraSeBloquea(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO_DE_APERTURA);

        whenAbroLaCajaConCodigo(caja, CODIGO_INCORRECTO);
        whenAbroLaCajaConCodigo(caja, CODIGO_INCORRECTO);
        whenAbroLaCajaConCodigo(caja, CODIGO_INCORRECTO);

        thenLaCajaestaBloqueada(caja);
    }

    @Test
    public void alAbrirConCodigoErroneoTresVecesNoConsecutivasLaCerraduraSeAbre(){
        CajaFuerte caja = givenCreoUnaCajaFuerte();
        caja.cerrar(CODIGO_DE_APERTURA);

        whenAbroLaCajaConCodigo(caja, CODIGO_INCORRECTO);
        whenAbroLaCajaConCodigo(caja, CODIGO_INCORRECTO);
        whenAbroLaCajaConCodigo(caja, CODIGO_DE_APERTURA);

        caja.cerrar(CODIGO_DE_APERTURA);
        whenAbroLaCajaConCodigo(caja, CODIGO_INCORRECTO);

        thenLaCajaFuerteEstaCerrada(caja);
        thenLaCajaFuerteNoEstaBloqueada(caja);
    }

    private void thenLaCajaFuerteNoEstaBloqueada(CajaFuerte caja) {
        assertThat(caja.estaBloqueada()).isFalse();
    }


    private void thenLaCajaestaBloqueada(CajaFuerte caja) {
        assertThat(caja.estaBloqueada()).isTrue();
    }

    private void whenAbroLaCajaConCodigo(CajaFuerte caja, int codigo) {
        caja.abrir(codigo);
    }

    private void whenCierroLaCajaFuerteConCodigo(CajaFuerte caja, int codigo) {
        caja.cerrar(codigo);
    }


    private CajaFuerte givenCreoUnaCajaFuerte() {
        return new CajaFuerte();
    }

   /* private void whenCierroLaCajaFuerte(CajaFuerte caja) {
        caja.cerrar();
    }*/

    private void thenLaCajaFuerteEstaCerrada(CajaFuerte caja) {
        assertThat(caja.estaAbierta()).isFalse();
    }



    private CajaFuerte whenCreoUnaCajaFuerte() {
        return new CajaFuerte();
    }

    private void thenLaCajaFuerteEstaAbierta(CajaFuerte caja) {
        assertThat(caja.estaAbierta()).isTrue();
    }

}


/* TDD
* 1) No escribas codigo productivo sin un test que de rojo antes
* 2) Hace el codigo mas simple posible para pasar a verde
* 3) Mejora tu codigo estando en verde (refactor)
* */


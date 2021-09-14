package ar.edu.unlam.tallerweb1.tdd;

public class CajaFuerte {

    private Boolean abierta = true;
    private int codigoDeApertura;
    private int intentosFallidos = 0;
    private boolean bloqueada = false;

    public boolean estaAbierta() {
        return abierta;
    }

    /*public void cerrar() {
        this.abierta = false;
    }
*/
    //Este codigo es el que se pone por primera vez al cerrar la caja y sea el valido para poder abri la caja
    public void cerrar(int codigoDeApertura){
        if(!estaAbierta()){
            abrir(codigoDeApertura);
        }
        else{
            this.codigoDeApertura = codigoDeApertura;
            abierta = false;
        }

    }

    public void abrir(int codigo) {
        if(this.codigoDeApertura==codigo) {
            abierta = true;
            intentosFallidos = 0;
        }
        else{
            intentosFallidos++;
            if(intentosFallidos == 3){
                bloqueada = true;
            }
        }
    }

    public boolean estaBloqueada() {
        return bloqueada;
    }
}

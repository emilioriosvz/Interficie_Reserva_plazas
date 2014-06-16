package javaapp7_v2;

import vista.ReservaPlazaView;
import controlador.ReservaPlazaViewController;

public class JavaApp7_v2 {

    public static void main(String[] args) {
        //Cargamos la vista (Este paso solo pinta la interficie gráfica)
        ReservaPlazaView reservaPlazaView = new ReservaPlazaView();
        
        ReservaPlazaViewController reservaPlazaViewController = new ReservaPlazaViewController(reservaPlazaView);
    }
}

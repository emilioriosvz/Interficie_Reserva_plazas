
package modelo;


public class PlazaCollection {

    final static String[] plazasIdentificador={"01A","01B","02A","02B", "03A","03B",
        "04A","04B","05A","05B","06A","06B","07A","07B",
    "08A","08B","09A","09B", "10A","10B","11A","11B","12A","12B","13A","13B","14A","14B",
    "15A","15B","16A","16B","17A","17B","18A","18B"};
    final static int vagonIdentificador=9;

    
    public static Plaza[] getCollection(){
        Plaza[] plazas = new Plaza[plazasIdentificador.length];
        for (int i=0; i<plazas.length;i++){
            plazas[i]= new Plaza(vagonIdentificador, plazasIdentificador[i]);
        }
        return plazas;
    }
}
    
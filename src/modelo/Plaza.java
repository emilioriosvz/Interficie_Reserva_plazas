package modelo;

public class Plaza {
    
    private int vagon; 
    private String asiento; 
    private boolean libre; 
    private boolean reservado; 

    public Plaza(int vagon, String asiento) {
        this.vagon = vagon;
        this.asiento = asiento;
        libre=true;
        reservado=false;
    }
    
    public void setLibre(boolean estado) {this.libre = estado;}
    public boolean isLibre() {return libre;}
    public String getAsiento() {return asiento;}
    public boolean isReservado() {return reservado;}
    public void setReservado(boolean reservado) {this.reservado = reservado;}
    public int getVagon() {return vagon;}
    
    
    
}

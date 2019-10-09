import java.io.Serializable;

public class Empleado implements Serializable
{
    int clave;
    String nombr;
    double sueld;
    double diast;
    double total;
    
    public Empleado()
    {
        
    }

    public Empleado(int clave, String nombr, double sueld, double diast, double total)
    {
        this.clave = clave;
        this.nombr = nombr;
        this.sueld = sueld;
        this.diast = diast;
        this.total = total;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombr() {
        return nombr;
    }

    public void setNombr(String nombr) {
        this.nombr = nombr;
    }

    public double getSueld() {
        return sueld;
    }

    public void setSueld(double sueld) {
        this.sueld = sueld;
    }

    public double getDiast() {
        return diast;
    }

    public void setDiast(double diast) {
        this.diast = diast;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

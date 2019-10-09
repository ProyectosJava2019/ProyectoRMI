import java.util.List;

public interface Operacion extends java.rmi.Remote 
{
    public int totalempleados() throws java.rmi.RemoteException;
    public int totalnomina() throws java.rmi.RemoteException;
    public int eliminartodos() throws java.rmi.RemoteException;
    
    public int insertar(int clave, String name, double sd, double dt, double total) throws java.rmi.RemoteException;
    public List buscar(int clave) throws java.rmi.RemoteException;
    public int eliminar(int clave) throws java.rmi.RemoteException;
    public int actualizar(int clave, String name, double sd, double dt, double total) throws java.rmi.RemoteException;
    public List listar() throws java.rmi.RemoteException;
}
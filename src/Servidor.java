import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor
{
  public Servidor()
  {
    try 
    {
        /*
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new RMISecurityManager());
        */
        Q_empleado c = new Q_empleado();
        Naming.rebind("rmi://localhost:1099/ProyectoServidor", c);
        System.out.println("Servidor en funcionamiento: rmi://localhost:1099/ProyectoServidor");
    }
    catch (Exception e)
    {
      System.out.println("Trouble: " + e);
    }
  }

  public static void main(String args[]) throws MalformedURLException 
  {
    new Servidor();
    /* 
    try
    {
        System.out.println("Createing A RMI Server..");
        Q_empleado serverObject = new Q_empleado(); 
        System.out.println("Register created RMI Server.."); 
        Registry registerObj = LocateRegistry.getRegistry("localhost", 1099); 
        //The next statement will throw AlreadyBoundException, 
        //that will be caught by catch statement of class AlreadyBoundException 
        registerObj.bind("ProyectoServidor", serverObject); 
        System.out.println("Stub Registered, Server is ready..");
    } 
    catch(RemoteException e){ e.printStackTrace(); } 
    //catch(AlreadyBoundException e){ e.printStackTrace(); }
    */
  }
}
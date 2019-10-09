import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Q_empleado extends java.rmi.server.UnicastRemoteObject implements Operacion
{
    public Q_empleado() throws java.rmi.RemoteException
    {
        super();
    }
    
    public int totalempleados() throws java.rmi.RemoteException
    {
        try
        {
        String query = "select count(clave) as total from empleados";
        int existe=0;
        try{ 
            Connection conexion= Conexion.obtener_conexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(query);
            ResultSet filas = consulta.executeQuery();
            
            while(filas.next())
            {
                existe= filas.getInt("total");
            }
        }catch(Exception ex){}
        return existe;
        }
        catch (Exception e){return 0;}
    }
    
    public int totalnomina() throws java.rmi.RemoteException
    {
        try
        {
        String query = "select sum(dt*sd) as total from empleados";
        int existe=0;
        try{ 
            Connection conexion= Conexion.obtener_conexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(query);
            ResultSet filas = consulta.executeQuery();
            
            while(filas.next())
            {
                existe= filas.getInt("total");
            }
        }catch(Exception ex){}
        return existe;
        }
        catch (Exception e){return 0;}
    }
    
    public int insertar(int clave, String name, double sd, double dt, double total) throws java.rmi.RemoteException
    {
        try
        {
            Connection conexion= Conexion.obtener_conexion();
            String query = " insert into empleados (clave, name, sd, dt, total) "
                    + "values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt (1, clave);
            preparedStmt.setString (2, name);
            preparedStmt.setDouble (3, sd);
            preparedStmt.setDouble (4, dt);
            preparedStmt.setDouble (5, total);
            
            preparedStmt.execute();

            conexion.close();
            return 1;
        }
        catch (Exception e){return 0;}
    }
    
    public int eliminartodos() throws java.rmi.RemoteException
    {
        try{
            Connection conexion= Conexion.obtener_conexion();
            String query = "delete from empleados";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.execute();

            conexion.close();
            return 1;
        }
        catch(Exception ex)
        {
            return 0;
        }
    }
    
    public List buscar(int clave) throws java.rmi.RemoteException
    {
        List<Empleado> lista = new ArrayList<>();
        String query = "select * from empleados where clave="+clave;
        
        try{ 
            Connection conexion= Conexion.obtener_conexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(query);
            ResultSet filas = consulta.executeQuery();
            while(filas.next())
            {
                Empleado emp = new Empleado(
                        filas.getInt("clave"),
                        filas.getString("name"),
                        filas.getDouble("sd"),
                        filas.getDouble("dt"),
                        filas.getDouble("total")
                );
                lista.add(emp);
            }
        }catch(Exception ex){}
        return lista;
    }
    
    public int eliminar(int clave) throws java.rmi.RemoteException
    {
        try{
            Connection conexion= Conexion.obtener_conexion();
            String query = "delete from empleados where clave= ?";
            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setInt (1, clave);
            preparedStmt.execute();

            conexion.close();
            return 1;
        }
        catch(Exception ex)
        {
            return 0;
        }
    }
    
    public int actualizar(int clave, String name, double sd, double dt, double total) throws java.rmi.RemoteException
    {
        try
        {
            Connection conexion= Conexion.obtener_conexion();
            // the mysql insert statement
            String query = "update empleados set name=?, sd=?, dt=?, total=? where clave = ?";

            PreparedStatement preparedStmt = conexion.prepareStatement(query);
            preparedStmt.setString (1, name);
            preparedStmt.setDouble (2, sd);
            preparedStmt.setDouble (3, dt);
            preparedStmt.setDouble (4, total);
            preparedStmt.setInt (5, clave);
            // execute the preparedstatement
            preparedStmt.execute();

            conexion.close();
            return 1;
        }
        catch (Exception e){return 0;}
    }
    
    public List listar() throws java.rmi.RemoteException
    {
        List<Empleado> lista = new ArrayList<>();
        String query = "select * from empleados";
        
        try{ 
            Connection conexion= Conexion.obtener_conexion();
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(query);
            ResultSet filas = consulta.executeQuery();
            while(filas.next())
            {
                Empleado emp = new Empleado(
                        filas.getInt("clave"),
                        filas.getString("name"),
                        filas.getDouble("sd"),
                        filas.getDouble("dt"),
                        filas.getDouble("total")
                );
                lista.add(emp);
            }
        }catch(Exception ex){}
        return lista;
    }
}

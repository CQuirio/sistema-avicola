
import java.util.HashSet;
import java.util.Iterator;

public class ColeccionDeEmpresas {
    
    HashSet<Agricola> empresas = new HashSet<Agricola>();
    
    public void agregarEmpresa(Agricola empresa){
        empresas.add(empresa);
    }
    
    // solo busca el ruc  en el registo de empresas registradas
    public Agricola buscarEmpresa(String ruc){
        boolean encontrado = false;        
        Agricola empresa=null;
        Iterator<Agricola> iterador = empresas.iterator();
        while(iterador.hasNext() && encontrado == false){
            empresa = iterador.next();
            if(ruc.equalsIgnoreCase(empresa.getRuc())){
                encontrado = true;
            }
        }
        if(encontrado==false){
            empresa=null;
        }
        
        return empresa;
    }
    
    //busca empleados en el sistema pero no cuenta que esta en la empresa
    public Empleado buscarEmpleadoEnEmpresas(String codigo){
       boolean encontrado = false;        
       Agricola empresa=null;
       Empleado empleado=null;
       Iterator<Agricola> iterador = empresas.iterator();
       while(iterador.hasNext() && encontrado == false){
           empresa = iterador.next();
           empleado = empresa.buscarEmpleado(codigo);
           if(empleado!=null){
               encontrado = true;
           }
       }        
       return empleado;
       
    }
  
    
}

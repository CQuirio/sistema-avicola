
import java.util.HashSet;
import java.util.Iterator;


public class Agricola {
    //Atributos
    private String ruc;
    private String nombre;
    private String dirrecion;
    
    private HashSet<Trabajo> empleos = new HashSet<Trabajo>();
    
    private HashSet<Cliente> clientes = new HashSet<>();
    private Almacen almacen;
    
    
  
    //constructor
    public Agricola(String ruc, String nombre, String dirrecion) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.dirrecion = dirrecion;
        almacen = new Almacen();
    }
    
    //metodos get and set

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }
    public void asignarRecepcionistaAlmacen(Recepcionista recepcionista){
        almacen.setRegistrarRecepcionista(recepcionista);
    }
    //metodos
    public void contratarEmpleado(Empleado empleado, float sueldo){
        Trabajo trabajo = new Trabajo(this, empleado, sueldo);
        empleos.add(trabajo);
        System.out.println("empleado---"+empleado.getNombre());
    }
    
    public void eliminarEmpleado(){
        
    }
    
    public Empleado buscarEmpleado(String codigo){
        
        boolean band = false;
        Trabajo trabajo;
        Empleado empleado = null;
        
        Iterator<Trabajo> iterador = empleos.iterator();
        
        while(iterador.hasNext() && band == false){
            trabajo = iterador.next();
            empleado = trabajo.getEmpleado();
            System.out.println(empleado.getDni());
            if(codigo.equalsIgnoreCase(empleado.getDni())){
                band = true;
            }
        }
        
        if(band == false){
            empleado = null;
        }
        
        return empleado;
    }
    
    public void registrarCliente(Cliente c){
        clientes.add(c);
       
    }
    
    
    public Cliente buscarCliente(String dni){
        boolean band = false;
        Cliente cliente = null;
        Iterator<Cliente> iterador = clientes.iterator();
        while(iterador.hasNext() && band == false){
            cliente = iterador.next();
            if(dni.equals(cliente.getDni())){
                band = true;
            }
        }
        if(band == false){
            cliente = null;
        }
        
        return cliente;
        
    }
    //Mostrar todos  Empleados
    public String mostrarTodosEmpleados(){
        

        Trabajo trabajo;
        Empleado empleado = null;
        String datosEmpleados="";
        Iterator<Trabajo> iterador = empleos.iterator();
        
        while(iterador.hasNext()){
            trabajo = iterador.next();
            empleado = trabajo.getEmpleado();
             
            datosEmpleados += empleado.toString();
            
        }
       return datosEmpleados;
    }
    public void asignarProducto(Producto producto){
        this.almacen.setIngresarProducto(producto);
    }
    public void verProductos(){
        almacen.ver();
    }
    public boolean buscarProducto(String name){
        
        Producto producto = almacen.buscarProductos(name);
        return producto != null;
        
    }
    //buscar por cargo
    public Empleado buscarCargo(String cargo){
        
        boolean band = false;
        Trabajo trabajo;
        Empleado empleado = null;
        
        Iterator<Trabajo> iterador = empleos.iterator();
        
        while(iterador.hasNext() && band == false){
            trabajo = iterador.next();
            empleado = trabajo.getEmpleado();
            System.out.println(empleado.getDni());
            if(cargo.equalsIgnoreCase(empleado.getCargo())){
                band = true;
            }
        }
        
        if(band == false){
            empleado = null;
        }
        
        return empleado;
    }
}

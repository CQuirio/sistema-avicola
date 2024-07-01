
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Recepcionista extends Empleado{
    
    private HashSet<Boleta> boletas = new HashSet<Boleta>();
    private HashSet<Cliente> clientes = new HashSet<>();
     Almacen almacen;
    HashSet<Producto> productosDisponibles = new HashSet<Producto>();
    private Cajero cajero;
    String respuesta="";
    Scanner entrada = new Scanner(System.in);
    //constructor
    public Recepcionista(String nombre, int edad, String dni, int codigo, int añoExperiencia, String cargo) {
        super(nombre, edad, dni, codigo, añoExperiencia, cargo);
    }
    
    
    

    public void asignarALmacen(Almacen almacen){
        this.almacen = almacen;
    }
   public void asignarCajero(Cajero cajero){
       this.cajero = cajero;
       cajero.asignarRecepcionista(this);
   }
    public void boletasRealizadas(Boleta boletas){
        this.boletas.add(boletas);
        
    }
    public void consultarProducto(HashSet<String> producto){
        
        String name;
        name = JOptionPane.showInputDialog("ingrese el nombre del recepcionista que lo esta atendiendo");
        System.out.println("pidiendo nombre del recepcionista-- "+name+" en la clase recepcionista");
        
        almacen.buscarProducto(name,producto);
        
    }
    
    public void productosConsultados( Producto productos){
        //el ultmo valor es nulo por es sale error
      
                respuesta = "\nproducto: " + productos.getName() + 
                    "\nprecio: " + productos.getPrecio() + 
                    "\ncantidad: " + productos.getCantidad() + 
                        "\n---------------";
               // System.out.println(respuesta);
             
       productosDisponibles.add(productos);
       
       //if(termino==true){
           System.out.println(darRespuesta());
          // System.out.println("termino");
      // }
    }
    private String darRespuesta( ){ 
        return respuesta;
    }
    
    
 
    public void agregarProducto(){
        
    }
    
    private void eliminarAuciliar(){
        /*cuando se termine de generar la boleta se reinica la variable respuesta y productos 
                para la siguiente persona que desee comprar o tambien cuando responda que no 
        quiere comprar y se retire 
        entonces esta variable sera llamada por metodos conrrespondientes*/
    }
    public void generarBoleta(Cliente cliente){
        System.out.println("estamos generando una boleta en clase recepcionista \ncon el cliente "+cliente.getNombre());
        Producto producto;
        Iterator<Producto> iterador = this.productosDisponibles.iterator();
        //pedimos al cliente cuantos productos desea comprar 
        while(iterador.hasNext()){
            boolean aux= false;
            String resp="";
            int cantidad;
            producto = iterador.next();
            if(producto.getCantidad()>0){
                
            
            while(aux==false){
                    
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("null","cuantos productos desea de "+producto.getName()+" solo contamos con "+producto.getCantidad()));
                System.out.println("desea comprar--"+cantidad+"productos esta en la clase recepcionista");
                if(cantidad<=producto.getCantidad()&& cantidad>=0){
                    
                    aux=true;
                    //guardamos en producto la cantidad que ese cliente sea comprar
                    producto.setCantidadPedida(cantidad);
                    System.out.println("la cantidad es aceptada");
                    System.out.println(producto.getCantidad());
                    
                }else{
                   
                    resp = JOptionPane.showInputDialog("cantidad no aceptada desea compararlo");
                     
                    System.out.println("respuesta--"+resp+"-- esta en la clase recepcionista");
                    if("no".equals(resp)){
                        
                        aux=true;
                    }
                }
                
            }
            }
        }
        //% me parece que podemos crear una variable estatica y asignarle a cada boleta
        //%asi llevarianos un control 
        //creamos boleta y lo guardamos la referncia en el recepcionista que la creo
        
        
        int numeroBoleta = Integer.parseInt(JOptionPane.showInputDialog("numero de boleta"));
        String fecha = JOptionPane.showInputDialog("fecha");
        
        
        Boleta boleta =new Boleta(numeroBoleta,fecha, productosDisponibles, this,cliente);
        this.boletas.add(boleta);
        boleta.asignarCajero(cajero);
        System.out.println("total");
        boleta.toltalPagar();
        
        productosDisponibles.clear();
       
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    //metodos
    public void consultarProducto(){
        
    }
    
    public void darRespuesta(){
        
    }
    
    public void agregarProductos(){
        
    }
    
    public void generarBoleta(){
        
    }
    
    public void setBoleta(Boleta boleta){
        boletas.add(boleta);
        boleta.setRecepcionista(this);
    }
    
    public void eliminarBoleta(){
        
    }
    
    public void modificarBoleta(){
        
    }
    
    public void realizarInforme(){
        
    }
    
    public void setCliente(Cliente c){
        clientes.add(c);
    }
    
    public void consultarAlmacen(HashSet<String> lista, Almacen almacen){
        
        
        
        
        
        
        
        
    }*/
    
}

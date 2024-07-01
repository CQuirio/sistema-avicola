
import java.util.HashSet;
import java.util.Iterator;


public class Boleta {
    //Atributos
    private int numBoleta;
    private String fecha;
    private Cajero cajero;
    private float dineroTotal;
    private  boolean estado = false;
    private HashSet<Producto> productos = new HashSet<Producto>();
    private Recepcionista recepcionista;
    private Cliente cliente;
    
    //constructor
    
    
    
    
    public Boleta(int numBoleta, String fecha,HashSet<Producto> producto, Recepcionista recepcionista,Cliente cliente) {
        this.numBoleta = numBoleta;
        this.fecha = fecha;
        this.productos = producto;
        this.recepcionista = recepcionista;
        this.cliente = cliente;
    }
    public void asignarCajero(Cajero cajero){
        this.cajero=cajero;
    }
    public void toltalPagar(){
        
        Producto producto;
        System.out.println("ingreso a total");
        Iterator<Producto> iterador = productos.iterator();
        
        while(iterador.hasNext()){
             producto = iterador.next();
             System.out.println("ingreso al while de total");
             System.out.println(producto.getName());
             System.out.println(producto.getPrecio());
            dineroTotal += producto.getPrecio()* producto.cantidadPedida();
        }
        
        
        System.out.println(dineroTotal);
        cliente.entregarBoleta(this);
        
    }
    public void estadoBoleta(boolean estado){
        this.estado=estado;
        if(estado=true){
         Producto producto;
         Iterator<Producto> iterador =  this.productos.iterator();
         while( iterador.hasNext()){
             producto = iterador.next();
             producto.eliminarPruducto();
         }
           
            
        }
        
    }
    public void pagarBoleta(){
        //ingresar el nombre del cajero
        /*Cajero cajero= new Cajero("jose", 20,"7684759",1234,3,"cajero");
        asignarCajero(cajero);*/
        cajero.cobrar(this);
    }

    public float getDineroTotal() {
        return dineroTotal;
    }
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //metodos get and set
    public int getNumBoleta() {
        return numBoleta;
    }
    
    public void setRecepcionista(Recepcionista r){
        this.recepcionista = r;
    }
    
    public void setCliente(Cliente c){
        this.cliente = c;
    }

    public void setNumBoleta(int numBoleta) {
        this.numBoleta = numBoleta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}


public class Producto {
    //Atributos
    private String id;
    private String descrip;
    private String name;
    private float precio;
    
    private Almacen almacen;
    private Boleta boleta;
    private String descripcion;

    private int cantidad;
    private int cantidadPedida=0;
    
    
    //Constructor
    public Producto(String id, String name, float precio) {
        this.id = id;
        this.name = name;
        this.precio = precio;
    }
    
    
    public Producto(String id, String descripcion, String name, float precio, int cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.name = name;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public void setAgregarCantidad(int cantidad){
        
        this.cantidad += cantidad; 
    }
    public void asignarProductos(Almacen almacen){
        this.almacen = almacen;
        
    }
    // se ingresa la cantidad de productos que desea el cliente 
    public void setCantidadPedida(int cantidadPedida){
        this.cantidadPedida = cantidadPedida;
    }
   //sera llamada si la compra fue exitosa
    public void eliminarPruducto(){
        this.cantidad -= cantidadPedida;
        
    }
    //sera llamada para multiplicarlo por el precio y se almacenara en la bolera
    
    
   
    
    
    
    
    
    
    public int cantidadPedida(){
        return cantidadPedida;
    }
    public int getCantidad() {
        return cantidad;
    }
    
    
    
    
    //metodos get and set
    public String getId() {
        return id;
    }

   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getName() {
        return name;
    }

    

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

   
    public String toString() {
        return "Producto{" + ""
                + "\nId: " + id + ""
                + "\nName: " + name + ""
                + "\nPrecio: " + precio + '}';
    }
}
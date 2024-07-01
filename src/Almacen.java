
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Almacen {
    //atributos
    private int numProduc;
    private int numeroProductos;
   
    private String descrip;
    
    private HashSet<Producto> productos = new HashSet<>();
    HashSet<Recepcionista> recepcionista = new HashSet<Recepcionista>();
    //constructor
    public Almacen(int numProduc, String descrip) {
        this.numProduc = numProduc;
        this.descrip = descrip;
    }
    
   
    public Almacen() {
    }

    public Almacen(int numeroProductos) {
        this.numeroProductos = numeroProductos;
      
    }
    
    public void setIngresarProducto(Producto producto){
        /////si producto ya esta en el almacen solo sumar los nuevo en el caso que no agregar como nuevo producto 
        Producto aux=null;
        boolean encontrado=false;
        Iterator<Producto> iterador = this.productos.iterator();
        while(iterador.hasNext() && encontrado==false){
            aux = iterador.next();
            
            if(producto.getName().equalsIgnoreCase(aux.getName())){
                
                encontrado = true;
            }
            
        }
        if(encontrado == true){
            System.out.println("*******"+producto.getCantidad());
            aux.setAgregarCantidad(producto.getCantidad());
        }else{
            this.productos.add(producto);
            producto.asignarProductos(this);
        }
        
            
        System.out.println("llego al almacen el producto "+producto.getName());
        
        
    }
    
    public void setRegistrarRecepcionista(Recepcionista recepcionista){
        this.recepcionista.add(recepcionista);
        recepcionista.asignarALmacen(this);
        System.out.println(recepcionista.getNombre());////////////////////////////////////////////////
        Iterator<Recepcionista> iterador = this.recepcionista.iterator();/////
       Recepcionista  recep=iterador.next();///
        System.out.println(recep.getDni());////
    }
    public void ver(){
        
        Producto var;
        Iterator<Producto> interador = productos.iterator();
        while(interador.hasNext()){
            System.out.println("llego aver");
            var = interador.next();
                System.out.println(var.getName());
                System.out.println(var.getCantidad());
                
            
        }
    }
    public Recepcionista comprobarRecepcionista(String name){
        Recepcionista recep=null;
        System.out.println("llego a comprobarRecepcionista y esta buscando a "+name);
        Iterator<Recepcionista> iterador = this.recepcionista.iterator();
        
        boolean encontrado = false;
        
        while(iterador.hasNext()&&encontrado==false){
            recep = iterador.next();
            
            if(name.equalsIgnoreCase(recep.getNombre())){
                System.out.println("lo encontro");
                encontrado = true;
                return recep;
            }
        }
        System.out.println("no lo llego a encontrar");
        return null;
    }
   public void eliminarPructos(){
       
   }
   public void buscarProducto(String name, HashSet<String> producto ){
  
       //llama al metodo comprobarRecepcionista para comprobar si el recepcionista es parte de la empresa 
       System.out.println("llego a buscar Producto pero pasara primero ha buscar el recepcionista");
       if(comprobarRecepcionista(name)!=null){
           
           Recepcionista repta =comprobarRecepcionista(name);
        
           String varPro;
           Iterator<String> iterador = producto.iterator();
       //buscara el producto de la lista 
        while(iterador.hasNext() ){//mientras la lista de productos que envio el recepcionista no acabe
            varPro = iterador.next();
           
            //busqueda en todos los productos del almacen
            Producto varPro2;
        Iterator<Producto> iteradorPro = this.productos.iterator();
        boolean encontrado = false;
        while(iteradorPro.hasNext() && encontrado==false){
            varPro2 = iteradorPro.next();
            
            
            if(varPro.equalsIgnoreCase(varPro2.getName())){
                repta.productosConsultados(varPro2);
                encontrado=true;
            }
        }   
        }   
         
            
           
       }else{
           JOptionPane.showMessageDialog(null,"el empreado no forma parte de esta empresa");
       }
    
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //metodos get and set
    public int getNumProduc() {
        return numProduc;
    }

    public void setNumProduc(int numProduc) {
        this.numProduc = numProduc;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    
    
    public Producto buscarProductos(String name){
        Producto p = null;
        boolean encontrado = false;
        Iterator<Producto> iterador = productos.iterator();
        
        while(iterador.hasNext() && encontrado == false){
            p = iterador.next();
            
            if(p.getName().equals(name)){
                encontrado = true;
            }
        }
        if(encontrado == false){
            p = null;
        }
        return p;
    }
    
}

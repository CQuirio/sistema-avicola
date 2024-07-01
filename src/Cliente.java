
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Cliente extends Persona{
    
    //Atributos
    private String telefonoContacto;
   
    private HashSet<Boleta> boletas = new HashSet<>();
    private HashSet<Recepcionista> recepcionistas = new HashSet<>();
    Scanner entrada = new Scanner(System.in);

    //metodo constructor
    
    public Cliente(){
       
    }

    public Cliente(String nombre, int edad, String dni, String telefonoContacto) {
        super(nombre, edad, dni);
        this.telefonoContacto = telefonoContacto;
    }
    
    //methodos get and set

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    
    
    public void consultarProducto(Recepcionista recepcionista,HashSet<String> producto){//lista de producto
        
        recepcionista.consultarProducto( producto);
        // desea comparar? si es si entonces llamara a la variable comprar 
        //System.out.println("esta en consultar producto de regreso");
        
        String varaxu = JOptionPane.showInputDialog("desea comparar el producto");
        System.out.println("respuesta de decea comprar en clase cliente"+varaxu);
        if("si".equalsIgnoreCase(varaxu)){
            comprar(recepcionista);
        }else{
            JOptionPane.showMessageDialog(null,"GRACIAS POR VENIR A ESTA TIENDA");
        }
        
    }
    public void comprar(Recepcionista recepcionista){
        //System.out.println("ingreso a comprar el cliente ");
        System.out.println("comprando productos en clase cliente");
        recepcionista.generarBoleta(this);
        recepcionistas.add(recepcionista);
        
    }
    public void entregarBoleta(Boleta boleta){
        boleta.pagarBoleta();
        this.boletas.add(boleta);
        
    }
    

    
    
    /*
    
    

    
    
    
    */
    //metodos
   
   
    
    
    
    
    
    
    
    
    
    
  /*  public void setBoletas(Boleta b){
        boletas.add(b);
        b.setCliente(this);
    }
    */
    
    
    
    
    
    
    
    
    
    
    
    
  /*  public void consultarProducto(Recepcionista recepcionista,HashSet<String> producto){//lista de producto
        
        //recepcionista.consultarProducto( producto);
        // desea comparar? si es si entonces llamara a la variable comprar 
        //System.out.println("esta en consultar producto de regreso");
        //comprar(recepcionista);
    }
    */

    

  /*  public void realizarCompra(){
        System.out.println("Soy el cliente y quiero hacer la compra");
    }*/
    
}

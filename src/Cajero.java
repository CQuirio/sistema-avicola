
import java.util.HashSet;
import java.util.Scanner;


public class Cajero extends Empleado{
    
   
    
    //constructor
  Scanner entrada = new Scanner(System.in); 
   HashSet<Boleta> boletas = new HashSet<Boleta>();
   HashSet<Recepcionista> recepcionistas = new HashSet<Recepcionista>();
   
   public Cajero(String nombre, int edad, String dni, int codigo, int añoExperiencia,String cargo) {
        super(nombre, edad, dni, codigo, añoExperiencia, cargo);
    }
    
   public void asignarRecepcionista(Recepcionista recepcionista){
       this.recepcionistas.add(recepcionista);
   }
    public void cobrar(Boleta boleta){
        
        boolean pago=false;
        this.boletas.add(boleta);
        do{
        System.out.println("el total a pagar es "+boleta.getDineroTotal());
        System.out.println("ingrese el dinero: ");
        float dinero = entrada.nextFloat();
        if(dinero>=boleta.getDineroTotal()){
            
            System.out.println("pago competado ");
            
            if((dinero-boleta.getDineroTotal())>0){
                System.out.println("su vuelto es de "+(dinero-boleta.getDineroTotal()));
            }
            boleta.estadoBoleta(true);
            pago=true;
        }else{
            System.out.println("cantidad insuficiente para concretar el pago ");
           //// creo que falta agregar un metodo para que cansele el pago
            
        }
            
           }while(pago==false);
    }
    public void realizarReporte(){
        
    }
    
    public void pedirInforme(){
        
    }
    
    
    
    
}

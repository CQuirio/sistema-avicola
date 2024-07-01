
import java.util.HashSet;


public class Empleado extends Persona{
    
    //Atributos
    protected int codigo;
    protected int añoExperiencia;
    protected String cargo;
    
    private HashSet<Trabajo> trabajos = new HashSet<Trabajo>(); 
    
    //constructor
    public Empleado(String nombre, int edad, String dni, int codigo, int añoExperiencia,String cargo) {
        super(nombre, edad, dni);
        this.codigo = codigo;
        this.añoExperiencia = añoExperiencia;
        this.cargo = cargo;
    }
    
    //metodos get and set
    
    public void setTrabajo(Trabajo trabajo){
        trabajos.add(trabajo);
    }

    public int getCodigo() {
        return codigo;
    }

    public String toString() {
        return "\nEmpleado{" + ""
                + "\nNombre: " + this.nombre + ""
                + "\nCodigo: " + codigo + ""
                + "\nCargo: " + cargo + "";
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



    public int getAñoExperiencia() {
        return añoExperiencia;
    }

    public void setAñoExperiencia(int añoExperiencia) {
        this.añoExperiencia = añoExperiencia;
    }
    public String getDni(){
        return super.dni;
    }
    public String getCargo(){
        return cargo;
    }
    
}

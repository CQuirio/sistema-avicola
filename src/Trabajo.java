
public class Trabajo {
    private float sueldo;
    
    private Agricola agricola;
    private Empleado empleado;

    public Trabajo(Agricola agricola, Empleado empleado,float sueldo) {
        this.sueldo = sueldo;
        this.agricola = agricola;
        this.empleado = empleado;
        
        empleado.setTrabajo(this);
        System.out.println("-------0"+this.agricola.getNombre());
    }

    public Agricola getAgricola() {
        return agricola;
    }

    public void setAgricola(Agricola agricola) {
        this.agricola = agricola;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
   
    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
}

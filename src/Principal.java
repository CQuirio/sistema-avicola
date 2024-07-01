
import java.util.HashSet;
import javax.swing.JOptionPane;


public class Principal {
    
    public static void main(String []args){
        
          
        //Manejo del Agricola crear el Agricola
       // Agricola agro = new Agricola("123456789","Agro Dorado","Pacanga");
        
       // Almacen almacen = new Almacen(5,"Almacen Tienda Agricola");
       // creamos coleccion de empresas
         ColeccionDeEmpresas colEmpresas = new ColeccionDeEmpresas();
      
        String menu =
                  "1) Agregar Empresa" 
                +"\n2) Registrar Empleados"
                + "\n3) Buscar Empleado"
                + "\n4) Almacenar Productos Almacen"
                + "\n5) Registrar Venta"
                + "\n6) Reporte de Empleados"
                + "\n9: Salir";
    
        int opcion = 0;
        Agricola empresa;
        Empleado empleado ;
        String ruc;
        String denominacion;
        String direccion;
        //datos de una persona 
        String dni;
         int codigo; 
       
        
           /* Producto pro1 = new Producto("451","aa","urea",14.5f, 9);
        Producto pro2 = new Producto("451","aa","carro",12.4f, 1);
        Producto pro3 = new Producto("451","aa","potacio",9.5f, 6);
        Producto pro4 = new Producto("451","aa","nuck",1.2f, 4);
        Producto pro5 = new Producto("451","aa","aaa",14.5f, 2);
        Producto pro6 = new Producto("451","aa","fosfato",96.6f, 0);
        Recepcionista recepcionista = new Recepcionista("jose", 20,"1452", 5,3,"Recepcionista");
        Recepcionista recepcionista1 = new Recepcionista("luis", 20,"1452",  4,3,"Recepcionista");
       
     
        almacen.setRegistrarRecepcionista(recepcionista);
        almacen.setRegistrarRecepcionista(recepcionista1);
        
        almacen.setIngresarProducto(pro1);
        almacen.setIngresarProducto(pro2);
        almacen.setIngresarProducto(pro3);
        almacen.setIngresarProducto(pro4);
        almacen.setIngresarProducto(pro5);
        almacen.setIngresarProducto(pro6);*/
        while(opcion != 9){
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                
                //agregar empresa
                
                case 1: 
                        ruc = (JOptionPane.showInputDialog("Ingrese el ruc"));
                        empresa = colEmpresas.buscarEmpresa(ruc);
                        // creamos agricola
                        if(empresa == null){
                            denominacion = JOptionPane.showInputDialog("Nombre de la agricola");
                             direccion = JOptionPane.showInputDialog("direccion de la agricola");
                           
                            empresa = new Agricola(ruc, denominacion,direccion);
                            colEmpresas.agregarEmpresa(empresa);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "La empresa con ruc "+ruc+" ya está registrada");
                        }                        
                        break;
                case 2:
     

                //comtratar empleados
                    String nombre;
                    float sueldo;
        
                    int edad; 
                    
                    int añoExperiencia; 
                    String cargo;
                    ruc =(JOptionPane.showInputDialog("Ingrese el ruc"));
                    //busca en la coleccion de emopresas 
                     empresa = colEmpresas.buscarEmpresa(ruc);
                        //si encuentra a la empresa abre la empresa y comienza a contratar empleados 
                        if(empresa != null){
                            dni =(JOptionPane.showInputDialog("Ingrese el dni"));
                            empleado = colEmpresas.buscarEmpleadoEnEmpresas(dni);
                 //si no tiene registrado ninguna con ese nombre entonces contratara nuevo empleado
                           
                            if(empleado==null){
                       

                    nombre = JOptionPane.showInputDialog(null,"Nombre: ","Datos Empleado",JOptionPane.DEFAULT_OPTION);
                    edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Edad: ","Datos Empleado",JOptionPane.DEFAULT_OPTION));
                    //dni = JOptionPane.showInputDialog(null,"DNI: ","Datos Empleados",JOptionPane.DEFAULT_OPTION);
                    codigo = Integer.parseInt(JOptionPane.showInputDialog(null,"Codigo","Datos Empleados",JOptionPane.DEFAULT_OPTION));
                    cargo = JOptionPane.showInputDialog(null,"Ingrese Cargo: ","Datos Empleados",JOptionPane.DEFAULT_OPTION);
                    
                    cargo = cargo.toUpperCase();
                    switch (cargo) {
                        case "GERENTE":
                            añoExperiencia = Integer.parseInt(JOptionPane.showInputDialog("Años de experiencia"));
                            empleado = new Cajero(nombre, edad, dni, codigo, añoExperiencia, cargo);
                            empresa.contratarEmpleado(empleado,2000.0f);
                            
                            
                            break;
                        case "RECEPCIONISTA":
                            añoExperiencia = Integer.parseInt(JOptionPane.showInputDialog("Años de experiencia"));
                            
                            empleado = new Recepcionista(nombre, edad, dni, codigo, añoExperiencia, cargo);
                            empresa.contratarEmpleado(empleado,1000.0f);
                            empresa.asignarRecepcionistaAlmacen((Recepcionista)empleado);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Cargo No disponible");
                            break;  
                            }
                            // en el caso que ya lo tenga solo se le asignara el sueldo 
                            
                        }
                        else{
                                sueldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el sueldo"));
                                empresa.contratarEmpleado(empleado, sueldo);
                            }
                            }
                        else{
                            JOptionPane.showMessageDialog(null, "La empresa con ruc "+ruc+" no está registrada");
                        }                    
                    
                    break;
                case 3:
                    
                    ruc = (JOptionPane.showInputDialog("Ingrese el ruc"));
                        empresa = colEmpresas.buscarEmpresa(ruc);
                        if(empresa!=null){
                            dni =(JOptionPane.showInputDialog(null,"Ingrese Codigo","Buscado Empleado",JOptionPane.DEFAULT_OPTION));
                            System.out.println(dni);
                            System.out.println(empresa.getNombre());
                            Empleado em = empresa.buscarEmpleado(dni);
                            
                            System.out.println(em.getNombre());
           
                        }
                    
                    
                    break; 
                    
                case 4:
                    ruc =(JOptionPane.showInputDialog("Ingrese el ruc"));
                    //busca en la coleccion de emopresas 
                     empresa = colEmpresas.buscarEmpresa(ruc);
                     if(empresa !=null){
                         empresa.verProductos();
                         Producto p;
                         
                    //Almacenar Productos Almacen
                    //Ingresar los datos de los productos
                    String id;
                    String name;
                    String descripcion;
                    float precio;
                    int cantidad;
                    
                    name = JOptionPane.showInputDialog("Nombre: ");
                    if(empresa.buscarProducto(name)){
                        cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad "));
                         p = new Producto("","",name,0.0f,cantidad);
                    }else{
                        id = (JOptionPane.showInputDialog("Id: "));
                        precio = Float.parseFloat(JOptionPane.showInputDialog("Precio: "));
                        descripcion = JOptionPane.showInputDialog("dijite una descripcion");
                         cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad "));
                         p = new Producto("","",name,precio,cantidad);
                 
                    }
                    empresa.asignarProducto(p);
                    empresa.verProductos();
                     }else{
                         
                         JOptionPane.showMessageDialog(null,"empresa no encontrada");
                     }
                    
                    break;
                    
                case 5: 
                    //Registrar Venta
                    //El cliente va a preguntar por Productos
                    
                    String nameCliente;
                    int edadCliente;
                    String dniCliente;
                    String telefonoCliente;
                    String resp="si";
                    ruc = (JOptionPane.showInputDialog("Ingrese el ruc"));
                        empresa = colEmpresas.buscarEmpresa(ruc);
                        if(empresa!=null){
                            Cajero cajero;
                            //buscamos a un cajero por el cargo en la empresa
                            cajero =(Cajero) empresa.buscarCargo("CAJERO");
                            
                            if(cajero!=null){//si la empresa tiene un cajero entonces podra atender 
                                dni =(JOptionPane.showInputDialog(null,"Ingrese Codigo","Buscado Empleado",JOptionPane.DEFAULT_OPTION));
                            System.out.println(dni);
                            System.out.println(empresa.getNombre());
                            Empleado em = empresa.buscarEmpleado(dni);
                            if(em!=null&& ("RECEPCIONISTA".equalsIgnoreCase(em.getCargo()))){
                                //asigno al recepcionista un cajero
                                ((Recepcionista)em).asignarCajero(cajero);
                                nameCliente = JOptionPane.showInputDialog("ingrese su nombre");
                             edadCliente = Integer.parseInt(JOptionPane.showInputDialog("dijite su edad"));
                             dniCliente = JOptionPane.showInputDialog("dijite su dni");
                            telefonoCliente = JOptionPane.showInputDialog("dijite su numero teledonico");
                            Cliente c = new Cliente(nameCliente, edadCliente, dniCliente, telefonoCliente);
              
                            HashSet<String> lista = new HashSet<String>();
                             while(!"no".equalsIgnoreCase(resp)){
                             lista.add(JOptionPane.showInputDialog("ingrese el producto"));
                             resp = JOptionPane.showInputDialog("desea consultar otro producto");
                   
                    
                    
                                 }
                             
                             c.consultarProducto((Recepcionista)em,lista);
                        }else{
                            JOptionPane.showMessageDialog(null,"no se encontro al recepcionista en esta tienda la tienda");
                        }
                            }else{
                                JOptionPane.showMessageDialog(null,"no se esta atendiendo -el cajero salio-");
                            }
                            
                            }else{
                            JOptionPane.showMessageDialog(null,"empresa no encontrada");
                        }
                            
                        
                        
                    
                   
                    break; 
                    
                    
                    
                    
                case 9:   
                    System.exit(0);
                    break;
            }
            
    
        }
        
    }

}


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Main {
    
    public static void main(String[] args){
        
        ArrayList<Empleado> empleados = new ArrayList<>();
        
        Empleado empleado = new Empleado(1);
        Empleado pepa = new Empleado("Pepa", 3);
        
        empleados.add(empleado);
        empleados.add(pepa);
        
        Empresa pdoosa = new Empresa("PDOOSA", 5000);
        
        pdoosa.setPresidente(empleados.get(1));
        
        pdoosa.anadirDepartamento("Informática", 1000);
        pdoosa.anadirDepartamento("Personal", 2000);
        pdoosa.anadirDepartamento("Marketing", 3000);
        
        System.out.println("Capital del Departamento 'Personal': " + pdoosa.getDepartamento("Personal").getCapital());
        
        Empresa otra = new Empresa("");
        otra.copia(pdoosa);
        
        otra.setPresidente(empleado);
        
        System.out.println("Nombre del presidente: " + otra.getPresidente().getNombre());
        System.out.println("Gastos de personal: " + otra.gastosPersonal());
        
        System.out.println(otra.informacion());
        
    }
    
}


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Empresa {
    
    private static int MAX_DEPARTAMENTOS = 10;
    
    private String nombre;
    private double capital;
    
    private ArrayList<Departamento> departamentos;
    
    private Empleado presidente;
    
    public Empresa(String nombre, double capital){
        
        this.nombre = nombre;
        this.setCapital(capital);
        
        this.departamentos = new ArrayList<>();
        
    }
    
    public Empresa(String nombre){
        this(nombre, 3000);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public double getCapital(){
        return this.capital;
    }
    
    public void setCapital(double capital){
        
        if(capital < 3000) System.out.println("Capital no correcto: Establecido a 3000.");
        this.capital = (capital >= 3000) ? capital : 3000;
    
    }
    
    public ArrayList<Departamento> getDepartamentos(){
        return this.departamentos;
    }
    
    public Empleado getPresidente(){
        return this.presidente;
    }
    
    public void setPresidente(Empleado empleado){
        
        if(empleado.getAntiguedad() < 2){
            System.out.println("No puede ser presidente: El empleado no tiene al menos 2 años de antigüedad.");
            return;
        }
        
        this.presidente = empleado;
        
    }
    
    public void copia(Empresa otra){
        
        this.nombre = otra.nombre;
        this.capital = otra.capital;
        
        this.departamentos.clear();
        
        for(Departamento departamento : otra.departamentos)
            this.departamentos.add(new Departamento(departamento.getNombre(), departamento.getCapital()));
            
        this.presidente = otra.presidente;
        
    }
    
    public void anadirDepartamento(String nombre, double capital){
        
        if(capital > this.capital || this.departamentos.size() + 1 > Empresa.MAX_DEPARTAMENTOS){
            System.out.println("No se puede añadir el departamento.");
            return;
        }
        
        this.departamentos.add(new Departamento(nombre, capital));
        
    }
    
    public Departamento getDepartamento(String nombre){
        
        for(Departamento departamento : this.departamentos)
            if(departamento.getNombre().equals(nombre))
                return departamento;
        
        System.out.println("Departamento " + nombre + " no encontrado.");
        return null;
        
    }
    
    public double gastosPersonal(){
        
        double resultado = 0.0;
        
        for(Departamento departamento : this.departamentos)
            resultado += departamento.getCapital();
        
        return resultado;
        
    }
    
    public String informacion(){
        
        Empleado presidente = this.getPresidente();
        
        String nombreP = presidente.getNombre();
        
        String cadena = "El presidente de la empresa se llama " + nombreP + " y los departamentos son";
        
        ArrayList<Departamento> departamentos = this.getDepartamentos();
        
        for(Departamento departamento : departamentos){
            
            String nombreD = departamento.getNombre();
            cadena += " " + nombreD;
            
        }
        
        return cadena;
        
    }
    
}

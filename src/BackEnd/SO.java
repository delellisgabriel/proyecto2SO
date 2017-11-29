/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class SO {   
    private ArrayList<proceso> listaProcesos;
    private ram RAM;
    private disco disco;
    private int cantMarcos;

    public SO() {
       listaProcesos = new ArrayList<proceso>();
       RAM = new ram(cantMarcos);
       disco = new disco();  //aqui quedamos 
    }
    

    public void setCantMarcos(int numero) {
        this.cantMarcos = numero;
    }
    
}

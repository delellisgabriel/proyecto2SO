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
public class ram {
    private ArrayList<marco> listaMarcos;

    public ram(int cantMarcos) {
        listaMarcos = new ArrayList<marco>();
        for(int i = cantMarcos; i >0; i-- ){
            listaMarcos.add(new marco(cantMarcos-i));
        }
    }
    
    
}

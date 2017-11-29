/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.ArrayList;

/**  a 3 i 3    0
 *   a 3 i 2    1
 *   a 3 i 1    2
 *  
 *
 * @author Administrador
 */
public class proceso {
    private ArrayList<pagina> listaDePaginas;
    private boolean enEjecucion;

    public proceso(int a) {
        enEjecucion = false;
        for(int i = a; i > 0; i--){
            listaDePaginas.add(new pagina(a-i));
        }
    }

    public void setListaDePaginas(ArrayList<pagina> listaDePaginas) {
        this.listaDePaginas = listaDePaginas;
    }

    public void setEnEjecucion(boolean enEjecucion) {
        this.enEjecucion = enEjecucion;
    }

    public ArrayList<pagina> getListaDePaginas() {
        return listaDePaginas;
    }

    public boolean isEnEjecucion() {
        return enEjecucion;
    }
    
}


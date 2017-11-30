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

    private int ubicadorProcesos;
    private ArrayList<proceso> listaProcesos;
    private ram RAM;
    private disco disco;
    private int cantMarcos; //leido por popup

    public SO(int num) {
        ubicadorProcesos = 0;
        listaProcesos = new ArrayList<>();
        RAM = new ram(num);
        disco = new disco();
    }

    public void createProcess(int paginas) {
        proceso proceso = new proceso(paginas, ubicadorProcesos);
        listaProcesos.add(proceso);
        ubicadorProcesos = ubicadorProcesos + 1;
        for (int i = paginas; i > 0; i--) {
            if (RAM.isFull()) {
                disco.getListaPaginas().add(proceso.getListaDePaginas().get(paginas - i));
            } else {
                for (int j = RAM.getCantMarcos(); j > 0; j--) {
                    if (RAM.getListaMarcos().get(RAM.getCantMarcos() - j).getPagProceso() == null) {
                        RAM.getListaMarcos().get(RAM.getCantMarcos() - j).setPagProceso(proceso.getListaDePaginas().get(paginas - i));
                        j = 0; //salida
                    }
                }
            }
        }
    }

    public int[] datosProceso(int numProceso) {
        proceso proceso = listaProcesos.get(numProceso);
        int[] datos = new int[4];
        datos[0] = proceso.getListaDePaginas().size(); // Total de paginas
        int tamanoRAM = RAM.getListaMarcos().size();
        datos[1] = 0; // paginas en RAM
        for (int i = tamanoRAM; i > 0; i--) {
            if (RAM.getListaMarcos().get(tamanoRAM - i).getPagProceso() != null) {
                if (RAM.getListaMarcos().get(tamanoRAM - i).getPagProceso().getNumeroProceso() == numProceso) {
                    datos[1]++;
                }
            }
        }//Paginas en Memoria Principal
        int tamanoDisco = disco.getListaPaginas().size();
        datos[2] = 0;
        for (int i = tamanoDisco; i > 0; i--) {
            if (disco.getListaPaginas().get(tamanoDisco - i).getNumeroProceso() == numProceso) {
                datos[2]++;
            }
        } //Paginas en Memoria Virttual
        if (proceso.isEnEjecucion()) {
            datos[3] = 1;
        } else {
            datos[3] = 0;
        } //Estado del proceso
        return datos;
    }

    public void terminateProcess(int selected) {
        int tamanoRAM = RAM.getListaMarcos().size();
        for (int i = tamanoRAM; i > 0; i--) {
            if (RAM.getListaMarcos().get(i - 1).getPagProceso() != null) {
                if (RAM.getListaMarcos().get(i - 1).getPagProceso().getNumeroProceso() == selected) {
                    RAM.getListaMarcos().get(i-1).setPagProceso(null);
                }
            }
        }//Paginas en Memoria Principal
        int tamanoDisco = disco.getListaPaginas().size();
        for (int i = tamanoDisco; i > 0; i--) {
            if (disco.getListaPaginas().get(i - 1).getNumeroProceso() == selected) {
                disco.getListaPaginas().remove(i - 1);
            }
        }
        listaProcesos.set(selected, null);
    }

    public void setCantMarcos(int numero) {
        this.cantMarcos = numero;
    }

    public ArrayList<proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public ram getRAM() {
        return RAM;
    }

    public void setRAM(ram RAM) {
        this.RAM = RAM;
    }

    public disco getDisco() {
        return disco;
    }

    public void setDisco(disco disco) {
        this.disco = disco;
    }

    public int getUbicadorProcesos() {
        return ubicadorProcesos;
    }

    public void setUbicadorProcesos(int ubicadorProcesos) {
        this.ubicadorProcesos = ubicadorProcesos;
    }

}

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
        ubicadorProcesos++;
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

package com.mycompany.progettoclash;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lorenzo
 */
public class Accampamento extends Edificio {
    
    private ArrayList<Eroe> listaEroiGiocatore = new ArrayList<Eroe>();

    public ArrayList<Eroe> getListaEroiGiocatore() {
        return listaEroiGiocatore;
    }

    public void setListaEroiGiocatore(ArrayList<Eroe> listaEroiGiocatore) {
        this.listaEroiGiocatore = listaEroiGiocatore;
    }
    
    
    public Accampamento( ModalitàAttacco ma) {
        super(ma);
    }
    
    public ArrayList<Eroe> selezionaEroe(int idEroe,int quantita){
            //controllo su quando l'utente ha immesso tutti gli eroi
        ArrayList<Eroe> listaEroi = new ArrayList<Eroe>();
        boolean var=this.controllaQuantitaIdEroe(idEroe, quantita);
        if(var==true){
            int cont=0;
            int i=0;
            while(i<this.listaEroiGiocatore.size() && cont<quantita){
                if(this.listaEroiGiocatore.get(i).getId()==idEroe){
                    cont++;
                    listaEroi.add(this.listaEroiGiocatore.get(i));
                    this.listaEroiGiocatore.remove(i);
                }
                else{
                    i++;
                }             
            }
            return listaEroi;
        }
        else{
            return null;
        }
    }
    
    public boolean controllaQuantitaIdEroe(int idEroe,int quantita){
        int cont=0;
        boolean idEroeTrovato=false;
        for(int i=0;i<this.listaEroiGiocatore.size();i++){
            if(this.listaEroiGiocatore.get(i).getId()==idEroe){
                idEroeTrovato=true;
                cont++;
                if(cont==quantita){
                    return true;
                }
            }    
        }
        if(cont==quantita && idEroeTrovato==true){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public void acquistaEroi(int idEroeDescrizione,int quantita,Giocatore giocatore){
        EroeCatalogo edC=new EroeCatalogo();
        EroeDescrizione desc=edC.getEroeDescrizione(idEroeDescrizione);
        PotenziamentoStrategy strategyEroe=null;
        try {
            strategyEroe = PotenziamentoFactory.getInstance().getStrategy();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Accademia.class.getName()).log(Level.SEVERE, null, ex);
        }
        strategyEroe.potenziaEroe(desc,quantita,giocatore);//cambia NOME METODO
                
        
    }
 
}

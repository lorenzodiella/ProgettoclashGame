/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class ControlloFineBattaglia implements StatoAttacco{

    @Override
    public boolean controlloFineBattaglia(ClashGame clash) {
        
        boolean edificiMorti=true;
        boolean eroiMorti=true;       
        ArrayList<Casella> caselle=clash.getGiocatoreD().getVillaggio().getCaselle();
        for (int i=0;i<caselle.size();i++){
            Casella c=caselle.get(i);
            Edificio edificio=c.getEdificio();
            if(edificio!=null){
                if(c.getEdificio().getStatistica().getVita()>0){//controllo se la vita degli edifici è uguale a 0
                    edificiMorti=false;
                }
            }
            
            if(c.getListaEroiA().size()>0){//controllo se gli eroi sono morti tutti
                eroiMorti=false;
            }
        }
        if(eroiMorti){
            return true;
        }
        else if(edificiMorti==true){
            //richiamo factory per ottenimento risorse
            this.eroiVivi(caselle, clash.getGiocatoreA());//faccion tornare gli eroi all'attaccante
            
            return true;
        }
        else{
            this.cambiaStato(clash,new Attacco());
            return false;
        }
        
    }
    //prende in ingresso le caselle del villaggio difensore e il giocatore Attaccante
    //gli eroiVivi delGIocatore Attaccante tornano all'attaccante se non sono morti
    private void eroiVivi( ArrayList<Casella> caselle,Giocatore giocatoreA){
        ArrayList<Eroe> eroiA=new ArrayList<Eroe>();
        for (int i=0;i<caselle.size();i++){
            ArrayList<Eroe> eroi=caselle.get(i).getListaEroiA();
            if(eroi!=null && eroi.size()>0){
                eroiA.addAll(eroi);
            }
        }
        giocatoreA.getAccampamento().setListaEroiGiocatore(eroiA);
        
    
    }
    
    
    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }

    @Override
    public void attaccanoEdifici(ClashGame clash) {
        
    }

    @Override
    public void attaccanoEroi(ClashGame clash) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettoclash;

/**
 *
 * @author Lorenzo
 */
public class ControlloFineBattaglia implements StatoAttacco{

    @Override
    public void esegui(ClashGame clash) {
        //da implementare
        System.out.println("FIne battaglia");
    }

    @Override
    public void cambiaStato(ClashGame clash, StatoAttacco st) {
        clash.CambiaStato(st);
    }
    
}

package com.mycompany.progettoclash.view;

import com.mycompany.progettoclash.CAcquista;
import com.mycompany.progettoclash.EroeDescrizione;
import com.mycompany.progettoclash.Giocatore;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class ViewAcquista {
    
    CAcquista acquista;
    
    public void selezionaOperazione(Giocatore g){//attenzione, chi glielo passa g?
        
        String s="Cosa vuoi fare?\n 1: Attaccare un altro giocatore?\n 2: Potenziare eroe?\n 3: Inserire edificio?\n 4: Acquistare eroi?\n 5: Potenziare edificio?\n >5: Esci(logout)";

        int ris=this.inserisci(s);
        switch (ris) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                acquista=new CAcquista(g);
                acquista.operazione(g);
                break;
            case 5:
                break;
            default:
                return;
        }
        
    
    }
     
    private int inserisci(String strDaVisualizzare){
        
        int var=0;
        Scanner sc=new Scanner(System.in);
        do {
             System.out.println(strDaVisualizzare);
             while (!sc.hasNextInt()) {
                 System.out.println("Errore, immetti un numero positivo");
                 sc.next(); 
             }
             var = sc.nextInt();
         } while (var < 0);
         return var;
    }
    
    public void mostraEroi(HashMap<EroeDescrizione,Integer> eroeDesc,boolean errore,Giocatore giocatore){
        
        if(errore){
            System.out.println("IdEroe inserito non corretto");
        }
        
        for (EroeDescrizione name: eroeDesc.keySet()) {
            String key = name.toString();
            String value = eroeDesc.get(name).toString();
            System.out.println(key + " Livello: " + value);
        }
        
        String s="Inserisci idEroe che vuole acquistare oppure 0 per annullare";
        int idEroe=this.inserisci(s);
        if(idEroe==0){
            return;
        }
        else{
            s="Inserisci quantità eroi che vuole acquistare oppure 0 per annullare";
            int quantita=this.inserisci(s);
            if(quantita==0){
                return;
            }
            else{
                acquista=new CAcquista(giocatore);
                acquista.acquistaEroi(idEroe,quantita);
            }
        }
        
        
    }
    
}

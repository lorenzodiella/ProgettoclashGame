package com.mycompany.progettoclash;
import com.mycompany.progettoclash.view.ViewCercaAvversario;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class Main {
    public static void main(String[] args){
        Giocatore g=new Giocatore();
        g.setNome("Lorenzo");
        ArrayList<Casella> caselle = new ArrayList<Casella>();
        Villaggio v=new Villaggio();
        Edificio e=new Municipio(new Immagazzinare(),new AttaccaAvanti());
        Edificio acc=new Accampamento(new Immagazzinare(),new AttaccaAvanti());
        Statistica s=new Statistica(5,5,100);
        acc.setStatistica(s);
        acc.setId(2);
        e.setStatistica(s);
        e.setId(1);
        ArciereBuilder arc=new ArciereBuilder();
        EroeDirector erD=new EroeDirector();
        Eroe eroeArc=erD.createEroe(arc);
        //Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        
       //creo VILLAGGIO
        for (int i=1;i<=v.getAltezza();i++){
            for (int j=1;j<=v.getLarghezza();j++){
                Casella c=new Casella(i,j);
                
                
                if(i==1 &&j==1){
                    c.AddEroe(eroeArc);
                    c.setEdificio(e);
                    eroeArc.setC(c);
                    e.setCasella(c);
                }
                if(i==1 &&j==2){
                    c.setEdificio(acc);
                    acc.setCasella(c);
                }
                
                c.setVillaggio(v);
                caselle.add(c);
            }
        }
        
        v.setCaselle(caselle);
        
        //creo GIOCATORE ATTACCANTE
        Giocatore ga=new Giocatore();
        Edificio acc2=new Accampamento(new Immagazzinare(),new AttaccaAvanti());
        Statistica s1=new Statistica(5,5,100);
        acc2.setStatistica(s1);
        acc2.setId(2);
         
        
        ArciereBuilder arc2=new ArciereBuilder();
        arc2.setId(1);
        EroeDirector erD2=new EroeDirector();
        Eroe eroeArc2=erD2.createEroe(arc2);
        ArrayList<Eroe> list=new ArrayList<Eroe>();
        list.add(eroeArc2);
        acc2.setListaEroiGiocatore(list);
        Villaggio v2=new Villaggio();
        for (int i=1;i<=v2.getAltezza();i++){
            for (int j=1;j<=v2.getLarghezza();j++){
                Casella c=new Casella(i,j);
                if(i==1 &&j==1){
                    c.AddEroe(eroeArc2);
                    c.setEdificio(acc2);
                    eroeArc.setC(c);
                    acc2.setCasella(c);
                }      
                c.setVillaggio(v2);
                caselle.add(c);
            }
        }
        ga.setAccampamento((Accampamento)acc2);
        ga.setVillaggio(v2);
        
        g.setVillaggio(v);
        Objects.isNull(g.getVillaggio().getCasella(1, 1).getVillaggio());
        ClashGame clash=new ClashGame(ga,g);
        eroeArc.getModA().attacco(eroeArc);
        //clash.iniziaBattaglia();
        
        
        Villaggio villaggioD=clash.getGiocatoreD().getVillaggio();
        for (int i=1;i<=villaggioD.getAltezza();i++){
            for (int j=1;j<=villaggioD.getLarghezza();j++){
                Casella c=villaggioD.getCasella(i, j);
                
                //System.out.print(Objects.isNull(c));
                System.out.print("Riga: "+c.getPosizioneRiga()+" Colonna: "+c.getPosizioneColonna()+" ");
                if(c.getEdificio()!=null){
                    System.out.print("Id Edif: "+c.getEdificio().getId()+" Vita:"+c.getEdificio().getStatistica().getVita()+" ");

                }
                ArrayList<Eroe> er = c.getListaEroiA();
                for (int k=0;k<er.size();k++){
                    System.out.print("IdEroe: "+er.get(k).getId()+" Vita: "+er.get(k).getStat().getVita());
                    
                }
                System.out.print("     ");
                
            }
            System.out.println();
        }
        
          /*
       //SIMULAZIONE DEGLI Eroi che attaccano
        Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
        guerriero.setC(c);
        guerriero.getModA().attacco(guerriero);
       //guerriero.attacca();
         Eroe arciere=new Arciere(new AttaccaDuePosizioni(),2);
      // arciere.attacca();
      
        arciere.setC(c);
        guerriero.setC(c);
        ArrayList<Eroe> eroi = new ArrayList<Eroe>();
        eroi.add(arciere);
        eroi.add(guerriero);
        for (int i=0;i<eroi.size();i++){
            
           // eroi.get(i).attacca();
            System.out.println(eroi.get(i).getId());
           // System.out.println(eroi.get(i).getC().getPosizioneRiga());

        }
        
        
        ArciereBuilder arc=new ArciereBuilder();
        EroeDirector erD=new EroeDirector();
        Eroe eroeArc=erD.createEroe(arc);
        Eroe arcPot=erD.createEroePotenziato(arc);
        System.out.println(eroeArc.toString());
        System.out.println(arcPot.toString());
        
        */
          
     //   ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();   
       // ArrayList<Integer> arr=view.mostraSelezionaPosizionaEroe(new ArrayList<Eroe>());               
        //SelezionePosizionaEroe sel=new SelezionePosizionaEroe(clash);
        //sel.selezionaPosizionaEroe(arr);
        
        //ViewSelezionaPosizionaEroe view=new ViewSelezionaPosizionaEroe();
        //view.mostraSelezionaPosizionaEroe(null);
        ViewCercaAvversario view2=new ViewCercaAvversario();
        view2.cercaAvversario(ga);
        
    }
        
}

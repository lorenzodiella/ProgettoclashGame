package com.mycompany.progettoclash;

import java.util.ArrayList;

/**
 *
 * @author Lorenzo
 */
public class TrovaAvversario {

//    public TrovaAvversario() {       
//    }

    
    
        public Giocatore getAvversario(Giocatore ga) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
           MatchMakingStrategy strategy=MatchMakingFactory.getInstance().getStrategy();
           return strategy.getAvversario(ga);
//        Giocatore g=new Giocatore();
//        g.setNome("Lorenzo");
//        ArrayList<Casella> caselle = new ArrayList<Casella>();
//        Villaggio v=new Villaggio();
//        Edificio e=new Municipio(new Immagazzinare(),new AttaccaAvanti());
//        Statistica s=new Statistica(5,5,100);
//        e.setStatistica(s);
//        e.setId(1);
//        Edificio e2=new Municipio(new Immagazzinare(),new AttaccaAvanti());
//        e2.setStatistica(s);
//        e2.setId(1);
//        //ArciereBuilder arc=new ArciereBuilder();
//        //EroeDirector erD=new EroeDirector();
//        //Eroe eroeArc=erD.createEroe(arc);
//        //Eroe guerriero=new Guerriero(new AttaccaDiagonale(),1);
//        
//       //creo VILLAGGIO
//        for (int i=1;i<=v.getAltezza();i++){
//            for (int j=1;j<=v.getLarghezza();j++){
//                Casella c=new Casella(i,j);
//                
//                
//                if(i==1 &&j==1){
//                   // c.AddEroe(eroeArc);
//                    c.setEdificio(e);
//                   // eroeArc.setC(c);
//                    e.setCasella(c);
//                }
//                if(i==4 &&j==4){
//                    c.setEdificio(e2);
//                    e2.setCasella(c);
//                }
//                
//                c.setVillaggio(v);
//                caselle.add(c);
//            }
//        }
//        
//        v.setCaselle(caselle);
//        g.setVillaggio(v);
//            return this.strategy.getAvversario(g);//da implementare
//       return g;
        }
    
}

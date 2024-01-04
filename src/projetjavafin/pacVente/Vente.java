
package projetjavafin;
import static projetjavafin.Stations.tab;
import java.time.LocalDate;
import java.util.Scanner;
import static projetjavafin.Stations.verifyeStations;


public class Vente {
    private String id,  dateVent;
    private int quantiDie, quantiGazo, prixTot=1;
    Scanner clavVent=new Scanner(System.in);
    Scanner clavVnt=new Scanner(System.in);
    Vente tabVent[]=new Vente[5];
    
    public Vente() {
    }

    public Vente(String id, String dateVent, int quantiDie, int quantiGazo, int prixTot) {
        this.id = id;
        this.dateVent = dateVent;
        this.quantiDie = quantiDie;
        this.quantiGazo = quantiGazo;
        this.prixTot = prixTot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateVent() {
        return dateVent;
    }

    public void setDateVent(String dateVent) {
        this.dateVent = dateVent;
    }

    public int getQuantiDie() {
        return quantiDie;
    }

    public void setQuantiDie(int quantiDie) {
        this.quantiDie = quantiDie;
    }

    public int getQuantiGazo() {
        return quantiGazo;
    }

    public void setQuantiGazo(int quantiGazo) {
        this.quantiGazo = quantiGazo;
    }
    
    
    void enregistrVente()
    {
        Stations nomm=new Stations();
        int i=0;
            int position=0;
            int chx,chxStat;
            tabVent[i]=new Vente();
                    chxStat=verifyeStations();
               String nom1="";
               switch(chxStat){
                   case 1:
                   {
                     nom1="Tabarre"; 
                   }break;
                   case 2:
                   {
                      nom1="Petion-Ville"; 
                   }break;
                   case 3:
                   {
                    nom1="Mirebalais";   
                   }break;
                   case 4:
                   {
                     nom1="Gressier";  
                   }break;
               }
               System.out.println("1-. Pour Gazoline");
               System.out.println("2-. Pour Diesel");
               System.out.println("3-. Pour Gazoline et Diesel");
               System.out.println("Choix !!!");
               chx=clavVent.nextInt();
               for(int t=0;t<tab.length;t++)
               { Stations ancien=new Stations();
                   ancien=tab[t];
                   if(nom1==ancien.getNom()){
                       nomm=tab[t];
                       position=t;
                   }
               }
                   
               switch(chx)
               {
                   case 1:
                   {
                       System.out.println("Entrer la quantite de gallons gasoline que vous voulez HT");
                       tabVent[i].quantiGazo=clavVnt.nextInt();
                       while(tabVent[i].quantiGazo>nomm.getCapaciteGazo()){
                           System.out.println("Erreur: Entrer la quantite de gallons gasoline que vous voulez HT");
                           tabVent[i].quantiGazo=clavVnt.nextInt();
                       }
                       nomm.setQuantiteGazoD(nomm.getQuantiteGazoD()-tabVent[i].quantiGazo);
                       tab[position]=nomm;
                       System.out.println(nomm.toString());
                       
                    }break;
                    
                   case 2:
                   {
                       System.out.println("Entrer la quantite de gallons diesiel que vous voulez HT");
                       tabVent[i].quantiDie=clavVnt.nextInt();
                       nomm.setQuantiteDiesDis(nomm.getQuantiteDiesDis()-tabVent[i].quantiDie);
                       tab[position]=nomm;
                        while(tabVent[i].quantiDie>nomm.getCapaciteDies()){
                           System.out.println("Erreur : Entrer la quantite de Diesiel que vous voulez HT");
                           tabVent[i].quantiGazo=clavVnt.nextInt();
                        }
                   }break;
                   case 3:
                   {
                       System.out.println("Entrer la quantite de gallons gasoline que vous voulez HT");
                       tabVent[i].quantiGazo=clavVnt.nextInt();
                       while(tabVent[i].quantiGazo>nomm.getCapaciteGazo()){
                           System.out.println("Erreur : Entrer la quantite de gallons gasoline que vous voulez HT");
                           tabVent[i].quantiGazo=clavVnt.nextInt();
                       }
                       System.out.println("Entrer la quantite de gallons diesiel que vous voulez HT");
                       tabVent[i].quantiDie=clavVnt.nextInt();
                        while(tabVent[i].quantiDie>nomm.getCapaciteDies()){
                           System.out.println("Erreur : Entrer la quantite de Diesiel que vous voulez HT");
                           tabVent[i].quantiGazo=clavVnt.nextInt();
                        }
                                               
                       nomm.setQuantiteGazoD(nomm.getQuantiteGazoD()-tabVent[i].quantiGazo);
                       tab[position]=nomm;
                       nomm.setQuantiteDiesDis(nomm.getQuantiteDiesDis()-tabVent[i].quantiDie);
                       tab[position]=nomm;
                       System.out.println(nomm.toString());
                   }break;
               }
                 Stations anc=new Stations();
                   anc=tab[i];
                   nomm.setUtilisationGazo(((tabVent[i].quantiGazo*100)/anc.getCapaciteGazo()));
                   nomm.setUtilisationDies(((tabVent[i].quantiDie*100)/anc.getCapaciteDies()));

               tabVent[i].id=anc.getNom()+"AT-"+(i+1);
               LocalDate dateVnt=LocalDate.now();
               String dat=dateVnt.toString();
               tabVent[i].dateVent=dat;
               tabVent[i].prixTot=(tabVent[i].quantiGazo*250)+(tabVent[i].quantiDie*353);
          
        i+=1;
    }
    
    
    void afficVent()
    {
        for(Vente v:tabVent)
        {
            if(v==null)
            {
                System.out.println();
            }
            else{
               System.out.println(v.toString()); 
            }
        }
    }
        
    

    @Override
    public String toString() {
        return    "Le code du vente                           =" + id +"\n"
                + "Date du Vente                              =" + dateVent +"\n"
                + "Quantite Diesiel HT                        =" + quantiDie +" Gallon(s)\n"
                + "Quantite Gasoline HT                       =" + quantiGazo +" Gallon(s)\n" 
                + "Le prix total                              =" + prixTot +"GDS";
    }
 /*
    public static void main(String args[])
    {
        Vente vt=new Vente();
        Stations obVnt=new Stations();
        obVnt.Saisir();
        vt.enregistrVente();
        vt.afficAppro();
        obVnt.afficher();
    }*/
}
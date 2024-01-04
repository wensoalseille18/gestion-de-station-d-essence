
package projetjavafin;

import static projetjavafin.Stations.tab;
import java.time.LocalDate;
import java.util.Scanner;
import static projetjavafin.Stations.verifyeStations;



public class Approvisionnement
{
    Scanner claApr=new Scanner(System.in);
    private int approGazo,approDie;
    private String id, dateAppro;
    private String st;
    Approvisionnement tabAppro[]=new Approvisionnement[4];
    Scanner clavStr=new Scanner(System.in);
    
    public Approvisionnement(){}
    
    //Constructeur
    public Approvisionnement(int approGazo, int approDie, String id, String dateAppro,String st) {
        this.approGazo = approGazo;
        this.approDie = approDie;
        this.id = id;
        this.dateAppro = dateAppro;
        this.st=st;
    }
   
    //Les Setters et les Getters
    public int getApproGazo() {
        return approGazo;
    }

    public void setApproGazo(int approGazo) {
        this.approGazo = approGazo;
    }

    public int getApproDie() {
        return approDie;
    }

    public void setApproDie(int approDie) {
        this.approDie = approDie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateAppro() {
        return dateAppro;
    }

    public void setDateAppro(String dateAppro) {
        this.dateAppro = dateAppro;
    }
    
    void approvSave()
    {
        Stations u=new Stations();
        String re="";
        int i=0;
        do{
        int valGazo=0, valdie=0;
        
        tabAppro[i]=new Approvisionnement();
        
            String pass;
            System.out.println("Entrer votre mot de passe");
            pass=claApr.nextLine();
            int co=0;
            while(!pass.equals("Authentic"))
            { 
                co+=1;

                if(co==3)
                  {
                      break;
                  }
                  System.out.println("Mot de passe incorrect !\n Entrer votre mot de passe");
                  pass=claApr.nextLine();
                  
            }
              if(co!=3){
                  {
                      int o;
                    System.out.println("Entrrer le nom du Stations Que vous voulez approvisionner");
                    o=verifyeStations();
                    u=tab[o];
                    u.setUtilisationDies(0);
                    u.setUtilisationGazo(0);
                    tab[0]=u;
                    for(Stations t:tab)
                    {
                        if(t.getNom().equalsIgnoreCase(u.getNom()))
                        {
                                valGazo=(t.getCapaciteGazo()-t.getQuantiteGazoD());
                                valdie=(t.getCapaciteDies()-t.getQuantiteDiesDis());
                        }
                    }
                    
                    tabAppro[i].approGazo=valGazo;
                    tabAppro[i].approDie=valdie;
                    tabAppro[i].id="0/-"+(i+10);
                    
                    LocalDate date = LocalDate.now();
                    
                    String dateString = date.toString();
                    tabAppro[i].dateAppro=dateString; 
                    tabAppro[i].st=u.getNom();
                    i+=1;
                  }
                    System.out.println("O pour continuer N pour annuler");
                    re=claApr.nextLine();
                   }
        }while(re.equalsIgnoreCase("O"));
                  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
    }

    void afficAppro()
    {
        for(Approvisionnement v:tabAppro)
        {
            if(v==null)
            {             
                System.out.println();
            }
            else
            {
               System.out.println(v.toString()); 
               System.out.println();
            }
        }
    }


    @Override
    public String toString() {
        return   "Le nom du station approvisionnee      ="+ st+"\n"
                +"Approvisionnement Gazoline            =" + approGazo +" Gallon(s)\n"
                + "Approvisionnement Diesel             =" + approDie +" Gallon(s)\n"
                + "Code Approvisionnement               =" + id +"\n"
                + "Date Approvisionnement               =" + dateAppro;
    }
    
    /*
    public static void main(String args[])
    {
        Approvisionnement ap=new Approvisionnement();
        Stations obljctSat=new Stations();
        obljctSat.Saisir();
        ap.approvSave();
        ap.afficAppro();
    }*/
            
}
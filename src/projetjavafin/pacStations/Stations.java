
package projetjavafin;
import java.util.ArrayList;

import java.util.Scanner;

public class Stations
{
    private String nom;
    private int capaciteGazo;
    private int capaciteDies;
    private  int utilisationGazo;
    private  int utilisationDies;
    private  int quantiteGazoD;
    private  int quantiteDiesDis;
    static Stations tab[]=new Stations[4];
    Scanner stin=new Scanner(System.in);
    Scanner ent=new Scanner(System.in);

    public int getQuantiteGazoD() {
        return quantiteGazoD;
    }

    public void setQuantiteGazoD(int quantiteGazoD) {
        this.quantiteGazoD = quantiteGazoD;
    }

    public int getQuantiteDiesDis() {
        return quantiteDiesDis;
    }

    public void setQuantiteDiesDis(int quantiteDiesDis) {
        this.quantiteDiesDis = quantiteDiesDis;
    }

    public int getCapaciteGazo() {
        return capaciteGazo;
    }

    public void setCapaciteGazo(int capaciteGazo) {
        this.capaciteGazo = capaciteGazo;
    }

    public int getCapaciteDies() {
        return capaciteDies;
    }

    public void setCapaciteDies(int capaciteDies) {
        this.capaciteDies = capaciteDies;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getUtilisationGazo() {
        return utilisationGazo;
    }

    public void setUtilisationGazo(int utilisationGazo) {
        this.utilisationGazo = utilisationGazo;
    }

    public int getUtilisationDies() {
        return utilisationDies;
    }

    public void setUtilisationDies(int utilisationDies) {
        this.utilisationDies = utilisationDies;
    }
    public Stations(String nom, int capaciteGazo, int capaciteDies, int quantiteGazoD, int quantiteDiesDis) {
        this.nom = nom;
        this.capaciteGazo = capaciteGazo;
        this.capaciteDies = capaciteDies;
        this.utilisationGazo = 100;
        this.utilisationDies = 100;
        this.quantiteGazoD = 0;
        this.quantiteDiesDis = 0;
    }
    public Stations(){}
 

    void Saisir()
    {   int num=0;
         ArrayList<Integer> choixx=new ArrayList<Integer>();
        for(int i=0; i<tab.length; i++)
        {
            tab[i]=new Stations();
            String nomb="";
            System.out.println("Le nom du Station #"+(i+1));
                num=verifyeStations();
                while(choixx.contains(num)){
                    System.out.println("Vous avez deja choisir ce numero choisir un autre.");
                    num=verifyeStations();
                }
                choixx.add(num);
            switch(num)
            {
                case 1:
                    nomb="Tabarre";
                break;
                case 2:
                    nomb="Petion-Ville";
                break; 
                case 3:
                    nomb="Mirebalais";
                break;
                case 4:
                    nomb="Gressier";
                break;                 
            }
            tab[i].nom=nomb;
            System.out.println("La capacite de Gazoline");
            tab[i].capaciteGazo=ent.nextInt();
            System.out.println("La capacite de Diesel");
            tab[i].capaciteDies=ent.nextInt();

        }
    }
    void afficher()
    {
        for(Stations s:tab)
        {
            System.out.println(s.toString());
            System.out.println();
        }
    }
    @Override
    public String toString() {
        return    "Nom du Station                     =" + nom+"\n" 
                + "Capacite en Gazoline               =" + capaciteGazo+" Gallon(s)\n"
                + "Capacite en Diesel                 =" + capaciteDies+" Gallon(s)\n"
                + "Utilisation Gazoline               =" + utilisationGazo+" %\n" 
                + "Utilisation Diesel                 =" + utilisationDies+" %\n" 
                + "Quantite GazoD                     =" + quantiteGazoD+" Gallon(s)\n" 
                + "QuantiteDiesDis                    =" + quantiteDiesDis+ " Gallon(s)";
    }
    void modifier()
    {   int a=0;
        Stations sta=new Stations();
        String nomStat;
        int quantiteG,quantiteD;
        System.out.println("Entrer le nom du station que vous voulez modifier");
        nomStat=stin.nextLine();
        for(int i=0; i<tab.length; i++)
        {
            if(tab[i].nom.equalsIgnoreCase(nomStat))
            {
                a=verifyeGazoDie();
                switch(a)
                {
                    case 1:
                    {
                        System.out.println("Entrer la nouvelle quantite de gallon de Gazoline");
                        quantiteG=ent.nextInt();
                        sta.setQuantiteGazoD(quantiteG);
                        tab[i].quantiteGazoD=sta.getQuantiteGazoD();
                    }break;
                    case 2:
                    {
                        System.out.println("Entrer la nouvelle quantite de gallon de Diesel");
                        quantiteD=ent.nextInt();
                        sta.setQuantiteDiesDis(quantiteD);
                        tab[i].quantiteDiesDis=sta.getQuantiteDiesDis();                        
                    }break;
                    case 3:
                    {
                        System.out.println("Entrer la nouvelle quantite de gallon de Diesel");
                        quantiteD=ent.nextInt();
                        System.out.println("Entrer la nouvelle quantite de gallon de Gazoline");
                        quantiteG=ent.nextInt();
                        sta.setQuantiteGazoD(quantiteG);
                        tab[i].quantiteGazoD=sta.getQuantiteGazoD();
                        sta.setQuantiteDiesDis(quantiteD);
                        tab[i].quantiteDiesDis=sta.getQuantiteDiesDis();
                    }break;

                }
            }
        }
    }
        void moinsGazo()
        {
            Stations toStr=new Stations();
            toStr=tab[0];
            int minG=tab[0].quantiteGazoD;
            for(int i=1; i<tab.length;i++)
            {
                if(minG>tab[i].quantiteGazoD)
                {
                    minG=tab[i].quantiteGazoD;
                    toStr=tab[i];                      
                }
            }
            System.out.println("Ce qui a le moins de reserve de gazoline");
            System.out.println(toStr.toString());
        }
        
        void moinsDie()
        {
            Stations toStr=new Stations();
            toStr=tab[0];
            int minD=tab[0].quantiteDiesDis;
            for(int i=1; i<tab.length;i++)
            {
                if(minD>tab[i].quantiteDiesDis)
                {
                    minD=tab[i].quantiteDiesDis;
                    toStr=tab[i];                      
                }
            }
            System.out.println("Ce qui a le moins de reserve de diesel");
            System.out.println(toStr.toString());
        }
            
        //Station ayant le moins de réserve de diesel et gazoline
         void moinsGazoDie()
        {
            Stations toStr=new Stations();
            toStr=tab[0];
            int min=tab[0].quantiteGazoD + tab[0].quantiteDiesDis;

            for(int i=1; i<tab.length;i++)
            {
                if(min>(tab[i].quantiteDiesDis+tab[i].quantiteGazoD))
                {
                    min=tab[i].quantiteDiesDis+tab[i].quantiteGazoD;
                    //minG=tab[i].quantiteGazoD;
                    toStr=tab[i];                      
                }
            }
            System.out.println("Ce qui a le moins de reserve de diesel et/ou gazoline");
            System.out.println(toStr.toString());
        }
         
        //Station ayant le plus de réserve de gazoline
         void plusGazo()
        {
            Stations toStr=new Stations();
            toStr=tab[0];
            int maxG=tab[0].quantiteGazoD;
            //System.out.println(minG);
            for(int i=1; i<tab.length;i++)
            {
                if(maxG<tab[i].quantiteGazoD)
                {
                    maxG=tab[i].quantiteGazoD;
                    toStr=tab[i];                      
                }
            }
            System.out.println("Ce qui a le plus de reserve de gazoline");
            System.out.println(toStr.toString());
        }
         
        //Station ayant le plus de réserve de diesel  
         void plusDie()
        {
            Stations toStr=new Stations();
            toStr=tab[0];
            int maxD=tab[0].quantiteDiesDis;
            for(int i=1; i<tab.length;i++)
            {
                if(maxD<tab[i].quantiteDiesDis)
                {
                    maxD=tab[i].quantiteDiesDis;
                    toStr=tab[i];                      
                }
            }
            System.out.println("Ce qui a le plus de reserve de diesel");
            System.out.println(toStr.toString());
        }
            
        //Station ayant le plus de réserve de diesel et gazoline
        void plusGazoDie()
        {
            Stations toStr=new Stations();
            toStr=tab[0];
            int max=tab[0].quantiteGazoD + tab[0].quantiteDiesDis;
            
            for(int i=1; i<tab.length;i++)
            {
                if(max<(tab[i].quantiteDiesDis+tab[i].quantiteGazoD))
                {
                    max=tab[i].quantiteDiesDis+tab[i].quantiteGazoD;
                    //minG=tab[i].quantiteGazoD;
                    toStr=tab[i];                      
                }
            }
            System.out.println("Ce qui a le plus de reserve de diesel et/ou gazoline");
            System.out.println(toStr.toString());
        }
         
         
         static int verifyeStations(){	
	Scanner ent=new Scanner(System.in);
	int num=0;
             boolean validInput = false;

        while (!validInput) {
            System.out.println("Select le nom du Station \n1.--------Tabarre\n2.--------Petion-Ville\n3.--------Mirebalais\n4.--------Gressier");
            System.out.println("Entrez un nombre entier : ");
            String input = ent.nextLine();
			 boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    isNumber = false;
                    break;
                }
				
            }
			if (isNumber) {
                num = Integer.parseInt(input);
                if (num<1 || num>4) {
                 System.out.println("Erreur : vous devez entrer un nombre entier copris entre  et "); 
                 //System.out.println("Select le nom du Station \n1.--------Tabarre\n2.--------Petion-Ville\n3.--------Mirebalais\n4.--------Gressier");
                }
				else{
					validInput = true;
				}
            }

		}		
		
	return num;	
		
	}
         
         
    static int verifyeGazoDie()
    {	
            Scanner ent=new Scanner(System.in);
            int num=0;
            boolean validInput = false;
            while(!validInput)
            {

                        System.out.println("1-. Pour modifier la quantite de gallon de Gazoline d'une station");
                        System.out.println("2-. Pour modifier la quantite de gallon de Diesel d'une station");
                        System.out.println("3-. Pour modifier la quantite de gallon de Gazoline et Diesel d'une station");
                        System.out.println("Choix !!!");
                        System.out.println("Entrez un nombre entier : ");
                        String input = ent.nextLine();
                        boolean isNumber = true;
                    for(int a = 0; a < input.length(); a++)
                    {
                        if(!Character.isDigit(input.charAt(a)))
                        {
                            isNumber = false;
                            break;
                        }
                    }
                        if(isNumber)
                        {
                            num = Integer.parseInt(input);
                            if(num<1 || num>3) {
                             System.out.println("Erreur : vous devez entrer un nombre entier copris entre  et "); 
                            }
                            else
                            {
                                validInput = true;
                            }
                        }

            }		
                   return num;	
		
    }
    
   /*      
   public static void main(String args[])
   {
       System.out.println("Welcome in my program");
       Stations inst=new Stations();
       inst.Saisir();
       inst.afficher();
       inst.modifier();
       inst.afficher();
       inst.moinsGazo();
       inst.moinsDie();
       inst.moinsGazoDie();
       inst.plusGazo();
       inst.plusDie();
       inst.plusGazoDie();
   }
*/
}


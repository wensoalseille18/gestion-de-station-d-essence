
package projetjavafin;
import static projetjavafin.Stations.tab;
import java.time.LocalDate;
import java.util.Scanner;


public class Commandes
{

    //private static Stations[] Stations;
    private int comGazo,comDie;
    private String id, dateCom, etat;
    //static Stations tab[]=new Stations[2];
    Stations stat=new Stations();
    Scanner clav=new Scanner(System.in);
    Scanner clavStri=new Scanner(System.in);
    static Commandes []tabCom=new Commandes[3];
    public Commandes(){this.etat = "N";}
    
    
    public Commandes(String id, int comGazo, int comDie, String dateCom)
    {
        this.id = id;
        this.comGazo = comGazo;
        this.comDie = comDie;
        this.dateCom = dateCom;
        this.etat = "N";
    }
    
//Les getters et les setters
    public int getComGazo() {
        return comGazo;
    }

    public void setComGazo(int comGazo) {
        this.comGazo = comGazo;
    }

    public int getComDie() {
        return comDie;
    }

    public void setComDie(int comDie) {
        this.comDie = comDie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCom() {
        return dateCom;
    }

    public void setDateCom(String dateCom) {
        this.dateCom = dateCom;
    }


////////////////////////////Les Mehodes\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    int command(int o)
    {
        int choix=0;
        int somGazo=0,somDiel=0;
        for(int i=0 ; i<tab.length; i++)
            
        {
           somGazo+=((tab[i].getCapaciteGazo()-tab[i].getQuantiteGazoD())*1.25);
           somDiel+=((tab[i].getCapaciteDies()-tab[i].getQuantiteDiesDis())*1.10);
        }
         
//   int prGazD=0;
        String rep="";
           // int prGaz=0;
          int i=o;
        //for(int i=0; i<tabCom.length; i++)
        //{
       // do{
            //int i=0;
            //tabCom[i]=new Commandes();
         //Commandes com=new Commandes();
        

           do{ 
              String pass="";
               tabCom[i]=new Commandes();            
               choix=verifyeGD();
               for(Stations tt : tab){
                   System.out.println("Le nom du Stations : "+tt.getNom());
                   System.out.println("Le % du Stations en Gasoline: "+tt.getUtilisationGazo());
                   System.out.println("Le % du Stations en Diesiel: "+tt.getQuantiteDiesDis());
               }
              System.out.println("Entrer votre mot de passe");
              pass=clavStri.nextLine();
              
              int co=0;
              while(!pass.equals("Authentic"))
              { 
                co+=1;
                                

                  if(co==3)
                  {
                      break;
                  }
                  System.out.println("Mot de passe incorrect !" + "\n"+"Entrer votre mot de passe");
                  pass=clavStri.nextLine();
                  //co+=1;
               }
              if(co!=3){
                switch(choix)
                {
                    case 1:
                    {
                        //
                        System.out.println("La commande du gazoline est effectuee avec succes");
                       // prGaz=somGazo;
                        tabCom[i].comGazo=somGazo;

                    }break;

                    case 2:
                    {
                        System.out.println("La commande du succes est effectuee avec succes");  
                        //prGazD=somDiel;
                        tabCom[i].comDie=somDiel;
                                              
                    }break;
                    
                    case 3:
                    {
                        System.out.println("La commande des deux gaz sont effectuees avec succes"); 
                      //  prGaz=somGazo;
                        //prGazD=somDiel;        
                              tabCom[i].comGazo=somGazo;
                              tabCom[i].comDie=somDiel;
                    }break;
                }    
              
              }
               
           if(i>0){
               if(i==1){
                   tabCom[i-1].etat="P";
               }
               if(i==2){
                 tabCom[i-1].etat="P";
                 tabCom[i-2].etat="P";
               }
           }
            tabCom[i].id=(i+1000)+"$";
            LocalDate date = LocalDate.now();
            // Convertir la date en une chaîne de caractères
            String dateString = date.toString();
            tabCom[i].dateCom=dateString; 
            i+=1;
            System.out.println("O pour continuer N pour annuler");
            rep=clavStri.nextLine();
           }while(rep.equalsIgnoreCase("O"));
return i;
        }
           


        //Pour les affichers
    static void afficherCommand()
    {
        System.out.println("Voici la liste des commandes ");
        for(Commandes s:tabCom)
        {//{
            //System.out.println(v.getNom());
            if(s==null)
            {             
                System.out.println();
            }
            else{
               System.out.println(s.toString()); 
               System.out.println();
            }
        }
        
    }
    
    
    void supprimer()
    {
              //choix=clav.nextInt();
              String pass="";
              System.out.println("Entrer votre mot de passe");
              pass=clavStri.nextLine();
              int co=0;
              while(!pass.equals("Authentic"))
              { 
                co+=1;
                                

                  if(co==3)
                  {
                      break;
                  }
                  System.out.println("Mot de passe incorrect !" + "\n"+"Entrer votre mot de passe");
                  pass=clavStri.nextLine();
                  //co+=1;
               }
              if(co!=3){

		String codeSai;
		System.out.println("Entrer code du produit que vous voulez supprimer ");
		codeSai=clavStri.nextLine();
		//for(int i=0; i<tabCom.length; i++)
                int u=0;
                for(Commandes cv:tabCom)
		{

			if(cv!=null){//if(tabCom[i].id.equalsIgnoreCase(codeSai))
                    if(cv.getId().equalsIgnoreCase(codeSai))
			{
				/*tabCom[i].id="S";	
				tabCom[i].comGazo=0;		
				tabCom[i].comDie=0;	
				tabCom[i].dateCom="";
                                tabCom[i].etat="";*/
                            cv.setComDie(0);
                            cv.setId("S");
                            cv.setComGazo(0);
                            cv.setDateCom(" ");
                            tabCom[u]=cv;
			}
                        }
                    u+=1;
                }
			//for(int i=0; i<tabCom.length; i++)
                        for(Commandes c : tabCom)
			{
                            
				if(c!=null){//if(!tabCom[i].id.equalsIgnoreCase("S"))
                            if(c.getId().equalsIgnoreCase("S"))
				{
                                    System.out.println("Commande Supprimer");
				}
                            else
                            {
                                  System.out.println(c.toString());
			}
                        }
                        }
              }
    }

    @Override
    public String toString() {
        return    "Le code du commande                 =" + id+"\n" 
                + "Qnte Gazoline commande              =" + comGazo+" Gallon(s)\n"
                + "Qnt Diesel commande                 =" + comDie+" Gallon(s)\n"
                + "La date du commande                 =" + dateCom+"\n" 
                + "L'etat du commande                  =" + etat;
    }
    

            static int verifyeGD(){	
	Scanner ent=new Scanner(System.in);
	int num=0;
             boolean validInput = false;

        while (!validInput) {
               System.out.println("1-. Pour Gazoline");
               System.out.println("2-. Pour Diesel");
               System.out.println("3-. Pour Gazoline et Diesel");
               System.out.println("Choix !!!");
                String input = ent.nextLine();
		boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    isNumber = false;
                    break;
                }
				
            }
		if (isNumber)
                {
                    num = Integer.parseInt(input);
                    if (num<1 || num>3) {
                     System.out.println("Erreur : vous devez entrer un nombre entier compris entre 1 a 3 "); 
                     //System.out.println("Select le nom du Station \n1.--------Tabarre\n2.--------Petion-Ville\n3.--------Mirebalais\n4.--------Gressier");
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
    
//System.out.println(java.time.LocalDate.now())
   public static void main(String args[])
   { int posi=0;
       System.out.println("Welcome in my program");
       Commandes insCom=new Commandes();
       Stations stat=new Stations();
       stat.Saisir();
       
       posi=insCom.command(posi);
       insCom.afficherCommand();
       insCom.supprimer();
    }*/
}
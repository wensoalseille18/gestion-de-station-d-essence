/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetjavafin;
import java.util.Scanner;
//import projetjavafin.*;
/**
 *
 * @author Blemy
 */
public class ProjetJavaFin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
         int choix,o=0;
         Scanner ent =new Scanner(System.in);
         Scanner stri =new Scanner(System.in);
        Stations mn=new Stations();
        Commandes coom=new Commandes();
        Vente vvent=new Vente();
        Approvisionnement appp=new Approvisionnement();
        mn.Saisir();
        String repp;
        do{
        System.out.println("Operation sur une STATION");
        System.out.println("1.- Modifier quantite de gallons ");
        System.out.println("2.- Afficher toutes les stations");
        System.out.println("3.- Afficher la station ayant le moins de reserve en Gazolin");
        System.out.println("4.- Afficher la station ayant le moins de reserve en Diesiel");
        System.out.println("5.- Afficher la station ayant le moins de reserve en Gazolin et en Diesiel");
        System.out.println("6.- Afficher la station ayant le plus de reserve en Diesiel");
        System.out.println("7.- Afficher la station ayant le plus de reserve en Gasoline");
        System.out.println("8.- Afficher la station ayant le plus de reserve en Gasoline et en Diesiel \n");
        System.out.println("Operation sur COMMANDE");
        System.out.println("9.- Enregistrer Commande ");
        System.out.println("10.- Afficher toutes les commandes");
        System.out.println("11.- Supprimer une commande par l’administrateur ");
        System.out.println("Operation sur approvisionnement \n ");
        System.out.println("12.- Enregistrer approvisionnement ");
        System.out.println("13.- Afficher tous les approvisionnements ");
        System.out.println("Operation Sur VENTE ");
        System.out.println("14.- Enregistrer Vente");
        System.out.println("15.- Afficher vente");
       choix=ent.nextInt();
       
       switch(choix)
               {
                   case 1:
                 {
                    mn.modifier();
                    mn.afficher();
                }break;
                   case 2:
                   {
                       mn.afficher();
                   }break;
                   case 3:
                   {
                       mn.moinsGazo();
                   }break;
                   case 4:
                   {
                       mn.moinsDie();
                   }break;
                   case 5:
                   {
                       mn.moinsGazoDie();
                   }break;
                   case 6:
                   {
                       mn.plusDie();
                   }break;
                   case 7:
                   {
                       mn.plusGazo();
                   }break;
                   case 8:
                   {
                       mn.plusGazoDie();
                   }break;
                    case 9:
                   {
                       o=coom.command(o);
                   }break;
                     case 10:
                   {
                       coom.afficherCommand();
                   }break;
                     case 11:
                   {
                       coom.supprimer();
                    }break;
                    case 12:
                   {
                       appp.approvSave();
                   }break;
                   case 13:
                   {
                      appp.afficAppro();
                   }break;
                    case 14:
                   {
                        vvent.enregistrVente();
                   }break;
                    case 15:
                   {
                       vvent.afficVent();
                   }break;
                    default :
                    {
                        System.out.println("Vous avez choisir un numero qui ne figure pas dans le menu ");
                    }
       }
       System.out.println("Si vous voulez continuer entrer O pour Oui N pour Non");
       repp=stri.nextLine();

        }while(repp.equalsIgnoreCase("O"));
        System.out.println("Merci de bien vouloir visiter notre programme");
    }
}
package m2i.projet.JEE_REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import m2i.projet.JEE_REST.entity.Emprunt;
import m2i.projet.JEE_REST.entity.Exemplaire;
import m2i.projet.JEE_REST.entity.Livre;
import m2i.projet.JEE_REST.entity.TypeLivre;
import m2i.projet.JEE_REST.entity.Utilisateur;
import m2i.projet.JEE_REST.repository.EmpruntRepository;
import m2i.projet.JEE_REST.repository.ExemplaireRepository;
import m2i.projet.JEE_REST.repository.LivreRepository;
import m2i.projet.JEE_REST.repository.TypeLivreRepository;
import m2i.projet.JEE_REST.repository.UtilisateurRepository;



@SpringBootApplication
public class JeeRestApplication implements CommandLineRunner {

	@Autowired
	EmpruntRepository empruntRepository;
	@Autowired
	ExemplaireRepository exemplaireRepository;
	@Autowired
	LivreRepository livreRepository;
	@Autowired
	TypeLivreRepository typeLivreRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JeeRestApplication.class, args);
	}
	
	
	@Override
    public void run(String... args) throws Exception {
        
		/* Ajout de 4 membres : notre equipe.
		 * Role = 1 pour tout le monde -> abonnés */
		Utilisateur u1 = new Utilisateur("Romane", "Trombetta", "romane@gmail.com", 1);
		utilisateurRepository.save(u1);
		
		Utilisateur u2 = new Utilisateur("Quentin", "Colombier", "quentin@gmail.com", 1);
		utilisateurRepository.save(u2);
		
		Utilisateur u3 = new Utilisateur("Jerome", "Germain", "jerome@sfr.fr", 1);
		utilisateurRepository.save(u3);
        
		Utilisateur u4 = new Utilisateur("Baptiste", "Hornecker", "baptiste@hotmail.com", 1);
		utilisateurRepository.save(u4);
		
		
		// Ajout de 3 types de livres
		TypeLivre t1 = new TypeLivre("Sciences");
		typeLivreRepository.save(t1);
		
		TypeLivre t2 = new TypeLivre("Roman");
		typeLivreRepository.save(t2);
		
		TypeLivre t3 = new TypeLivre("Informatique");
		typeLivreRepository.save(t3);
		
		
		// Ajout de quelques livres
		Livre l1 = new Livre("978 2 7654 0912 0", "Les maths pour les nuls", "Cedric Villani", "Pour les nuls", t1);
		livreRepository.save(l1);
		
		Livre l2 = new Livre("978 2 1337 0912 0", "Quand la machine apprend", "Yann Le Cun", "Odile Jacob", t1);
		livreRepository.save(l2);
		
		
		// Ajout des exemplaires
		Exemplaire e1 = new Exemplaire("978 2 7654 0912 0", "Bon état");
		exemplaireRepository.save(e1);
		
		Exemplaire e2 = new Exemplaire("978 2 7654 0912 0", "Mauvais état");
		exemplaireRepository.save(e2); 
		
		
		// Ajout des emprunts
		Emprunt emp1 = new Emprunt(e1, u1, null, 15);
		empruntRepository.save(emp1);
		
        // Recupérer toutes les tables
        /* List<Utilisateur> utilisateurs = utilisateurRepository.findAll();       
        List<TypeLivre> typeslivres = typeLivreRepository.findAll();
        List<Livre> livres = livreRepository.findAll();
        List<Exemplaire> exemplaires = exemplaireRepository.findAll();
        List<Emprunt> emprunts = empruntRepository.findAll();*/ 
        
        // Et les afficher !
        // afficherBaseDeDonnees(utilisateurs, typeslivres, livres, exemplaires, emprunts);
    }
	
	
	/* private static void createDataBase() {
	
		
	} */
	
	
	private static void afficherBaseDeDonnees(List<Utilisateur> utilisateurs,
			List<TypeLivre> typeslivres, List<Livre> livres,
			List<Exemplaire> exemplaires, List<Emprunt> emprunts) {

        System.out.println("============================");
        System.out.println(" AFFICHAGE DES UTILISATEURS ");
        System.out.println("============================");
        
        for (Utilisateur utilisateur : utilisateurs) {
        	System.out.println(utilisateur);
        }
        
        /*System.out.println("============================");
        System.out.println(" AFFICHAGE DES TYPES LIVRES ");
        System.out.println("============================");
        
        for (TypeLivre typelivre : typeslivres) {
        	System.out.println(typelivre);
        }
        
        System.out.println("============================");
        System.out.println("    AFFICHAGE DES LIVRES    ");
        System.out.println("============================");
        
        for (Livre livre : livres) {
        	System.out.println(livre);
        } */
        
        /* System.out.println("============================");
        System.out.println(" AFFICHAGE DES EXEMPLAIRES  ");
        System.out.println("============================");
        
        for (Exemplaire exemplaire : exemplaires) {
        	System.out.println(exemplaire);
        }
        
        System.out.println("============================");
        System.out.println("   AFFICHAGE DES EMPRUNTS   ");
        System.out.println("============================");
        
        for (Emprunt emprunt : emprunts) {
        	System.out.println(emprunt);
        }*/
	}

}

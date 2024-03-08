import dao.projet.IProjetDao;
import dao.projet.ProjetDaoImpl;
import dao.tache.ITacheDao;
import dao.tache.TacheDaoImpl;
import dao.utilisateur.IUtilisateurDao;
import dao.utilisateur.UtilisateurDaoImpl;
import entities.Projet;
import entities.Tache;
import entities.Utilisateur;

public class Main {
    public static void main(String[] args) {
        IUtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
        IProjetDao projetDao = new ProjetDaoImpl();
        ITacheDao tacheDao = new TacheDaoImpl();

        Tache tache = new Tache();
        Utilisateur user = new Utilisateur();
        Projet projet = new Projet();

        user.setNom("MOHA");
        user.setEmail("MOHA@GMAIL.COM");

        tache.setTitre("TEST");

        projet.setTitre("TESTPROJECT");
        projet.setDescription("THIS IS A TEST PROJECT");

        projet.addTache(tache);
        projet.addUtilisateur(user);

        projetDao.save(projet);

        System.out.println(projetDao.rechercher());
        System.out.println(utilisateurDao.rechercher());
        System.out.println(tacheDao.rechercher());
    }
}

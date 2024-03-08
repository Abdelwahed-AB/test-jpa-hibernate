package dao.utilisateur;

import entities.Utilisateur;

import java.util.List;

public interface IUtilisateurDao {
    List<Utilisateur> rechercher();
    void deleteUtilisateur(Utilisateur user);
}

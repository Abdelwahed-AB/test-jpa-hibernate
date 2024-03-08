package dao.projet;

import entities.Projet;
import entities.Tache;

import java.util.List;

public interface IProjetDao {
    List<Projet> rechercher();
    void save(Projet projet);

    void addTacheToProjet(Long idProjet, Tache tache);

    void resetTaches(Long idProjet);
}

package dao.projet;

import entities.Projet;
import entities.Tache;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.DbConfig;

import java.util.List;

public class ProjetDaoImpl implements IProjetDao{
    private EntityManager entityManager;

    public ProjetDaoImpl() {
        entityManager = DbConfig.entityManager();
    }

    @Override
    public List<Projet> rechercher() {
        entityManager.getTransaction().begin();
        try{
            Query query = entityManager.createQuery(
                    "from Projet p order by p.id asc"
            );
            List<Projet> results = query.getResultList();
            entityManager.getTransaction().commit();
            return results;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void save(Projet projet) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(projet);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void addTacheToProjet(Long idProjet, Tache tache) {
        entityManager.getTransaction().begin();
        try {
            Projet fetchedProjet = entityManager.find(Projet.class, idProjet);
            fetchedProjet.addTache(tache);
            entityManager.merge(fetchedProjet);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void resetTaches(Long idProjet){
        entityManager.getTransaction().begin();

        try{
            Projet projet = entityManager.find(Projet.class, idProjet);
            projet.getTaches().clear();
            entityManager.merge(projet);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}

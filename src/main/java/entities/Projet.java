package entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tache> taches;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Utilisateur> utilisateurs;

    public void addTache(Tache tache){
        if(taches == null)
            taches = new ArrayList<>();
        taches.add(tache);
    }

    public void addUtilisateur(Utilisateur user){
        if(utilisateurs == null)
            utilisateurs = new ArrayList<>();
        utilisateurs.add(user);
    }
}

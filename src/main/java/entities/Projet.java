package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@NamedQuery(
        name = "saveProject",
        query = ""
)
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;

    @OneToMany
    private List<Tache> taches;

    @ManyToMany
    private List<Utilisateur> utilisateurs;

    public void addTache(Tache tache){
        taches.add(tache);
    }
}

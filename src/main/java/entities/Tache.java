package entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Titre;

    @ManyToOne
    private Projet projet;
}

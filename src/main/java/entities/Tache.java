package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Titre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Projet projet;

    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", Titre='" + Titre + '\'' +
                '}';
    }
}

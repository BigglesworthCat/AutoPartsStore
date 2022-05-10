package ua.kriuchkov.autopartsstore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    private Integer id;

    @Column(name = "good_name")
    private String name;

    @OneToMany(mappedBy = "good")
    private Set<Catalogue> catalogue;
}

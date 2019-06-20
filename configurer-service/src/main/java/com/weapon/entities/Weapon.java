package com.weapon.entities;

import lombok.Data;
import org.bouncycastle.math.raw.Mod;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "creators")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;

    @ManyToMany
    @JoinTable(name = "account_roles",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Modification> modifications;
}

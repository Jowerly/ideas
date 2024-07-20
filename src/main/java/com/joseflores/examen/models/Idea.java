package com.joseflores.examen.models;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "idea")
@Getter
@Setter
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre de la idea no puede ser nulo o vacio.")
    private String title;
    @NotEmpty(message = "El contenido no puede estar vacio.")
    private String content;
     @ManyToOne
         @JoinColumn(name = "creator_id")
         private User creator;
    @ManyToMany
    @JoinTable( name = "user_likes_ideas", 
        joinColumns = @JoinColumn(name = "idea_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> usersWhoLiked = new HashSet<>();
    @Transient
    public int getLikes() {
        return usersWhoLiked != null ? usersWhoLiked.size() : 0;
    }
}

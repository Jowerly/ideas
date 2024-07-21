package com.joseflores.examen.models;

import java.time.LocalDateTime;


// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Entity
// @Table(name = "likes")
// @Setter
// @Getter
// @NoArgsConstructor
// @AllArgsConstructor
// public class Like {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;
//     @ManyToOne
//     @JoinColumn(name = "idea_id", nullable = false)
//     private Idea idea;
//     private LocalDateTime createdAt;

//     public Like (User user, Idea idea, LocalDateTime createdAt){
//     this.user = user;
//     this.idea = idea;
//     this.createdAt = createdAt;
//     }
// }

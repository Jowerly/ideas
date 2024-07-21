// package com.joseflores.examen.services;

// import java.time.LocalDateTime;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.joseflores.examen.models.Idea;
// import com.joseflores.examen.models.Like;
// import com.joseflores.examen.models.User;
// import com.joseflores.examen.repositorys.LikeRepository;

// @Service
// public class LikeServices {
//     @Autowired
//     private LikeRepository likeRepository;

//      public Like addLike(User user, Idea idea){
//         if (user != null && idea != null) {
//             Like like = new Like(user, idea, LocalDateTime.now());
//             return likeRepository.save(like);
//         }
//         throw new IllegalArgumentException("User or Idea cannot be null");
//      }
//      public void deleteLike(User user, Idea idea){
//         Like like = likeRepository.findByUserAndIdea(user, idea);
//         if (like != null) {
//             likeRepository.delete(like);
//         }     
//     }
//     public boolean existsByUserAndIdea(User user, Idea idea) {
//         return likeRepository.findByUserAndIdea(user, idea) != null;
//     }
// }

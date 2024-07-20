package com.joseflores.examen.services;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.openssl.pem_password_cb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseflores.examen.models.Idea;
import com.joseflores.examen.models.User;
import com.joseflores.examen.repositorys.IdeaRepository;
import com.joseflores.examen.repositorys.UserRepository;

@Service
public class IdeaService {
    @Autowired
    IdeaRepository ideaRepository;
    @Autowired
    UserRepository userRepository;

    public List<Idea> findAll(){
        return (List<Idea>) ideaRepository.findAll();
    }
    public Idea findIdeaById(Long ideaid){
        Optional<Idea> idea = ideaRepository.findById(ideaid);
            return idea.isPresent() ? idea.get() : null;
    }
    public Idea createIdea(Idea idea){
        return ideaRepository.save(idea);
    }
    public Idea updatedIdea(Idea idea){
        return ideaRepository.save(idea);
    }
    public void DeleteIdea(Long id){
        ideaRepository.deleteById(id);
    }
    public void removeLike (Long ideaid, Long userid){
        Idea idea = ideaRepository.findById(ideaid).orElse(null);
        User user = userRepository.findById(userid).orElse(null);

        if (idea != null && user != null) {
        if (idea.getUsersWhoLiked().contains(user)) {
            idea.getUsersWhoLiked().remove(user);
            ideaRepository.save(idea);
        }
        }
    }

    public void addLike(Long ideaId, Long userId) {
        Idea idea = ideaRepository.findById(ideaId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
    
        if (idea != null && user != null) {
            if (!idea.getUsersWhoLiked().contains(user)) {
                idea.getUsersWhoLiked().add(user);
                ideaRepository.save(idea);
            }
        }
    }
    public List<Idea> findAllByLikesAsc() {
        return ideaRepository.findAllByOrderByUsersWhoLikedAsc();
    }

    public List<Idea> findAllByLikesDesc() {
        return ideaRepository.findAllByOrderByUsersWhoLikedDesc();
    }
}

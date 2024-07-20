package com.joseflores.examen.repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joseflores.examen.models.Idea;

@Repository
public interface IdeaRepository  extends CrudRepository<Idea, Long>{
    List<Idea> findAll();
    List<Idea> findAllByOrderByUsersWhoLikedAsc();
    List<Idea> findAllByOrderByUsersWhoLikedDesc();
}

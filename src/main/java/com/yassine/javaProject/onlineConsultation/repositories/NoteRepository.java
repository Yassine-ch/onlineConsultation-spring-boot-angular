package com.yassine.javaProject.onlineConsultation.repositories;

import com.yassine.javaProject.onlineConsultation.models.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findAll();
}

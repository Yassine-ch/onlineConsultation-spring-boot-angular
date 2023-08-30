package com.yassine.javaProject.onlineConsultation.services;

import com.yassine.javaProject.onlineConsultation.models.Note;
import com.yassine.javaProject.onlineConsultation.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Display all Notes
    public List<Note> allNotes() {
        return noteRepository.findAll();
    }

    // Create a note
    public Note createNote(Note note) {
        return noteRepository.save(note);

    }

    // Find one
    public Note findNote(Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            return null;
        }
    }


    // Delete a note
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    // Update a note
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }
}
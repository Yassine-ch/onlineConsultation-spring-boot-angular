package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Note;
import com.yassine.javaProject.onlineConsultation.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Create One Note
    @PostMapping(value = "/notes")
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note noteCreated = noteService.createNote(note);
        return new ResponseEntity<>(noteCreated, HttpStatus.CREATED);
    }

    // Get All Notes
    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> allNotes = noteService.allNotes();
        return new ResponseEntity<>(allNotes, HttpStatus.OK);
    }

    // Find One Note
    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getOneNote(@PathVariable Long id) {
        Note oneNote = noteService.findNote(id);
        return new ResponseEntity<>(oneNote, HttpStatus.OK);
    }

    // Update One Note
    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateOneNote(@PathVariable Long id, @RequestBody Note note) {
        Note existingNote = noteService.findNote(id);
        if (existingNote != null) {
            existingNote.setNote(note.getNote());
            Note updatedNote = noteService.updateNote(note);
            return new ResponseEntity<>(updatedNote, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a consultation by ID
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package com.example.hw_spring_06.service;

import com.example.hw_spring_06.model.Note;
import com.example.hw_spring_06.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Note note = getNoteById(id).orElseThrow();
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}

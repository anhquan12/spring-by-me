package com.example.demo.controller;

import com.example.demo.entities.Note;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class NoteController {
    @Autowired
    private NotesRepository notesRepository;

    //Get All Notes
    @RequestMapping(value="/notes", method=RequestMethod.GET)
    public List<Note> getAllNotes(){
        return notesRepository.findAll();
    }

    //Create a new Note
    @RequestMapping(value="/notes" , method = RequestMethod.POST)
    public Note createdNote(@Valid @RequestBody Note note) {
        return notesRepository.save(note);
    }

    //Get a Single Note

    //@PathVariable chú thích, như tên cho thấy, được sử dụng để ràng buộc một biến con đường với một tham số phương pháp.
    //Trong phương pháp trên, chúng tôi đang ném một ResourceNotFoundExceptionbất cứ khi nào một Notevới id đã cho không được tìm thấy.
    //Điều này sẽ khiến Spring Boot trả về lỗi 404 Not Found cho máy khách (Hãy nhớ rằng,
    // chúng tôi đã thêm @ResponseStatus(value = HttpStatus.NOT_FOUND)chú thích vào ResourceNotFoundExceptionlớp).
    @RequestMapping(value = "/notes/{id}" , method = RequestMethod.GET)
    public Note getByNoteId(@PathVariable(value = "id") long noteId) {
        return notesRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note" , "id" , noteId));

    }

    // Update a Note
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.PUT)
    public Note updateNote(@PathVariable(value = "id") long noteId, @Valid @RequestBody Note noteDetails) {
        Note note = notesRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updateNote = notesRepository.save(note);
        return updateNote;
    }

    // Delete a Note
    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public  ResponseEntity<?> deleteNote(@PathVariable(value = "id") long noteId)  {
        Note note = notesRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
                notesRepository.delete(note);
            return ResponseEntity.ok().build();
    }
}

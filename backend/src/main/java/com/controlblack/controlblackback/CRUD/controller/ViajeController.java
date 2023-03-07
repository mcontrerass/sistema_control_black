package com.controlblack.controlblackback.CRUD.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlblack.controlblackback.CRUD.dto.ViajeDto;
import com.controlblack.controlblackback.CRUD.entity.Viaje;
import com.controlblack.controlblackback.CRUD.global.dto.MessageDto;
import com.controlblack.controlblackback.CRUD.global.exceptions.AttributeException;
import com.controlblack.controlblackback.CRUD.global.exceptions.ResourceNotFoundException;
import com.controlblack.controlblackback.CRUD.service.ViajeService;

@RestController
@RequestMapping("/viaje")
@CrossOrigin
public class ViajeController {
    @Autowired
    ViajeService viajeService;

    @GetMapping
    public ResponseEntity<List<Viaje>> getAll() {
        return ResponseEntity.ok(viajeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viaje> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(viajeService.getOne(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody ViajeDto dto) throws AttributeException {
        Viaje viaje = viajeService.save(dto);
        String message = "Viaje " + viaje.getBeetrack() + " guardado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") int id, @Valid @RequestBody ViajeDto dto) throws ResourceNotFoundException, AttributeException {
        Viaje viaje = viajeService.update(id, dto);
        String message = "Viaje " + viaje.getBeetrack() + " actualizado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        Viaje viaje = viajeService.delete(id);
        String message = "Viaje " + viaje.getBeetrack() + " eliminado";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}

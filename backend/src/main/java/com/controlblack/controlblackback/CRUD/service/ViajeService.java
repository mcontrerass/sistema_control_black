package com.controlblack.controlblackback.CRUD.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlblack.controlblackback.CRUD.dto.ViajeDto;
import com.controlblack.controlblackback.CRUD.entity.Viaje;
import com.controlblack.controlblackback.CRUD.global.exceptions.AttributeException;
import com.controlblack.controlblackback.CRUD.global.exceptions.ResourceNotFoundException;
import com.controlblack.controlblackback.CRUD.repository.ViajeRepository;

@Service
public class ViajeService {
    @Autowired
    ViajeRepository viajeRepository;

    public List<Viaje> getAll() {
        return viajeRepository.findAll();
    }
    
    public Viaje getOne(int id) throws ResourceNotFoundException {
        return viajeRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Viaje no encontrado"));
    }

    public Viaje save(ViajeDto dto) throws AttributeException {
        if(viajeRepository.existsByBeetrack(dto.getBeetrack()))
            throw new AttributeException("Viaje ya existe");
        int id = autoIncrement();
        Viaje viaje = new Viaje(id, dto.getConductor(), dto.getPatente(), dto.getPeriodo(), dto.getFecha(), dto.getDestino(), dto.getBeetrack(), dto.getPrecio());
        return viajeRepository.save(viaje);
    }

    public Viaje update(int id, ViajeDto dto) throws ResourceNotFoundException, AttributeException {
        Viaje viaje = viajeRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Viaje no encontrado"));
        if(viajeRepository.existsByBeetrack(dto.getBeetrack()) && viajeRepository.findByBeetrack(dto.getBeetrack()).get().getId() != id)
            throw new AttributeException("Viaje ya existe");
        viaje.setBeetrack(dto.getBeetrack());
        viaje.setPrecio(dto.getPrecio());
        return viajeRepository.save(viaje);
    }

    public Viaje delete(int id) throws ResourceNotFoundException {
        Viaje viaje = viajeRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Viaje no encontrado"));
        viajeRepository.delete(viaje);
        return viaje;
    }

    //private methods
    private int autoIncrement() {
        List<Viaje> viajes = viajeRepository.findAll();
        return viajes.isEmpty()? 1 :
                viajes.stream().max(Comparator.comparing(Viaje::getId)).get().getId() + 1;
    }
}

package com.Cattyreminder.cattyreminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Cattyreminder.cattyreminder.service.ServiceDTO;

/**
 * In questa classe sono implementati tutti i metodi di CRUD dei Controller, paramentrizzati dal tipo
 * generico. Nella classe viene dichiarata l'interfaccia ServiceDTO<DTO>.
 *
 * @author Vittorio Valent & Girolamo Murdaca
 *
 *@param <DTO>
 *

 *
 * @see ServiceDTO<DTO>
 */
public abstract class AbstractController <DTO>{

    @Autowired
    private ServiceDTO<DTO> service;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<Iterable<DTO>>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") long id) {

        if(service.existsById(id)){
            service.delete(id);
            return new ResponseEntity<String>("Cancellazione andata a buon fine!", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Nessuna occorrenza trovata", HttpStatus.NOT_FOUND);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody DTO dto){
        try{
            return new ResponseEntity<DTO>((DTO)service.update(dto), HttpStatus.OK);

        }catch(IllegalArgumentException ex){
            return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insert (@RequestBody DTO dto) {
        try{
            return new ResponseEntity<DTO>((DTO)service.insert(dto), HttpStatus.OK);

        }catch(IllegalArgumentException ex){
            return new ResponseEntity<String>(ex.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<?> read(long id) {
        if(service.existsById(id))
            return new ResponseEntity<DTO>((DTO)service.read(id), HttpStatus.OK);

        return new ResponseEntity<String>("Nessuna occorrenza trovata", HttpStatus.NOT_FOUND);
    }
}
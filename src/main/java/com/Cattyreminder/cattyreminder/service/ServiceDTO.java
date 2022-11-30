package com.Cattyreminder.cattyreminder.service;

import org.springframework.http.ResponseEntity;

/**
 * Questa interfaccia firma i metodi dei Service. Osservare che, a differenza di
 * AbstactService, dipende solo dal parametro DTO.
 *
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @param <DTO>
 *
 * @see AbstractService
 */
public interface ServiceDTO<DTO> {

    public Iterable<DTO> getAll();

    public DTO read(long id);

    public DTO insert (DTO dto);

    public DTO update (DTO dto);

    public void delete (long id);

    public boolean existsById(long id);
}

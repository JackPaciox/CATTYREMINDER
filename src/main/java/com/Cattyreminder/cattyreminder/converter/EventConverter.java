package com.Cattyreminder.cattyreminder.converter;

import com.Cattyreminder.cattyreminder.dto.EventDTO;
import com.Cattyreminder.cattyreminder.dto.TaskDTO;
import com.Cattyreminder.cattyreminder.model.Event;
import com.Cattyreminder.cattyreminder.model.Task;

public class EventConverter extends AbstractConverter<Event, EventDTO>{

    @Override
    public Event toEntity(EventDTO eventDTO) {
        Event event = null;
        if (eventDTO != null) {
            event = new Event(eventDTO.getId(), eventDTO.getLink(), eventDTO.getDate(), eventDTO.getDuration(), eventDTO.getUsers());
        }
		return event;
    }

    @Override
    public EventDTO toDTO(Event event) {
        EventDTO eventDTO = null;
        if (event != null) {
            eventDTO = new EventDTO(event.getId(), event.getLink(), event.getDate(), event.getDuration(), event.getUsers());
        }
        return eventDTO;
    }
}

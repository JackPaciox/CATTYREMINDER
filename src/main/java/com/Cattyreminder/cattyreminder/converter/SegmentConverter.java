package com.Cattyreminder.cattyreminder.converter;

import com.Cattyreminder.cattyreminder.dto.SegmentDTO;
import com.Cattyreminder.cattyreminder.model.Segment;

public class SegmentConverter extends AbstractConverter<Segment, SegmentDTO>{

    @Override
    public Segment toEntity(SegmentDTO segmentDTO) {
        Segment segment = null;
        if (segmentDTO != null) {
            segment = new Segment(segmentDTO.getId(),segmentDTO.getState(),segmentDTO.getName(), segmentDTO.getDescription(), segmentDTO.getStartDate(),segmentDTO.getEndDate(),segmentDTO.getStatus(),segmentDTO.getProject(),segmentDTO.getResources(),segmentDTO.getTasks());
        }
		return segment;
    }

    @Override
    public SegmentDTO toDTO(Segment segment) {
        SegmentDTO segmentDTO = null;
        if (segment != null) {
            segmentDTO = new SegmentDTO(segment.getId(),segment.getState(), segment.getName(), segment.getDescription(), segment.getStartDate(),segment.getEndDate(),segment.getProject(),segment.getStatus(),segment.getResources(),segment.getTasks());
        }
        return segmentDTO;
    }
}

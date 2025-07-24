package com.example.electronics.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

import com.example.electronics.dto.PageableResponse;

public class Helper {

    public static <U, V> PageableResponse<V> getPageableResponse(Page<U> page, Class<V> type) {

        ModelMapper modelMapper = new ModelMapper();

        List<U> entity = page.getContent();
        List<V> dtoList = entity.stream()
                                .map(object -> modelMapper.map(object, type))
                                .collect(Collectors.toList());

        PageableResponse<V> response = new PageableResponse<>();
        response.setContent(dtoList);
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLastPages(page.isLast());

        return response;
    }
}

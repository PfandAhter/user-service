package com.hotelreservation.userservice.rest.service;

import com.hotelreservation.userservice.rest.service.interfaces.IMapperService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MapperService implements IMapperService {

    private final ModelMapper modelMapper;

    @Override
    public <T,D> List<D> modelMapper(List<T> source , Class<D> destination){
        List<D> target = new ArrayList<>();
        for( T element : source){
            target.add(modelMapper.map(element,destination));
        }
        return target;
    }
}

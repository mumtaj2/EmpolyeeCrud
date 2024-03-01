package com.company.service.Impl;
;
import com.company.Exception.ResourceNotFoundException;
import com.company.entity.Empolyee;
import com.company.payload.EmpolyeeDto;
import com.company.repository.EmpolyeeRepository;
import com.company.service.EmpolyeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpolyeeServiceImpl implements EmpolyeeService {
    @Autowired
    private EmpolyeeRepository empolyeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmpolyeeDto createEmpolyee(EmpolyeeDto empolyeeDto) {
        Empolyee empolyee= mapToEntity(empolyeeDto);

        Empolyee saved = empolyeeRepository.save(empolyee);
        EmpolyeeDto dto =mapToDto(saved);
        return dto;
    }
    @Override
    public EmpolyeeDto getEmpolyeeById(Long id) {
    Empolyee empolyee=empolyeeRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Employee is not updated "+id)
    );
    EmpolyeeDto dto=mapToDto(empolyee);
        return dto;
    }
    @Override
    public List<EmpolyeeDto> getAllEmployee() {
    List<Empolyee> empolyees= empolyeeRepository.findAll();
    List<EmpolyeeDto> empolyeeDtos= empolyees.stream().map(empolyee -> mapToDto(empolyee)).collect(Collectors.toList());
        return empolyeeDtos;
    }

    @Override
    public EmpolyeeDto updateEmployee(long id, EmpolyeeDto empolyeeDto) {
        Empolyee empolyee= empolyeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Empolyee is not here: " +id)
        );
        empolyee.setName(empolyeeDto.getName());
        empolyee.setSalary(empolyeeDto.getSalary());
        empolyee.setContent(empolyeeDto.getContent());

        Empolyee updateEmpolyee = empolyeeRepository.save(empolyee);

        EmpolyeeDto dto=mapToDto(updateEmpolyee);
        return dto;
    }
    @Override
    public void deleteEmpolyee(long id) {
        empolyeeRepository.deleteById(id);
    }
    @Override
    public void deleteAllEmpolyee() {
        empolyeeRepository.deleteAll();
    }
    EmpolyeeDto mapToDto(Empolyee empolyee) {
        EmpolyeeDto dto = modelMapper.map(empolyee, EmpolyeeDto.class);
        return dto;
    }
    Empolyee mapToEntity(EmpolyeeDto empolyeeDto){
        Empolyee empolyee = modelMapper.map(empolyeeDto, Empolyee.class);
        return empolyee;
    }

}
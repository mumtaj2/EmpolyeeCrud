package com.company.service;

import com.company.payload.EmpolyeeDto;

import java.util.List;

public interface EmpolyeeService {

    EmpolyeeDto createEmpolyee(EmpolyeeDto empolyeeDto);
    EmpolyeeDto getEmpolyeeById(Long id);

    List<EmpolyeeDto> getAllEmployee();

    EmpolyeeDto updateEmployee(long id, EmpolyeeDto empolyeeDto);

    void deleteEmpolyee(long id);

    void deleteAllEmpolyee();
}

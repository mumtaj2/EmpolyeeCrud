package com.company.controller;

import com.company.payload.EmpolyeeDto;
import com.company.service.EmpolyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmpolyeeController {

  @Autowired
  private EmpolyeeService empolyeeService;
  @PostMapping    //http://localhost:9090/api/employee
  public ResponseEntity<EmpolyeeDto> createEmpolyee(@RequestBody EmpolyeeDto empolyeeDto){
  EmpolyeeDto dto=empolyeeService.createEmpolyee(empolyeeDto);
  return new ResponseEntity<>(dto, HttpStatus.CREATED);
}
    @GetMapping("/{id}")      //http:localhost:9090/api/employee
    public ResponseEntity<EmpolyeeDto> getEmpolyeeById(@PathVariable ("id") Long id){
    EmpolyeeDto dto =empolyeeService.getEmpolyeeById(id);
    return new ResponseEntity<>(dto,HttpStatus.OK);
  }
    @GetMapping
    public ResponseEntity<List<EmpolyeeDto>> getAllEmployee(){
      List<EmpolyeeDto> empolyeeDto=empolyeeService.getAllEmployee();
      return new ResponseEntity<>(empolyeeDto, HttpStatus.OK);
  }
    @PutMapping("/{id}")
    public ResponseEntity<EmpolyeeDto> updateEmployee(@PathVariable ("id") long id, @RequestBody EmpolyeeDto empolyeeDto){
    EmpolyeeDto dto= empolyeeService.updateEmployee(id,empolyeeDto);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpolyee(@PathVariable ("id") long id){
    empolyeeService.deleteEmpolyee(id);
    return new ResponseEntity<>("employee is deleted" , HttpStatus.OK);
  }
  @DeleteMapping
  public ResponseEntity<String> deleteAllEmpolyee(){
    empolyeeService.deleteAllEmpolyee();
    return new ResponseEntity<>("All Empolyee Id is Deleted" , HttpStatus.OK);
  }
  }
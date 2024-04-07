package com.example.controllers;

import com.example.entities.HistorialEntity;
import com.example.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/historial")
@CrossOrigin("*")
public class HistorialController {

    @Autowired
    HistorialService historialService;

    @GetMapping("/{id}")
    public ResponseEntity<HistorialEntity> getHistorialPorID(@PathVariable long id) {
        HistorialEntity historial = historialService.getHistorialByid(id);
        if (historial != null) {
            return ResponseEntity.ok(historial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<HistorialEntity> guardarHistorial(@RequestBody HistorialEntity historial) {
        HistorialEntity nuevoHistorial = historialService.guardarHistorial(historial);
        return ResponseEntity.ok(nuevoHistorial);
    }

//
//    @PutMapping("/")
//    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee){
//        EmployeeEntity employeeUpdated = employeeService.updateEmployee(employee);
//        return ResponseEntity.ok(employeeUpdated);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id) throws Exception {
//        var isDeleted = employeeService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
}
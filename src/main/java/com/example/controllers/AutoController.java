package com.example.controllers;

import com.example.entities.AutoEntity;
import com.example.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/autos")
@CrossOrigin("*")
public class AutoController {

    @Autowired
    AutoService autoService;

    @GetMapping("/{patente}")
    public ResponseEntity<AutoEntity> getAutoByPatente(@PathVariable String patente) {
        AutoEntity auto = autoService.getAutoByPatente(patente);
        if (auto != null) {
            return ResponseEntity.ok(auto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<AutoEntity> guardarAuto(@RequestBody AutoEntity auto) {
        AutoEntity nuevoAuto = autoService.guardarAuto(auto);
        return ResponseEntity.ok(nuevoAuto);
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
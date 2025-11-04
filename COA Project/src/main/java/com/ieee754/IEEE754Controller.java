package com.ieee754;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ieee754")
@CrossOrigin(origins = "*") // Allow requests from any origin (for development)
public class IEEE754Controller {
    
    @GetMapping("/convert")
    public ResponseEntity<IEEE754Calculator.FloatResult> convert(
            @RequestParam("number") double number,
            @RequestParam("format") int format) {
        
        IEEE754Calculator.FloatResult result;
        
        if (format == 32) {
            result = IEEE754Calculator.convertToFloat32((float) number);
        } else if (format == 64) {
            result = IEEE754Calculator.convertToFloat64(number);
        } else {
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(result);
    }
    
    @PostMapping("/convert")
    public ResponseEntity<IEEE754Calculator.FloatResult> convertPost(
            @RequestBody ConvertRequest request) {
        
        IEEE754Calculator.FloatResult result;
        
        if (request.getFormat() == 32) {
            result = IEEE754Calculator.convertToFloat32((float) request.getNumber());
        } else if (request.getFormat() == 64) {
            result = IEEE754Calculator.convertToFloat64(request.getNumber());
        } else {
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("{\"status\":\"healthy\",\"message\":\"IEEE 754 Calculator API is running\"}");
    }
    
    // Request DTO for POST requests
    static class ConvertRequest {
        private double number;
        private int format;
        
        public double getNumber() {
            return number;
        }
        
        public void setNumber(double number) {
            this.number = number;
        }
        
        public int getFormat() {
            return format;
        }
        
        public void setFormat(int format) {
            this.format = format;
        }
    }
}
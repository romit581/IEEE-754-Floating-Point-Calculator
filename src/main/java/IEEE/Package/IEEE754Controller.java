package IEEE.Package;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ieee754")
@CrossOrigin(origins = "*")
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

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("{\"status\":\"healthy\"}");
    }
}
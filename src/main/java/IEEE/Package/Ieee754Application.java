package IEEE.Package;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ieee754Application {
	public static void main(String[] args) {
		SpringApplication.run(Ieee754Application.class, args);
		System.out.println("IEEE 754 Calculator API is running on http://localhost:8080");
	}
}

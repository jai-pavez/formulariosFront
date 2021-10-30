package cl.jaime.webtest.formulariosFront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "cl.jaime.webtest.formulariosFront")
public class FormulariosFrontApplication extends SpringBootServletInitializer {

	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FormulariosFrontApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(FormulariosFrontApplication.class, args);
	}

}

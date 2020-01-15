package com.wildcodechool.doctorsSite;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class DoctorsSiteApplication {
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DoctorsSiteApplication.class, args);
	}

	@RequestMapping("/doctor/{incarnation_number}")
	@ResponseBody
	public String doctors(@PathVariable int incarnation_number) throws Exception {
		if (incarnation_number == 9) {
			return "{\"number\": 9, \"name\": \"Christopher Eccleston\"}";
		}
		else if (incarnation_number == 10) {
			return "{\"number\": 10, \"name\": \"David Tennant\"}";
		}
		else if (incarnation_number == 11) {
			return "{\"number\": 11, \"name\": \"Matt Smith\"}";
		}
		else if (incarnation_number == 12) {
			return "{\"number\": 12, \"name\": \"Peter Capaldi\"}";
		}
		else if (incarnation_number == 13) {
			return "{\"number\": 13, \"name\": \"Jodie Whittaker\"}";
		}
		
		else if (incarnation_number >= 1 && incarnation_number < 9) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "303 - This is not the doctor you are looking for!");
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 - Impossible to retrieve the incarnation " + incarnation_number + "!");
		}
	}
}
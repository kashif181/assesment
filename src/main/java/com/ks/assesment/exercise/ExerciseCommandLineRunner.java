package com.ks.assesment.exercise;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ks.assesment.exercise.dto.billing.Bill;
import com.ks.assesment.exercise.service.DiscountCalculationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile("!test")
public class ExerciseCommandLineRunner implements CommandLineRunner {
	@Autowired
	DiscountCalculationService discountCalculationService;

	@Override
	public void run(String... args) throws Exception {
		if (args.length != 1) {
			if (log.isInfoEnabled()) {
				log.info("Usage: java -jar your-application.jar /path/to/your/json/file.json");
			}
		}

		String jsonFilePath = args[0];

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		try {

			Bill bill = objectMapper.readValue(new File(jsonFilePath), Bill.class);

			discountCalculationService.calculateNetPayableAmount(bill);

			if (log.isInfoEnabled()) {
				log.info("Calculating Discount");

				log.info(bill.toString());
			}

		} catch (IOException e) {
			if (log.isErrorEnabled()) {
				log.error(e.getMessage());
			}
		}
	}
}

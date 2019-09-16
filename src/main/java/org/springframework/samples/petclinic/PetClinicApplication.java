/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.SpecialityRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	@Autowired
	VetRepository vetRepository;

	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PetClinicApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			log.info("*****************************************************");

			Vet vet1 = new Vet();
			vet1.setFirstName("João");
			vet1.setLastName("Rafael");
			vet1 = vetRepository.save(vet1);

			// Vet vetAux = vetRepository.findOne(vet1.getId());
			// log.info(vetAux.toString());

			Specialty s = specialityRepository.findOne(1);
			vet1.addSpecialty(s);
			vet1 = vetRepository.save(vet1);

			log.info("Find by last name");

			for (Vet v : vetRepository.findByLastName("Rafael")) {
				log.info("Vet: " + v);
			}

			log.info("Find by first_name or last_name");
			for (Vet v : vetRepository.findByFirstNameOrLastName("Rafael", "Rafael")) {
				log.info("Vet: " + v);
			}

			log.info("Find by first_name and last_name");
			for (Vet v : vetRepository.findByFirstNameAndLastName("João", "Rafael")) {
				log.info("Vet: " + v);
			}

			log.info("Find by specialty name");
			for (Vet v : vetRepository.findBySpecialtyName("radiology")) {
				log.info("Vet: " + v);
			}

		};
	}

	@Bean
	public CommandLineRunner demoOwnerRepository(OwnerRepository ownerRepository) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - OwnerRepository");
			log.info("*****************************************************");

			log.info("Filtramos por nome");
			for (Owner o : ownerRepository.findByFirstNameContainingOrLastNameContaining("Edu", "Est")) {
				log.info("Owner: " + o);
			}

			log.info("Filtramos por nome mediante query");
			for (Owner o : ownerRepository.searchOwner("an")) {
				log.info("Owner: " + o);
			}

			log.info("Ordenamos por apelido");
			for (Owner o : ownerRepository.findByOrderByLastName()) {
				log.info("Owner: " + o);
			}

		};

	}

	@Bean
	public CommandLineRunner demoPetRepository(PetRepository petRepository, VisitRepository visitRepository) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - PetRepository");
			log.info("*****************************************************");

			log.info("Filtrar por birth date");
			Date date1 = Date.from(LocalDate.of(1950,1,1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date date2 = Date.from(LocalDate.of(2010,12,31).atStartOfDay(ZoneId.systemDefault()).toInstant());
			for (Pet p : petRepository.findByBirthDateBetweenOrderByBirthDateAsc(date1,date2)) {
				log.info("Pet: " + p);
			}

		
			
			
			Visit v1 = new Visit();
			Visit v2 = new Visit();
			Visit v3 = new Visit();
			v1.setDescription("Visita 44");
			v2.setDescription("Visita 11");
			v3.setDescription("Visita 3135");
			
			v1.setPetId(3);
			v2.setPetId(1);
			v3.setPetId(4);
			v1.setId(14);
			v2.setId(15);
			v3.setId(16);
			
			visitRepository.save(v1);
			visitRepository.save(v2);
			visitRepository.save(v3);
			
			
			log.info("Todas visitas de um pet");
			for (Visit v : visitRepository.findByPetId(3)) {
				log.info("Visit: " + v);
			}
			
			log.info("Filtrar date visita");
			for (Visit v : visitRepository.findTop4ByOrderByDateDesc()) {
				log.info("Visit: " + v);
			}
			

		};
	}
}

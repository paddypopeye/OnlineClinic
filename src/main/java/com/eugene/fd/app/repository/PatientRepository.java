package com.eugene.fd.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eugene.fd.app.domain.Patient;

@Repository
/**
 * <p>PatientRepository interface.</p>
 *
 * @author Eugene Sleator
 * @version $Id: $Id
 */
public interface PatientRepository extends CrudRepository<Patient, Integer> {

	/**
	 * <p>findPatientByEmail.</p>
	 *
	 * @param email a {@link java.lang.String} object.
	 * @return a {@link com.eugene.fd.app.domain.Patient} object.
	 */
	@Query("SELECT p FROM Patient p INNER JOIN p.user u WHERE u.email = :email")
	Patient findPatientByEmail(@Param(value = "email") String email);
}

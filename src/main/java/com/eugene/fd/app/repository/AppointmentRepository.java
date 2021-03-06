package com.eugene.fd.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eugene.fd.app.domain.Appointment;

/**
 * <p>AppointmentRepository interface.</p>
 *
 * @author Eugene Sleator
 * @version $Id: $Id
 */

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}

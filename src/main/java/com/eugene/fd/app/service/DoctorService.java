package com.eugene.fd.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.eugene.fd.app.domain.Appointment;
import com.eugene.fd.app.domain.Doctor;
import com.eugene.fd.app.domain.Specialization;

/**
 * <p>DoctorService interface.</p>
 *
 * @author Eugene Sleator
 * @version $Id: $Id
 */
public interface DoctorService {

	/**
	 * <p>saveDoctor.</p>
	 *
	 * @param doctor a {@link com.eugene.fd.app.domain.Doctor} object.
	 */
	public void saveDoctor(Doctor doctor);

	/**
	 * <p>updateDoctor.</p>
	 *
	 * @param doctor a {@link com.eugene.fd.app.domain.Doctor} object.
	 */
	public void updateDoctor(Doctor doctor);

	/**
	 * <p>getAll.</p>
	 *
	 * @return a list of doctors
	 */
	List<Doctor> getAll();

	/**
	 * <p>findDoctorById.</p>
	 *
	 * @param id a int.
	 * @return Doctor
	 */
	Doctor findDoctorById(int id);

	/**
	 * <p>findDoctorBySpecialization.</p>
	 *
	 * @param specialization a {@link com.eugene.fd.app.domain.Specialization} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Integer, String> findDoctorBySpecialization(Specialization specialization);

	/**
	 * <p>findDoctorByEmail.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @return a {@link com.eugene.fd.app.domain.Doctor} object.
	 */
	Doctor findDoctorByEmail(String name);

	/**
	 * <p>getUpcomingAppointment.</p>
	 *
	 * @param appointmentList a {@link java.util.List} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList);

	/**
	 * <p>getOverdueAppointment.</p>
	 *
	 * @param appointmentList a {@link java.util.List} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList);
}

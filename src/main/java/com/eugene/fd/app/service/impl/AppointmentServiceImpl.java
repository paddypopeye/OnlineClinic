package com.eugene.fd.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.fd.app.domain.Appointment;
import com.eugene.fd.app.domain.AppointmentStatus;
import com.eugene.fd.app.domain.Doctor;
import com.eugene.fd.app.domain.InvoiceStatus;
import com.eugene.fd.app.domain.Patient;
import com.eugene.fd.app.domain.Specialization;
import com.eugene.fd.app.repository.AppointmentRepository;
import com.eugene.fd.app.repository.DoctorRepository;
import com.eugene.fd.app.repository.PatientRepository;
import com.eugene.fd.app.service.AppointmentService;
import com.eugene.fd.app.util.FamilyDoctorUtil;

/**
 * <p>AppointmentServiceImpl class.</p>
 *
 * @author Eugene Sleator
 * @version $Id: $Id
 */

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	/** {@inheritDoc} */
	@Override
	public Map<String, String> getAllSpecialization() {

		Map<String, String> specializations = new HashMap<>();
		for (Specialization specialization : Specialization.values()) {
			specializations.put(specialization.toString(), WordUtils.capitalizeFully(specialization.toString()));
		}

		return specializations;
	}

	/** {@inheritDoc} */
	@Override
	public void saveAppointment(Appointment appointment) {
		Patient patient = patientRepository.findPatientByEmail(FamilyDoctorUtil.getEmail());
		Doctor doctor = doctorRepository.findOne(appointment.getDoctor().getDoctorId());

		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		appointmentRepository.save(appointment);
	}

	/** {@inheritDoc} */
	@Override
	public Appointment getAppointment(Integer id) {
		return appointmentRepository.findOne(id);
	}

	/** {@inheritDoc} */
	@Override
	public void rescheduleAppointment(Appointment appointment) {
		Appointment appToBeUpdated = appointmentRepository.findOne(appointment.getAppointmentId());
		appToBeUpdated.setDate(appointment.getDate());
		appToBeUpdated.setTime(appointment.getTime());
		appToBeUpdated.setDescription(appointment.getDescription());
		appToBeUpdated.setStatus(AppointmentStatus.NEW);

		appointmentRepository.save(appToBeUpdated);
	}

	/** {@inheritDoc} */
	@Override
	public void cancelAppointment(Integer id) {
		Appointment appointment = appointmentRepository.findOne(id);
		this.updateAppointmentStatus(appointment, AppointmentStatus.CANCELED);
	}

	/** {@inheritDoc} */
	@Override
	public void acceptAppointment(Integer id) {
		Appointment appointment = appointmentRepository.findOne(id);
		this.updateAppointmentStatus(appointment, AppointmentStatus.ACCEPTED);

	}

	/** {@inheritDoc} */
	@Override
	public void rejectAppointment(Integer id) {
		Appointment appointment = appointmentRepository.findOne(id);
		this.updateAppointmentStatus(appointment, AppointmentStatus.REJECTED);
	}

	private void updateAppointmentStatus(Appointment appointment, AppointmentStatus status) {
		appointment.setStatus(status);
		appointmentRepository.save(appointment);
	}

	/** {@inheritDoc} */
	@Override
	public void updateAppointment(Appointment appointment) {
		Appointment appointmentToBeUpdated = appointmentRepository.findOne(appointment.getAppointmentId());
		appointmentToBeUpdated.setStatus(AppointmentStatus.COMPLETED);
		appointmentToBeUpdated.getInvoice().setAmount(appointment.getInvoice().getAmount());
		appointmentToBeUpdated.getInvoice().setStatus(InvoiceStatus.PENDING);

		appointmentRepository.save(appointmentToBeUpdated);
	}
}

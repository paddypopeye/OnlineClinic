package com.eugene.fd.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eugene.fd.app.domain.Appointment;
import com.eugene.fd.app.domain.Authority;
import com.eugene.fd.app.domain.AuthorityRole;
import com.eugene.fd.app.domain.Patient;
import com.eugene.fd.app.repository.PatientRepository;
import com.eugene.fd.app.service.PatientService;
import com.eugene.fd.app.util.FamilyDoctorUtil;

/**
 * <p>PatientServiceImpl class.</p>
 *
 * @author Eugene Sleator
 * @version $Id: $Id
 */

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	/** {@inheritDoc} */
	@Override
	public void savePatient(Patient patient) {
		Authority authority = new Authority();
		authority.setAuthorityRole(AuthorityRole.ROLE_PATIENT);
		patient.getUser().getAuthorities().add(authority);

		String encodedPassword = FamilyDoctorUtil.hashPassword(patient.getUser().getPassword());
		patient.getUser().setPassword(encodedPassword);

		patientRepository.save(patient);
	}

	/** {@inheritDoc} */
	@Override
	public Patient findPatientByEmail(String email) {
		return patientRepository.findPatientByEmail(email);
	}

	/** {@inheritDoc} */
	@Override
	public Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList) {
		return FamilyDoctorUtil.mapAppointmentFromList(appointmentList, false);
	}

	/** {@inheritDoc} */
	@Override
	public Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList) {
		return FamilyDoctorUtil.mapAppointmentFromList(appointmentList, true);
	}
}

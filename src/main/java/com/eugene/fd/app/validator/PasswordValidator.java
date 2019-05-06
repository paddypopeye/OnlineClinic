package com.eugene.fd.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eugene.fd.app.domain.Patient;
import com.eugene.fd.app.util.FamilyDoctorConstants;

/**
 * This class is to handle the cross field validation for password and confirm
 * password of {@link com.eugene.fd.app.domain.User}
 *
 * @see {@link com.eugene.fd.app.domain.User}
 * @author Eugene Sleator
 * @version $Id: $Id
 */
public class PasswordValidator implements Validator {

	/** {@inheritDoc} */
	@Override
	public boolean supports(Class<?> clazz) {
		return Patient.class.isAssignableFrom(clazz);
	}

	/** {@inheritDoc} */
	@Override
	public void validate(Object target, Errors errors) {
		Patient patient = (Patient) target;
		if (!patient.getUser().getPassword().equals(patient.getUser().getConfirmPassword())) {
			errors.rejectValue("user.password", FamilyDoctorConstants.PASSWORD_NOTMATCH_VALIDATION);
		}
	}
}

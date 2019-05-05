package com.eugene.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.eugene.fd.app.domain.AppointmentStatus;

/**
 * {@link com.eugene.fd.app.domain.AppointmentStatus} formatter for web application, this allow us to use
 * {@link com.eugene.fd.app.domain.AppointmentStatus} enumeration as a property in our model.
 *
 * @see com.eugene.fd.app.domain.AppointmentStatus
 * @author Toan Quach
 * @version $Id: $Id
 */
public class AppointmentStatusFormatter implements Formatter<AppointmentStatus> {

	/** {@inheritDoc} */
	@Override
	public String print(AppointmentStatus appointmentStatus, Locale locale) {
		return appointmentStatus.name();
	}

	/** {@inheritDoc} */
	@Override
	public AppointmentStatus parse(String text, Locale locale) throws ParseException {
		return AppointmentStatus.valueOf(text);
	}
}

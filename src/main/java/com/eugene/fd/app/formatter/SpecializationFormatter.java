package com.eugene.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.eugene.fd.app.domain.Specialization;

/**
 * {@link com.eugene.fd.app.domain.Specialization} formatter for web application, this allow us to use
 * {@link com.eugene.fd.app.domain.Specialization} enumeration as a property in our model.
 *
 * @see com.eugene.fd.app.domain.Specialization
 * @author Toan Quach
 * @version $Id: $Id
 */
public class SpecializationFormatter implements Formatter<Specialization> {

	/** {@inheritDoc} */
	@Override
	public String print(Specialization specialization, Locale locale) {
		return specialization.name();
	}

	/** {@inheritDoc} */
	@Override
	public Specialization parse(String text, Locale locale) throws ParseException {
		return Specialization.valueOf(text);
	}
}

package com.eugene.fd.app.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.eugene.fd.app.domain.Gender;

/**
 * {@link com.eugene.fd.app.domain.Gender} formatter for web application, this allow us to use Gender
 * enumeration as a property in our model.
 *
 * @see com.eugene.fd.app.domain.Gender
 * @author Eugene Sleator
 * @version $Id: $Id
 */
public class GenderFormatter implements Formatter<Gender> {

	/** {@inheritDoc} */
	@Override
	public String print(Gender gender, Locale locale) {
		return gender.name();
	}

	/** {@inheritDoc} */
	@Override
	public Gender parse(String text, Locale locale) throws ParseException {
		return Gender.valueOf(text);
	}
}

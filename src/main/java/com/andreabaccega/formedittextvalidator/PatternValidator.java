package com.andreabaccega.formedittextvalidator;

import java.util.regex.Pattern;
import android.widget.EditText;

/**
 * Base class for regexp based validators.
 * @see com.andreabaccega.formedittextvalidator.DomainValidator
 * @see com.andreabaccega.formedittextvalidator.EmailValidator
 * @see IpAddressValidator
 * @see com.andreabaccega.formedittextvalidator.PhoneValidator
 * @see com.andreabaccega.formedittextvalidator.WebUrlValidator
 * @see com.andreabaccega.formedittextvalidator.RegexpValidator
 * @author Andrea Baccega <me@andreabaccega.com>
 *
 */
public class PatternValidator extends Validator{
	private Pattern pattern;
	public PatternValidator(String _customErrorMessage, Pattern _pattern) {
		super(_customErrorMessage);
		if (_pattern == null) throw new IllegalArgumentException("_pattern must not be null");
		pattern = _pattern;
	}

	public boolean isValid(EditText et) {
		return pattern.matcher(et.getText()).matches();
	}

}

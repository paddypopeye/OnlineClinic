package com.eugene.fd.app.repository;

import com.eugene.fd.app.domain.User;

/**
 * <p>UserRepositoryCustom interface.</p>
 *
 * @author Eugene Sleator
 * @version $Id: $Id
 */
public interface UserRepositoryCustom {

	/**
	 * Find an user with user's email and password
	 *
	 * @param email
	 *            to be found (aka username)
	 * @param password
	 *            password to be found
	 * @return {@link com.eugene.fd.app.domain.User}
	 */
	User findUserByEmailAndPassword(String email, String password);
}

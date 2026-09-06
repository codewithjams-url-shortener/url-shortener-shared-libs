package io.urlshortener.eventcontracts;

/**
 * The result of a redirect attempt, as recorded in a {@link ClickEvent}.
 */
public enum ClickOutcome {

	/**
	 * The short code resolved to a live link and the redirect was issued.
	 */
	RESOLVED,

	/**
	 * The short code resolved to a link, but it had already passed its {@code expiresAt}.
	 */
	EXPIRED,

	/**
	 * The short code did not match any link in the Links table.
	 */
	NOT_FOUND

}

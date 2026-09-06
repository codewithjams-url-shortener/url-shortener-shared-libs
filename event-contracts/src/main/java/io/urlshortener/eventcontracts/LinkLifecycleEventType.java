package io.urlshortener.eventcontracts;

/**
 * The kind of change a {@link LinkLifecycleEvent} represents, as derived from a DynamoDB Streams record on the
 * Links table.
 */
public enum LinkLifecycleEventType {

	/**
	 * A new link was created.
	 */
	CREATED,

	/**
	 * A new link was created.
	 */
	UPDATED,

	/**
	 * A link was explicitly deleted by its owner or via {@code DELETE /links}.
	 */
	DELETED,

	/**
	 * A link was removed by DynamoDB's TTL, not by an explicit delete.
	 */
	EXPIRED

}

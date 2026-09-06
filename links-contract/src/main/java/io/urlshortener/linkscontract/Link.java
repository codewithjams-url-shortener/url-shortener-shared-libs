package io.urlshortener.linkscontract;

/**
 * The canonical shape of a shortened link, as stored in the DynamoDB Links table.
 *
 * <p>This is a plain data shape only. Each consuming service (url-service, redirect-service)
 * implements and owns its own read/write access against this shape.
 *
 * @param shortCode           The unique short code identifying this link.<br/>It is also the table's partition key.
 * @param longUrl             The destination URL this short code redirects to.
 * @param ownerId             The ID of the authenticated owner of this link, or {@code null} if the link was created
 *                            anonymously (omitted entirely rather than stored as an explicit null in DynamoDB).
 * @param createdAt           The epoch-millisecond timestamp when this link was created.
 * @param expiresAt           The epoch-millisecond timestamp after which this link expires,
 *                            or {@code null} if the link never expires.
 * @param managementTokenHash The hash of the one-time management token required to edit or delete this link<br/>
 *                            PS: The raw token itself is never stored.
 * @param status              The moderation status of this link (e.g. {@code "FLAGGED"}, {@code "DISABLED"}),
 *                            or {@code null} for a normal, unflagged link.
 */
public record Link(
		String shortCode,
		String longUrl,
		String ownerId,
		long createdAt,
		Long expiresAt,
		String managementTokenHash,
		String status
) {
}

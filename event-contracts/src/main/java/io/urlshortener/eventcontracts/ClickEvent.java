package io.urlshortener.eventcontracts;

/**
 * A single redirect attempt against a short link, published by Redirect Service to the {@code click-events} SNS topic
 * and consumed by Analytics for real-time click counting.
 *
 * @param eventId        The unique ID of this event.<br/>It is used by consumers to dedupe on at-least-once delivery.
 * @param shortCode      The short code that was requested.
 * @param timestamp      The epoch-millisecond timestamp at which the redirect attempt occurred.
 * @param outcome        The result of the redirect attempt.
 * @param refererDomain  The domain of the HTTP {@code Referer} header, or {@code null} for direct traffic.
 * @param userAgentRaw   The raw {@code User-Agent} header of the requesting client.
 * @param ipHash         A one-way hash of the requesting client's IP address.
 */
public record ClickEvent(
		String eventId,
		String shortCode,
		long timestamp,
		ClickOutcome outcome,
		String refererDomain,
		String userAgentRaw,
		String ipHash
) {
}

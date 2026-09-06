package io.urlshortener.eventcontracts;

import io.urlshortener.linkscontract.Link;

/**
 * A single change to a link, derived from a DynamoDB Streams record on the Links table.
 *
 * <p>Unlike {@link ClickEvent}, this shape has no independent publisher — DynamoDB Streams is
 * the source, and the Analytics stream processor maps each raw stream record into this shape.
 * {@link LinkLifecycleEventType#EXPIRED EXPIRED} vs. {@link LinkLifecycleEventType#DELETED DELETED} is distinguished by
 * the stream record's {@code userIdentity.principalId} ({@code dynamodb.amazonaws.com} for TTL-driven expiry).
 *
 * @param eventType      The kind of change this event represents.
 * @param oldLink        The link's state before the change, or {@code null} if {@link eventType}
 *                       is {@link LinkLifecycleEventType#CREATED CREATED}.
 * @param newLink        The link's state after the change, or {@code null} if {@link eventType}
 *                       is {@link LinkLifecycleEventType#DELETED DELETED}
 *                       or {@link LinkLifecycleEventType#EXPIRED EXPIRED}.
 * @param sequenceNumber The DynamoDB Streams sequence number<br/>
 *                       It is used by consumers to dedupe on at-least-once delivery.
 */
public record LinkLifecycleEvent(
		LinkLifecycleEventType eventType,
		Link oldLink,
		Link newLink,
		String sequenceNumber
) {
}

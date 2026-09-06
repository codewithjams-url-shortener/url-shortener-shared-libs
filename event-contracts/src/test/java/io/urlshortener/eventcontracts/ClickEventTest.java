package io.urlshortener.eventcontracts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClickEventTest {

	@Test
	void constructor_shouldStoreAllProvidedFields_whenAllFieldsAreNonNull() {
		// Arrange
		final String eventId = "event-1";
		final String shortCode = "abc123";
		final long timestamp = 1_700_000_000_000L;
		final ClickOutcome outcome = ClickOutcome.RESOLVED;
		final String refererDomain = "google.com";
		final String userAgentRaw = "Mozilla/5.0";
		final String ipHash = "hashed-ip";

		// Act
		final ClickEvent clickEvent = new ClickEvent(
				eventId,
				shortCode,
				timestamp,
				outcome,
				refererDomain,
				userAgentRaw,
				ipHash
		);

		// Assert
		assertEquals(eventId, clickEvent.eventId());
		assertEquals(shortCode, clickEvent.shortCode());
		assertEquals(timestamp, clickEvent.timestamp());
		assertEquals(outcome, clickEvent.outcome());
		assertEquals(refererDomain, clickEvent.refererDomain());
		assertEquals(userAgentRaw, clickEvent.userAgentRaw());
		assertEquals(ipHash, clickEvent.ipHash());
	}

	@Test
	void constructor_shouldAllowNullRefererDomain_whenTrafficIsDirect() {
		// Arrange
		final String eventId = "event-1";
		final String shortCode = "abc123";
		final long timestamp = 1_700_000_000_000L;
		final ClickOutcome outcome = ClickOutcome.NOT_FOUND;
		final String userAgentRaw = "Mozilla/5.0";
		final String ipHash = "hashed-ip";

		// Act
		final ClickEvent clickEvent = new ClickEvent(
				eventId,
				shortCode,
				timestamp,
				outcome,
				null,
				userAgentRaw,
				ipHash
		);

		// Assert
		assertNull(clickEvent.refererDomain());
	}

	@Test
	void equals_shouldReturnTrue_whenTwoClickEventsHaveSameFieldValues() {
		// Arrange
		final ClickEvent eventA = new ClickEvent(
				"event-1",
				"abc123",
				1_700_000_000_000L,
				ClickOutcome.EXPIRED,
				"google.com",
				"Mozilla/5.0",
				"hashed-ip"
		);
		final ClickEvent eventB = new ClickEvent(
				"event-1",
				"abc123",
				1_700_000_000_000L,
				ClickOutcome.EXPIRED,
				"google.com",
				"Mozilla/5.0",
				"hashed-ip"
		);

		// Act
		final boolean areEqual = eventA.equals(eventB);

		// Assert
		assertTrue(areEqual);
		assertEquals(eventA.hashCode(), eventB.hashCode());
	}

}

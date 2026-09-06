package io.urlshortener.eventcontracts;

import io.urlshortener.linkscontract.Link;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkLifecycleEventTest {

	@Test
	void constructor_shouldStoreAllProvidedFields_whenAllFieldsAreNonNull() {
		// Arrange
		final LinkLifecycleEventType eventType = LinkLifecycleEventType.UPDATED;
		final Link oldLink = new Link(
				"abc123",
				"https://old-example.com",
				"owner-1",
				1_700_000_000_000L,
				null,
				"hash",
				null
		);
		final Link newLink = new Link(
				"abc123",
				"https://new-example.com",
				"owner-1",
				1_700_000_000_000L,
				null,
				"hash",
				null
		);
		final String sequenceNumber = "seq-1";

		// Act
		final LinkLifecycleEvent event = new LinkLifecycleEvent(
				eventType,
				oldLink,
				newLink,
				sequenceNumber
		);

		// Assert
		assertEquals(eventType, event.eventType());
		assertEquals(oldLink, event.oldLink());
		assertEquals(newLink, event.newLink());
		assertEquals(sequenceNumber, event.sequenceNumber());
	}

	@Test
	void constructor_shouldAllowNullOldLink_whenEventTypeIsCreated() {
		// Arrange
		final LinkLifecycleEventType eventType = LinkLifecycleEventType.CREATED;
		final Link newLink = new Link(
				"abc123",
				"https://example.com",
				"owner-1",
				1_700_000_000_000L,
				null,
				"hash",
				null
		);
		final String sequenceNumber = "seq-1";

		// Act
		final LinkLifecycleEvent event = new LinkLifecycleEvent(
				eventType,
				null,
				newLink,
				sequenceNumber
		);

		// Assert
		assertNull(event.oldLink());
	}

	@Test
	void constructor_shouldAllowNullNewLink_whenEventTypeIsDeleted() {
		// Arrange
		final LinkLifecycleEventType eventType = LinkLifecycleEventType.DELETED;
		final Link oldLink = new Link(
				"abc123",
				"https://example.com",
				"owner-1",
				1_700_000_000_000L,
				null,
				"hash",
				null
		);
		final String sequenceNumber = "seq-1";

		// Act
		final LinkLifecycleEvent event = new LinkLifecycleEvent(
				eventType,
				oldLink,
				null,
				sequenceNumber
		);

		// Assert
		assertNull(event.newLink());
	}

	@Test
	void equals_shouldReturnTrue_whenTwoLinkLifecycleEventsHaveSameFieldValues() {
		// Arrange
		final Link link = new Link(
				"abc123",
				"https://example.com",
				"owner-1",
				1_700_000_000_000L,
				null,
				"hash",
				null
		);
		final LinkLifecycleEvent eventA = new LinkLifecycleEvent(
				LinkLifecycleEventType.CREATED,
				null,
				link,
				"seq-1"
		);
		final LinkLifecycleEvent eventB = new LinkLifecycleEvent(
				LinkLifecycleEventType.CREATED,
				null,
				link,
				"seq-1"
		);

		// Act
		final boolean areEqual = eventA.equals(eventB);

		// Assert
		assertTrue(areEqual);
		assertEquals(eventA.hashCode(), eventB.hashCode());
	}

}

package io.urlshortener;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

	@Test
	void constructor_shouldStoreAllProvidedFields_whenAllFieldsAreNonNull() {
		// Arrange
		final String shortCode = "abc123";
		final String longUrl = "https://example.com";
		final String ownerId = "owner-1";
		final long createdAt = 1_700_000_000L;
		final Long expiresAt = 1_800_000_000L;
		final String managementTokenHash = "hashed-token";
		final String status = "FLAGGED";

		// Act
		final Link link = new Link(
				shortCode,
				longUrl,
				ownerId,
				createdAt,
				expiresAt,
				managementTokenHash,
				status
		);

		// Assert
		assertEquals(shortCode, link.shortCode());
		assertEquals(longUrl, link.longUrl());
		assertEquals(ownerId, link.ownerId());
		assertEquals(createdAt, link.createdAt());
		assertEquals(expiresAt, link.expiresAt());
		assertEquals(managementTokenHash, link.managementTokenHash());
		assertEquals(status, link.status());
	}

	@Test
	void constructor_shouldAllowNullFields_whenOwnerIdExpiresAtAndStatusAreNull() {
		// Arrange
		final String shortCode = "abc123";
		final String longUrl = "https://example.com";
		final long createdAt = 1_700_000_000L;
		final String managementTokenHash = "hashed-token";

		// Act
		final Link link = new Link(
				shortCode,
				longUrl,
				null,
				createdAt,
				null,
				managementTokenHash,
				null
		);

		// Assert
		assertNull(link.ownerId());
		assertNull(link.expiresAt());
		assertNull(link.status());
	}

	@Test
	void equals_shouldReturnTrue_whenTwoLinksHaveSameFieldValues() {
		// Arrange
		final Link linkA = new Link(
				"abc123",
				"https://example.com",
				"owner-1",
				1_700_000_000L,
				null,
				"hash",
				null
		);
		final Link linkB = new Link(
				"abc123",
				"https://example.com",
				"owner-1",
				1_700_000_000L,
				null,
				"hash",
				null
		);

		// Act
		boolean areEqual = linkA.equals(linkB);

		// Assert
		assertTrue(areEqual);
		assertEquals(linkA.hashCode(), linkB.hashCode());
	}

}

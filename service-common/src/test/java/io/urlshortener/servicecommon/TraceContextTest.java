package io.urlshortener.servicecommon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraceContextTest {

	@Test
	void constructor_shouldStoreAllProvidedFields_whenAllFieldsAreNonNull() {
		// Arrange
		final String traceParent = "00-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01";
		final String traceState = "vendor=value";
		final String correlationId = "correlation-1";

		// Act
		final TraceContext traceContext = new TraceContext(
				traceParent,
				traceState,
				correlationId
		);

		// Assert
		assertEquals(traceParent, traceContext.traceParent());
		assertEquals(traceState, traceContext.traceState());
		assertEquals(correlationId, traceContext.correlationId());
	}

	@Test
	void constructor_shouldAllowNullTraceState_whenNoVendorStateIsPresent() {
		// Arrange
		final String traceParent = "00-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01";
		final String correlationId = "correlation-1";

		// Act
		final TraceContext traceContext = new TraceContext(
				traceParent,
				null,
				correlationId
		);

		// Assert
		assertNull(traceContext.traceState());
	}

	@Test
	void equals_shouldReturnTrue_whenTwoTraceContextsHaveSameFieldValues() {
		// Arrange
		final TraceContext contextA = new TraceContext(
				"00-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01",
				"vendor=value",
				"correlation-1"
		);
		final TraceContext contextB = new TraceContext(
				"00-4bf92f3577b34da6a3ce929d0e0e4736-00f067aa0ba902b7-01",
				"vendor=value",
				"correlation-1"
		);

		// Act
		final boolean areEqual = contextA.equals(contextB);

		// Assert
		assertTrue(areEqual);
		assertEquals(contextA.hashCode(), contextB.hashCode());
	}

}

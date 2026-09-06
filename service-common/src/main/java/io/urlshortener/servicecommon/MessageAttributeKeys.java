package io.urlshortener.servicecommon;

/**
 * The message-attribute key names used to propagate trace context and correlation IDs across hops that don't carry
 * HTTP headers (SNS/SQS, DynamoDB Streams).
 *
 * <p>{@link TRACE_PARENT} and {@link TRACE_STATE} reuse the standard W3C Trace Context header names as-is,
 * since OpenTelemetry already produces values in that format.<br/>
 * Each service is responsible for reading/writing them under these exact keys so traces stitch together across service
 * boundaries.
 */
public class MessageAttributeKeys {

	/**
	 * The message-attribute key carrying the W3C {@code traceparent} value.
	 */
	public static final String TRACE_PARENT = "traceparent";

	/**
	 * The message-attribute key carrying the W3C {@code tracestate} value, when present.
	 */
	public static final String TRACE_STATE = "tracestate";

	/**
	 * The message-attribute key carrying the app-level correlation ID used for log correlation.
	 */
	public static final String CORRELATION_ID = "correlationId";

	private MessageAttributeKeys() {
	}

}

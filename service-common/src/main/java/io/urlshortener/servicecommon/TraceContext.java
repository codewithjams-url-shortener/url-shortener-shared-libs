package io.urlshortener.servicecommon;

/**
 * The plain shape carrying trace context and correlation ID across a message-attribute hop (SNS/SQS, DynamoDB Streams).
 * Each service reads/writes this shape's fields under the corresponding {@link MessageAttributeKeys} constants —
 * no Micrometer/OpenTelemetry dependency lives here.<br/>
 * Each service implements and owns its own actual instrumentation against this shape.
 *
 * @param traceParent   The W3C {@code traceparent} value ({@code 00-<trace-id>-<parent-id>-<flags>})
 * @param traceState    The W3C {@code tracestate} value, or {@code null} if not present
 * @param correlationId The app-level correlation ID used for log correlation.
 */
public record TraceContext(
		String traceParent,
		String traceState,
		String correlationId
) {
}

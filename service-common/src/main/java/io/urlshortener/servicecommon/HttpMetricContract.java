package io.urlshortener.servicecommon;

/**
 * The names of the metrics each service publishes to CloudWatch so that the per-service 5xx-rate alarm can back the
 * AppConfig automatic rollback (ADR-0011).
 *
 * <p>Each service publishes two counts per minute under {@link #NAMESPACE}, dimensioned by {@link #SERVICE_DIMENSION}
 * with its own name: how many responses it sent ({@link #HTTP_REQUEST_COUNT}) and how many of those were 5xx
 * ({@link #HTTP_5XX_COUNT}). The alarm in {@code url-shortener-infra} divides one by the other, so these names must
 * match its {@code cloudwatch-alarm} module's defaults exactly.<br/>
 * This class holds only the names. Publishing them is each service's job, which keeps this library free of any AWS or
 * metrics dependency.
 */
public class HttpMetricContract {

	/**
	 * The CloudWatch namespace every service publishes these metrics to.
	 */
	public static final String NAMESPACE = "UrlShortener";

	/**
	 * The metric dimension carrying the publishing service's name.
	 */
	public static final String SERVICE_DIMENSION = "Service";

	/**
	 * The metric counting the 5xx responses a service sent in a period.
	 */
	public static final String HTTP_5XX_COUNT = "Http5xxCount";

	/**
	 * The metric counting all the responses a service sent in a period, whatever their status.
	 */
	public static final String HTTP_REQUEST_COUNT = "HttpRequestCount";

	private HttpMetricContract() {
	}

}

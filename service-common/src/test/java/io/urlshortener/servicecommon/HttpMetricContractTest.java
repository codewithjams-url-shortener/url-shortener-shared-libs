package io.urlshortener.servicecommon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HttpMetricContractTest {

	@Test
	void constants_shouldMatchTheInfraAlarmModuleDefaults_whenReadByAService() {
		// Arrange & Act & Assert
		// The cloudwatch-alarm module in url-shortener-infra defaults to these exact strings. Changing one here without
		// changing it there leaves the alarm reading a metric nobody publishes, so a rollback would never fire.
		assertEquals("UrlShortener", HttpMetricContract.NAMESPACE);
		assertEquals("Service", HttpMetricContract.SERVICE_DIMENSION);
		assertEquals("Http5xxCount", HttpMetricContract.HTTP_5XX_COUNT);
		assertEquals("HttpRequestCount", HttpMetricContract.HTTP_REQUEST_COUNT);
	}

	@Test
	void metricNames_shouldBeDistinct_whenBothCountsAreReadTogether() {
		// Arrange & Act & Assert
		// Equal names would make the alarm divide a count by itself, a permanent 100%.
		assertNotEquals(HttpMetricContract.HTTP_5XX_COUNT, HttpMetricContract.HTTP_REQUEST_COUNT);
	}

}

description = """
	Plain data shape for the Links DynamoDB table, shared between url-service and redirect-service.
	""".trimIndent()

plugins {
	`java-library`
}

dependencies {
	testImplementation(platform("org.junit:junit-bom:6.1.3"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
	useJUnitPlatform()
}

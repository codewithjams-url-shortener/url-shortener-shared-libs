description = """
	Shared message-attribute key constants and TraceContext shape for cross-service trace propagation.
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

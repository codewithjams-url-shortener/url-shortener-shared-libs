description = """
	ClickEvent and LinkLifecycleEvent DTOs for the Analytics pipeline (SNS click events and DynamoDB Streams CDC).
	""".trimIndent()

plugins {
	`java-library`
}

dependencies {
	api(project(":links-contract"))

	testImplementation(platform("org.junit:junit-bom:6.1.3"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
	useJUnitPlatform()
}

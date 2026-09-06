plugins {
	`java-library`
}

allprojects {
	group = "io.url-shortener"
	version = "0.1.0"

	repositories {
		mavenCentral()
	}
}

subprojects {

	apply(plugin = "java-library")

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(21)
		}
	}

}

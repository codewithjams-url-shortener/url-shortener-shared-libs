import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication

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
	apply(plugin = "maven-publish")

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(21)
		}
	}

	configure<PublishingExtension> {
		publications {
			create<MavenPublication>("maven") {
				from(components["java"])
			}
		}
		repositories {

			maven {

				name = "GitHubPackages"
				url = uri("https://maven.pkg.github.com/codewithjams-url-shortener/url-shortener-shared-libs")

				credentials {
					username = System.getenv("GITHUB_ACTOR") ?: project.findProperty("gpr.user") as String?
					password = System.getenv("GITHUB_TOKEN") ?: project.findProperty("gpr.token") as String?
				}

			}

		}
	}

}

rootProject.name = "gcmd"

plugins {
    id("com.gradle.develocity") version("3.19.2")
}

// publish always
develocity {
    buildScan {
        publishing.onlyIf { true }
        termsOfUseUrl.set("https://gradle.com/help/legal-terms-of-use")
        termsOfUseAgree.set("yes")
    }
}
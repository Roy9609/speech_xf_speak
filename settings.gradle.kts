pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://clife-devops-maven.pkg.coding.net/repository/public-repository/maven-snapshots/")
            credentials {
                username = System.getenv("CODING_USERNAME")
                password = System.getenv("CODING_PASSWORD")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://clife-devops-maven.pkg.coding.net/repository/public-repository/maven-snapshots/")
            credentials {
                username = System.getenv("CODING_USERNAME")
                password = System.getenv("CODING_PASSWORD")
            }
        }
    }


}

rootProject.name = "SpeechXfSpeak"
include(":app")
include(":XfSpeak")

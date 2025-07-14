~~~
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


 dependencies {
	        implementation 'com.clife.speak:XfSpeakSdk:1.0.0'
	}


~~~

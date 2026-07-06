plugins {
    `maven-publish`
}

publishing {
    repositories {
        maven {
            url = uri("https://repo.biomebattle.net/repository/biomebattle-repo/")
            credentials {
                username = System.getenv("BB_REPO_USERNAME")
                password = System.getenv("BB_REPO_PASSWORD")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            version = "${property("mod_version")}"
            from(components["java"])
            pom {
                name = "Noxesium"
                description = "A client-side fabric mod that improves the play experience on large multiplayer servers."
                url = "https://github.com/Noxcrew/noxesium"
                scm {
                    url = "https://github.com/Noxcrew/noxesium"
                    connection = "scm:git:https://github.com/Noxcrew/noxesium.git"
                    developerConnection = "scm:git:https://github.com/Noxcrew/noxesium.git"
                }
                licenses {
                    license {
                        name = "LGPL-3.0"
                        url = "https://www.gnu.org/licenses/lgpl-3.0.html"
                    }
                }
                developers {
                    developer {
                        id = "noxcrew"
                        name = "Noxcrew"
                        email = "contact@noxcrew.com"
                    }
                }
            }
        }
    }
}

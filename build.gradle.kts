plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hibernate:hibernate-core:5.6.15.Final")
    implementation("org.projectlombok:lombok:1.18.28")
    implementation("com.h2database:h2:2.1.214")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
}


application {
    mainClass = "org.example.Main"
}

tasks.test {
    useJUnitPlatform()
}
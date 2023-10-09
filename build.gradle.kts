plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
// https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.8.0")
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
//    <groupId>com.fasterxml.jackson.dataformat</groupId>
//    <artifactId>jackson-dataformat-xml</artifactId>
//    <version>2.11.1</version>
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
}

tasks.test {
    useTestNG()
}
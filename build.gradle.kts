plugins {
    kotlin("multiplatform") version "1.8.0"
}

repositories {
    mavenCentral()
}

kotlin {
    linuxX64 {
        binaries {
            executable(listOf(DEBUG, RELEASE)) {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-Xallocator=std",
                    "-Xoverride-konan-properties=linkerKonanFlags.linux_x64=-lstdc++ -ldl -lm -lpthread --defsym __cxa_demangle=Konan_cxa_demangle --gc-sections",
                )
            }
        }
    }
}

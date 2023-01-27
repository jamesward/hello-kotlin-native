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
            }
        }
        compilations.all {
            compilerOptions.configure {
                freeCompilerArgs.addAll(
                    "-Xallocator=std",
                    """-Xoverride-konan-properties=linkerKonanFlags.linux_x64="-lstdc++ -Bdynamic -ldl -lm -lpthread --defsym __cxa_demangle=Konan_cxa_demangle --gc-sections"""",
                )
            }
        }
    }
}

package io.github.bortoletoeric.movies

class DesktopPlatform : Platform {
    override val name: String = "Desktop (JVM)"
}

actual fun getPlatform(): Platform = DesktopPlatform()

package org.juljimgar.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
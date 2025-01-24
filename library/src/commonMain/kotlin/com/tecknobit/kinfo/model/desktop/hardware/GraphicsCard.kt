package com.tecknobit.kinfo.model.desktop.hardware

interface GraphicsCard {
    val name: String
    val deviceId: String
    val vendor: String
    val versionInfo: String
    val vRam: Long
}
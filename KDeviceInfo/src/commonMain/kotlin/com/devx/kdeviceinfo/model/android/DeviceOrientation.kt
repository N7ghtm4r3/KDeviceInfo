@file:Suppress("PropertyName")

package com.devx.kdeviceinfo.model.android

interface DeviceOrientation {
    val UNKNOWN: String
    val PORTRAIT: String
    val LANDSCAPE: String
    val isPortrait: Boolean
    val isLandscape: Boolean
    fun getDeviceOrientation(): String
}
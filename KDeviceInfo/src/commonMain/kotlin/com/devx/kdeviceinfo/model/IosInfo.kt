package com.devx.kdeviceinfo.model

expect class IosInfo {
    val name: String
    val systemName: String
    val systemVersion: String
    val model: String
    val localizedModel: String
    val identifierForVendor: String
    val isPhysicalDevice: Boolean
    val isMultitaskingSupported: Boolean
    val isGeneratingDeviceOrientationNotifications: Boolean
    val uiDeviceOrientation: UIDeviceOrientation
}
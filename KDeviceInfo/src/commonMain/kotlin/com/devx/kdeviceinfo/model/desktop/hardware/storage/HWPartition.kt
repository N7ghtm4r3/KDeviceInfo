package com.devx.kdeviceinfo.model.desktop.hardware.storage

interface HWPartition {
    val identification: String
    val name: String
    val type: String
    val uuid: String
    val size: Long 
    val major: Int
    val minor: Int
    val mountPoint: String
}
package com.devx.kdeviceinfo.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devx.kdeviceinfo.DeviceInfoState
import com.devx.kdeviceinfo.model.AndroidInfo
import com.devx.kdeviceinfo.model.IosInfo
import com.devx.kdeviceinfo.model.Platform
import com.devx.kdeviceinfo.sample.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun App() = AppTheme {

    val deviceInfoXState by remember { mutableStateOf(value = DeviceInfoState()) }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "KDeviceInfo Sample App") })
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
                .windowInsetsPadding(insets = WindowInsets.safeDrawing),
        ) {
            if (deviceInfoXState.currentPlatform == Platform.ANDROID) {
                ShowAndroidDeviceInfo(deviceInfoXState.androidInfo)
            } else {
                ShowIosDeviceInfo(deviceInfoXState.iosInfo)
            }
        }
    }
}

@Composable
private fun ShowAndroidDeviceInfo(androidInfo: AndroidInfo) {
    val verticalScrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(state = verticalScrollState)) {
        Text(text = "Device : ${androidInfo.device}")
        Text(text = "BaseOs : ${androidInfo.baseOs}")
        Text(text = "Release : ${androidInfo.release}")
        Text(text = "SecurityPatch : ${androidInfo.securityPatch}")
        Text(text = "previewSdkInt : ${androidInfo.previewSdkInt}")
        Text(text = "ReleaseOrCodeName : ${androidInfo.releaseOrCodeName}")
        Text(text = "MediaPerformanceClass : ${androidInfo.mediaPerformanceClass}")
        Text(text = "Incremental : ${androidInfo.incremental}")
        Text(text = "ReleaseOrPreviewDisplay : ${androidInfo.releaseOrPreviewDisplay}")
        Text(text = "CodeName : ${androidInfo.codeName}")
        Text(text = "Board : ${androidInfo.board}")
        Text(text = "Bootloader : ${androidInfo.bootloader}")
        Text(text = "Display : ${androidInfo.display}")
        Text(text = "DisplayWidthPixels : ${androidInfo.displayWidthPixels}")
        Text(text = "DdisplayHeightPixels : ${androidInfo.displayHeightPixels}")
        Text(text = "DisplayWidthInches : ${androidInfo.displayWidthInches}")
        Text(text = "DisplayHeightInches : ${androidInfo.displayHeightInches}")
        Text(text = "DisplayXDpi : ${androidInfo.displayXDpi}")
        Text(text = "DisplayYDpi : ${androidInfo.displayYDpi}")
        Text(text = "Fingerprint : ${androidInfo.fingerprint}")
        Text(text = "Hardware : ${androidInfo.hardware}")
        Text(text = "Host : ${androidInfo.host}")
        Text(text = "Id : ${androidInfo.id}")
        Text(text = "IsPhysicalDevice : ${androidInfo.isPhysicalDevice}")
        Text(text = "Manufacturer : ${androidInfo.manufacturer}")
        Text(text = "Model : ${androidInfo.model}")
        Text(text = "Product : ${androidInfo.product}")
        Text(text = "SdkInt : ${androidInfo.sdkInt}")
//        Text(text = "SerialNumber : ${androidInfo.serialNumber}")
//        Text(text = "SystemFeatureList : ${androidInfo.systemFeatureList}")
        Text(text = "SupportedAbis : ${androidInfo.supportedAbis}")
        Text(text = "Supported32BitAbis : ${androidInfo.supported32BitAbis}")
        Text(text = "Supported64BitAbis : ${androidInfo.supported64BitAbis}")
    }
}

@Composable
private fun ShowIosDeviceInfo(iosInfo: IosInfo) {
    val verticalScrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(state = verticalScrollState)) {
        Text(text = "Name : ${iosInfo.name}")
        Text(text = "Model : ${iosInfo.model}")
        Text(text = "SystemName : ${iosInfo.systemName}")
        Text(text = "SystemVersion : ${iosInfo.systemVersion}")
        Text(text = "LocalizedModel : ${iosInfo.localizedModel}")
        Text(text = "IsPhysicalDevice : ${iosInfo.isPhysicalDevice}")
        Text(text = "IdentifierForVendor : ${iosInfo.identifierForVendor}")
    }
}
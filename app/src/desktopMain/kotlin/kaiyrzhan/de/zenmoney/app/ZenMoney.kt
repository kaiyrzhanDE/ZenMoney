@file:JvmName("ZenMoney")

package kaiyrzhan.de.zenmoney.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

public fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "ZenMoney",
        ) {
            RootScreen(
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
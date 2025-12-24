package kaiyrzhan.de.zenmoney.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

public fun rootViewController(): UIViewController {
    return ComposeUIViewController(
        content = {
            RootScreen(modifier = Modifier.fillMaxSize())
        },
    )
}

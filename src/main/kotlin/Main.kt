// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.omnys.jni.java.NativeHost

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Do get") }

    MaterialTheme {
        Button(onClick = {
            NativeHost().curlGet()
            text = "Get done!"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    //This referes to "libwrapper.dll" that should be available inside C:\Program Files\Java\jdk-17.0.1\bin
    Runtime.getRuntime().loadLibrary("libwrapper")
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

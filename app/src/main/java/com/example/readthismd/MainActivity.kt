package com.example.readthismd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.readthismd.feature_auth.presentation.LoginScreen
import com.example.readthismd.core.ui.theme.ReadThisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReadThisTheme {
                Surface(color = androidx.compose.material3.MaterialTheme.colorScheme.background) {
                    LoginScreen()
                }
            }
        }
    }
}

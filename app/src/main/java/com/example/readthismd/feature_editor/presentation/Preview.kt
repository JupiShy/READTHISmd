package com.example.readthismd.feature_editor.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.readthismd.core.ui.theme.EditorBackground
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.BasicRichText
import com.halilibo.richtext.ui.RichTextThemeProvider

@Composable
fun Preview(text: String){
    Box(
        Modifier
            .fillMaxSize()
            .background(EditorBackground)
    ) {
        RichTextThemeProvider(
            contentColorProvider = {Color.White},
        ) {
            BasicRichText{
                Markdown(content = text)
            }
        }
    }
}
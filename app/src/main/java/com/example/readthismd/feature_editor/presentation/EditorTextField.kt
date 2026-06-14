package com.example.readthismd.feature_editor.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.readthismd.core.ui.theme.CursorColorBlue
import com.example.readthismd.core.ui.theme.EditorBackground
import com.example.readthismd.core.ui.theme.EditorBackgroundFocused

@Composable
fun EditorTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        modifier = modifier.fillMaxSize(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = EditorBackground,
            focusedContainerColor = EditorBackgroundFocused,
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Black,
            cursorColor = CursorColorBlue
        ),
        minLines = 5,
        maxLines = 25,
        textStyle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 18.sp,
            color = Color.White
        )
    )
}
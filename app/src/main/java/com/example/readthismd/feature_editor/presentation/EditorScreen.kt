package com.example.readthismd.feature_editor.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.readthismd.R
import com.example.readthismd.core.ui.theme.EditorBackground


@Composable
fun EditorScreen(
    initialText: String? = null,
    viewModel: EditorViewModel = viewModel()
    ){
    val title = stringResource(R.string.editor_placeholder_title)
    val content = stringResource(R.string.editor_placeholder_content)
    val text by viewModel.markdownText.collectAsState()

    var isEditMode by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        if(viewModel.markdownText.value.isEmpty()) {
            if (initialText != null) {
                viewModel.onTextChanged(initialText)
            } else {
                viewModel.onTextChanged("# $title\n\n$content")
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(EditorBackground)
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ){
            TextButton(onClick = { isEditMode = true }) {
                Text(
                    stringResource(R.string.edit),
                    color = if(isEditMode == true) Color.White else Color.Gray
                )
            }

            Text(" | ", modifier = Modifier.align(Alignment.CenterVertically), color = Color.Gray)

            TextButton(onClick = { isEditMode = false }) {
                Text(
                    stringResource(R.string.preview),
                    color = if(!isEditMode) Color.White else Color.Gray
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize().weight(1f)){
            if (isEditMode){
                EditorTextField(
                    text,
                    onTextChange = { viewModel.onTextChanged(it) },
                    modifier = Modifier.fillMaxSize()
                )
            }else{
                Preview(text)
            }
        }
    }


}
package com.example.readthismd.feature_editor.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EditorViewModel : ViewModel() {
    private val _markdownText = MutableStateFlow("")
    val markdownText = _markdownText.asStateFlow()

    fun onTextChanged(newText: String){
        _markdownText.value = newText
    }
}
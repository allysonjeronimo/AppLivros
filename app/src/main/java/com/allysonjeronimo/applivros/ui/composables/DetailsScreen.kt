package com.allysonjeronimo.applivros.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.allysonjeronimo.applivros.model.Book

@Composable
fun DetailsScreen(book: Book?){

    if(book == null)
        return

    Text(book.title)
}
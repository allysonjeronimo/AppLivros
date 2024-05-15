package com.allysonjeronimo.applivros.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.allysonjeronimo.applivros.R
import com.allysonjeronimo.applivros.model.Book

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    books: List<Book>,
    onBookClick: (Book) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "App Livros")
                },
                colors = topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_10k),
                            contentDescription = null,
                            tint = Color.White
                            )
                            
                    }
                }
            )
        }
    ){
        Column(modifier = Modifier
            .padding(it)
            .verticalScroll(rememberScrollState())){

            for(book in books){
                BookCard(
                    book = book,
                    onClick = { onBookClick(book) }
                )
            }
        }
    }
}

@Composable
fun BookCard(
    book: Book,
    onClick: (Book) -> Unit
){
    Card(modifier = Modifier
        .clickable {
            onClick(book)
        }
        .fillMaxWidth()
        .padding(6.dp)){
        Row(){
            Image(
                painter = painterResource(id = R.drawable.book_01),
                contentDescription = null,
                modifier = Modifier.height(120.dp)
            )
            Column(modifier = Modifier.padding(6.dp)){
                Text(
                    book.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    book.author,
                    maxLines = 1,
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }
    }
}





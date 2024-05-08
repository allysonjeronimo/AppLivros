package com.allysonjeronimo.applivros.ui.composables

import android.media.Image
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.allysonjeronimo.applivros.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun HomeScreen(){
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

            BookCard(title = "Contos de Lovecraft", author = "H.P Lovecraft", image = painterResource(
                id = R.drawable.book_01
            ))

            BookCard(title = "O Hobbit", author = "Tolkien", image = painterResource(
                id = R.drawable.book_03
            ))

            BookCard(title = "Os Filhos de Hurin", author = "Tolkien", image = painterResource(
                id = R.drawable.book_05
            ))
        }
    }
}

@Composable
fun BookCard(
    title: String,
    author: String,
    image: Painter
){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)){
        Row(){
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.height(120.dp)
            )
            Column(modifier = Modifier.padding(6.dp)){
                Text(
                    title,
                    fontSize = 26.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    author,
                    fontSize = 18.sp,
                    maxLines = 1,
                    color = Color.Gray
                )
            }

        }
    }
}





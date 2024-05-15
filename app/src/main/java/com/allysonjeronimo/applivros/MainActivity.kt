package com.allysonjeronimo.applivros

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.allysonjeronimo.applivros.model.Book
import com.allysonjeronimo.applivros.ui.composables.DetailsScreen
import com.allysonjeronimo.applivros.ui.composables.HomeScreen
import com.allysonjeronimo.applivros.ui.theme.AppLivrosTheme

const val HOME_SCREEN = 0
const val DETAILS_SCREEN = 1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppLivrosTheme {

                val books = loadBooks()

                var currentScreen by remember{
                    mutableIntStateOf(HOME_SCREEN)
                }

                var currentBook: Book? = null

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    when(currentScreen){
                        HOME_SCREEN -> {
                            HomeScreen(
                                books = books,
                                onBookClick = { book ->
                                    currentBook = book;
                                    currentScreen = DETAILS_SCREEN
                                }
                            )
                        }
                        DETAILS_SCREEN -> {
                            DetailsScreen(book = currentBook)
                        }
                    }

                }
            }
        }
    }
}

private fun loadBooks(): List<Book> {
    return listOf(
        Book(1, "O Senhor dos Anéis", "J. R. R. Tolkien", ""),
        Book(2, "O Hobbit", "J. R. R. Tolkien", ""),
        Book(3, "Contos de H. P. Lovecraft", "H. P. Lovecraft", ""),
    )
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(loadBooks(), {})
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    DetailsScreen(loadBooks()[0])
}

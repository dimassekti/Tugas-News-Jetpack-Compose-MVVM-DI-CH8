@file:Suppress("RemoveCurlyBracesFromTemplate", "RemoveCurlyBracesFromTemplate",
    "RemoveCurlyBracesFromTemplate"
)

package com.coufie.news_jetpackcompose_mvvm_di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseNewsItem
import com.coufie.news_jetpackcompose_mvvm_di.ui.theme.News_JetpackCompose_MVVM_DITheme

class NewsDetail : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            News_JetpackCompose_MVVM_DITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val title = intent.getStringExtra("title")
                    val author = intent.getStringExtra("author")
                    val createdat = intent.getStringExtra("createdat")
                    val image = intent.getStringExtra("image")
                    var newsSerializable = intent.getSerializableExtra("news") as ResponseNewsItem?
                    Greeting2(title.toString(), author.toString(), createdat.toString(), image.toString())
                }
            }
        }
    }
}

@Composable
fun Greeting2(title: String, author : String, createdat : String, image:String) {
    val mContext = LocalContext.current

    Column(modifier = Modifier
        .padding(15.dp)) {
        Card(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
        ) {


            Row {
                Image(painter = rememberImagePainter(data = image ), contentDescription = null)
                Column(modifier = Modifier
                    .padding(start = 20.dp)
                ) {
                    Text(text = "Title : ${title}")
                    Text(text = "Author : ${author}")
                    Text(text = "createdAt : ${createdat}")
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    News_JetpackCompose_MVVM_DITheme {
    }
}
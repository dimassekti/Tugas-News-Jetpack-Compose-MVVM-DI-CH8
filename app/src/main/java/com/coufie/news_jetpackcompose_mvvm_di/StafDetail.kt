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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseNewsItem
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseStafItem
import com.coufie.news_jetpackcompose_mvvm_di.ui.theme.News_JetpackCompose_MVVM_DITheme

class StafDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailStaf = intent.getSerializableExtra("staf") as ResponseStafItem

        setContent {
            News_JetpackCompose_MVVM_DITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    var name = intent.getStringExtra("stafname")
                    var email = intent.getStringExtra("stafemail")
                    var image = intent.getStringExtra("stafimage")

//                    StafDetail(name.toString(), email.toString(), description.toString(), image.toString())

                    StafDetailSerializable(detailStaf)
                }
            }
        }
    }
}


@Composable
fun StafDetailSerializable(staf : ResponseStafItem) {

    Column(modifier = Modifier
        .padding(15.dp)) {
        Card(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
        ) {

            Column(modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = rememberImagePainter(data = staf.image ), contentDescription = null)
                Text(text = "name : ${staf.name}")
                Text(text = "email : ${staf.email}")
                Text(text = "createdAt : ${staf.createdAt}")
            }
        }

    }
}

@Composable
fun StafDetail(name: String, email:String, description:String, image : String) {
    val mContext = LocalContext.current

    Column(modifier = Modifier
        .padding(15.dp)) {
        Card(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
        ) {


            Row(){
                Image(painter = rememberImagePainter(data = image ), contentDescription = null)
                Column(modifier = Modifier
                    .padding(start = 20.dp)
                ) {
                    Text(text = "name : ${name}")
                    Text(text = "email : ${email}")
                    Text(text = "desc : ${description}")
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    News_JetpackCompose_MVVM_DITheme {

    }
}
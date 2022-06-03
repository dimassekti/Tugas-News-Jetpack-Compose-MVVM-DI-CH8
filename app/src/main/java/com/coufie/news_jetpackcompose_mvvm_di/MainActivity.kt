package com.coufie.news_jetpackcompose_mvvm_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseNewsItem
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseStafItem
import com.coufie.news_jetpackcompose_mvvm_di.ui.theme.News_JetpackCompose_MVVM_DITheme
import com.coufie.news_jetpackcompose_mvvm_di.viewmodel.NewsViewModel
import com.coufie.news_jetpackcompose_mvvm_di.viewmodel.StafViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            News_JetpackCompose_MVVM_DITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentHeight(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsViewModel = viewModel(modelClass = NewsViewModel::class.java)
                    val datanews by newsViewModel.dataState.collectAsState()


                    Column() {
                        DashboardMain()

                        LazyColumn{
                            if(datanews.isEmpty()){
                                item{

                                }
                            }
                            items(datanews){
                                NewsUI(news = it)
                            }
                        }
                    }



                }
            }
        }
    }
}

@Composable
fun DashboardMain(){
    val mContext = LocalContext.current

    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Go to Staf", modifier = Modifier
            .padding(15.dp)
            .clickable {
                val pindah = Intent(mContext, StafListActivity::class.java)

                mContext.startActivity(pindah)
            }

        )
    }


}

@Composable
fun NewsUI(news : ResponseNewsItem) {
    val mContext = LocalContext.current

        Column(modifier = Modifier
            .padding(15.dp)) {
            Card(modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable {
                    val pindah = Intent(mContext, NewsDetail::class.java)
                    pindah.putExtra("image", news.image)
                    pindah.putExtra("title", news.title)
                    pindah.putExtra("author", news.author)
                    pindah.putExtra("createdat", news.createdAt)
                    pindah.putExtra("news", news)
                    mContext.startActivity(pindah)
                }
            ) {
                Row(){
                    Image(painter = rememberImagePainter(data = news.image ), contentDescription = "img", modifier = Modifier
                        .height(50.dp))
                    Column(modifier = Modifier
                        .padding(start = 20.dp)
                        .fillMaxWidth()
                    ) {
                        Text(text = "Title : ${news.title}")
                        Text(text = "Author : ${news.author}")
                        Text(text = "createdAt : ${news.createdAt}")
                    }
                }
            }

        }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    News_JetpackCompose_MVVM_DITheme {

    }
}
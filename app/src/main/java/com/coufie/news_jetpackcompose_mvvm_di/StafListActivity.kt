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
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseStafItem
import com.coufie.news_jetpackcompose_mvvm_di.ui.theme.News_JetpackCompose_MVVM_DITheme
import com.coufie.news_jetpackcompose_mvvm_di.viewmodel.StafViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StafListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            News_JetpackCompose_MVVM_DITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.wrapContentHeight(),
                    color = MaterialTheme.colors.background
                ) {

                    val stafViewModel = viewModel(modelClass = StafViewModel::class.java)
                    val datastaf by stafViewModel.dataState.collectAsState()


                    Column {
                        DashboardStaf()

                        LazyColumn{


                            if(datastaf.isEmpty()){
                                item{

                                }
                            }
                            items(datastaf){
                                StafUI(staf = it )
                            }


                        }
                    }


                }
            }
        }
    }
}

@Composable
fun DashboardStaf(){
    val mContext = LocalContext.current

    Text(text = "Back to Main", modifier = Modifier
        .clickable{
            val pindah = Intent(mContext, MainActivity::class.java)

            mContext.startActivity(pindah)
        }
    )
}



@Composable
fun StafUI(staf : ResponseStafItem) {
    val mContext = LocalContext.current
    Column(modifier = Modifier
        .padding(15.dp)) {
        Card(modifier = Modifier
            .padding(5.dp)
            .height(80.dp)
            .fillMaxWidth()
            .clickable {
                val pindah = Intent(mContext, StafDetail::class.java)
                pindah.putExtra("stafimage", staf.image)
                pindah.putExtra("stafname", staf.name)
                pindah.putExtra("stafemail", staf.email)
                pindah.putExtra("stafdescription", staf.description)

                pindah.putExtra("staf", staf)
                mContext.startActivity(pindah)
            }
        ) {
            Row {
                Image(painter = rememberImagePainter(data = staf.image ), contentDescription = "img", modifier = Modifier
                    .height(50.dp))
                Column(modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth()
                ) {
                    Text(text = "Name : ${staf.name}")
                    Text(text = "Email : ${staf.email}")
                    Text(text = "Description : ${staf.createdAt}")
                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview4() {
    News_JetpackCompose_MVVM_DITheme {
    }
}
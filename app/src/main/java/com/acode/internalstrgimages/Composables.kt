package com.acode.internalstrgimages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


@Composable
fun ImgComposable(imgViewModel: ImgViewModel){
    val list = imgViewModel.listOfImages.collectAsState().value
    
    LazyColumn(){
        items(list){
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)) {
                val painter = rememberAsyncImagePainter(model = it.contentUri)

                Image(painter = painter, contentDescription = it.name)
            }
        }
    }
}
@Composable
fun VideoComposable(imgViewModel: ImgViewModel){
    val list = imgViewModel.listOfVideos.collectAsState().value

    LazyColumn(){
        items(list){
            Text(text = it.contentUri.toString())
        }
    }
}
package com.example.kotlin_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
//by 사용 가능
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

//chapter5
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //전역에서 관리
            var isFavorite by rememberSaveable {
                mutableStateOf(false)
            }
            ImageCard(
                modifier = Modifier
                    .fillMaxWidth(0.5f)/*fraction: 전체에서의 비율*/
                    .padding(16.dp),
                isFavorite = isFavorite,
            ) { favorite ->
                isFavorite = favorite
            }
        }
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit/*전역에서 값 변경을 위한 Callback*/,
) {
    /*Composable에서 상태를 기억하는 변수
    val isFavorite = remember {
        mutableStateOf(false)
    }
    */
    /*.value를 생략하기 위해 by 사용
    var isFavorite by remember {
        mutableStateOf(false)
    }
    */
    /*항상 메모리에 저장되게 하려면 rememberSaveable
    var isFavorite by rememberSaveable {
        mutableStateOf(false)
    }
    */

    //카드 모양 뷰
    Card(
        modifier = modifier/*외부에서 지정*/,
        shape = RoundedCornerShape(8.dp)/*모양*/,
        elevation = 5.dp/*부모 뷰로부터의 높이*/,
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            //이미지 뷰
            Image(
                painter = painterResource(id = R.drawable.poster)/*이미지 자료*/,
                contentDescription = "poster",
                contentScale = ContentScale.Crop,//이미지의 크기 비율
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                //아이콘 버튼 뷰
                IconButton(onClick = {
                    onTabFavorite(!isFavorite)
                }) {
                    //아이콘 이미지 뷰
                    Icon(imageVector = if(isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder/*아이콘 이미지*/,
                        contentDescription = "favorite",
                        tint = Color.White/*색상*/
                    )
                }
            }
        }
    }
}
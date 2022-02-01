package com.example.kotlin_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
//chapter4
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*
            //스크롤의 상태 저장
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    //수직 스크롤 가능
                    .verticalScroll(scrollState)
            ) {
                //for문으로 여러 개 작성이 가능하다.
                for (i in 1..50) {
                    Text(text = "Text $i")
                }
            }
            */
            //일반 Column과 다르게 화면에 표시되어야 할 때 UI을 보이는 연산을 시작.
            LazyColumn(
                modifier = Modifier.fillMaxWidth(), //수직 스크롤 가능
                contentPadding = PaddingValues(16.dp), //상하좌우에 패딩 적용
                verticalArrangement = Arrangement.spacedBy(8.dp) //뷰 간의 수직 간격
            ) {
                //LazyColumn에서는 for문 사용 불가능.
                //for문 대신 사용. 여러 뷰를 반복해서 작성
                items(50) { index ->
                    Text(text = " Text $index")
                }
            }
        }
    }
}
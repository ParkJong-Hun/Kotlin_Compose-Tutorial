package com.example.kotlin_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin_compose_tutorial.ui.theme.Kotlin_ComposeTutorialTheme
//chapter1
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //compose 내용
        setContent {
            Kotlin_ComposeTutorialTheme {
                //일반적인 공간 뷰
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background/*테마 파일의 컬러를 이용해 전체 배경 색 지정*/) {
                    //여러 뷰를 가로로 배치
                    Row {
                        Text("Hello")//텍스트 뷰
                        Spacer(modifier = Modifier.width(16.dp)/*길이를 조정할 때 사용*/)//빈 공간 뷰
                        Text("World!")
                        //여러 뷰를 세로로 배치
                        Column(
                            modifier = Modifier
                                .background(color = Color.LightGray)/*배경 색 지정*/
                                .padding(16.dp),/*패딩 지정*/
                            horizontalAlignment = Alignment.CenterHorizontally/*수평 정렬*/,
                            verticalArrangement = Arrangement.SpaceBetween/*수직 정렬*/,
                        ) {
                            Text("Hello")//텍스트 뷰
                            Spacer(modifier = Modifier.width(5.dp)/*길이를 조정할 때 사용*/)//빈 공간 뷰
                            Text("World!")
                        }
                    }
                }
            }
        }
    }
}
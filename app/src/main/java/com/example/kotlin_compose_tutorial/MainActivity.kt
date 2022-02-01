package com.example.kotlin_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
//chapter3
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Box는 자식뷰들이 다 겹쳐져서 보임(FrameLayout과 비슷함)
            Box(
                modifier = Modifier
                    .background(color = Color.Green)
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hello World")
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Text(text = "Hello!!!")
                }
            }
        }
    }
}
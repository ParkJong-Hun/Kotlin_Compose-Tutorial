package com.example.kotlin_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_compose_tutorial.ui.theme.Kotlin_ComposeTutorialTheme
//chapter2
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContent 안에서는 Composable만 들어갈 수 있음
        setContent {
            Kotlin_ComposeTutorialTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(name = "Android")
                }
            }
        }
    }
}

//Composable annotation이 붙어있는 함수는 보통 대문자로 시작
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//미리보기
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Kotlin_ComposeTutorialTheme {
        Greeting("Park JongHun")
    }
}

//미리보기2
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Kotlin_ComposeTutorialTheme {
        Greeting("Android")
    }
}
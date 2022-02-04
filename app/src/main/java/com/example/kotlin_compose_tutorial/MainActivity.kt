package com.example.kotlin_compose_tutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.launch

//chapter6
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val (text, setValue) = remember {
                mutableStateOf("")
            }//구조분해라는 기법을 활용할 수 있다.
            val scaffoldState = rememberScaffoldState()//scaffold의 상태를 기억
            val scope = rememberCoroutineScope()//적당한 CoroutineScope를 자동으로 만들어줌
            val keyboardController = LocalSoftwareKeyboardController.current//키보드 조절

            //액자 뷰(여러 기능을 활용 가능 ex/ 스낵바)
            Scaffold {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //텍스트 입력 뷰
                    TextField(
                        value = text,
                        onValueChange = setValue//값이 입력되었을 때의 이벤트 처리
                    )
                    //버튼 뷰
                    Button(onClick = {
                        scope.launch {
                            //스낵바 표시
                            scaffoldState.snackbarHostState.showSnackbar("Hello $text")
                        }
                        //키보드 가리기
                        keyboardController?.hide()
                    }/*클릭 이벤트 처리*/) {
                        Text("클릭")
                    }
                }
            }
        }
    }
}
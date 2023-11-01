package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp(){
     var result by remember { mutableStateOf(1) }
    when(result){
        1 -> ArtSpace(
            textlabel = R.string.nature,
            textAvtor = R.string.natureDescription,
            drawableRes = R.drawable.first,
            onNextClick = { },
            on = {result = 2}
        )
        2 -> ArtSpace(
            textlabel = R.string.dala,
            textAvtor = R.string.dalaDescription,
            drawableRes = R.drawable.photo,
            onNextClick = { result = 1},
           on = { result = 3}
        )
        3 -> ArtSpace(
            textlabel = R.string.three,
            textAvtor = R.string.threeDescription,
            drawableRes = R.drawable.third,
            onNextClick = { result = 2 },
            on = { })
    }



}

@Composable
fun ArtSpace(textlabel:Int,textAvtor:Int,drawableRes:Int,onNextClick: () -> Unit,on:()->Unit,modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

         Button(onClick = onNextClick){
            Text(text = stringResource(R.string.next))
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier


        ) {
            Image(
                painter = painterResource(drawableRes),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 20.dp)
            )
            Text(
                text = stringResource(textlabel),
                color = Color(0xFF272C8C), // Color(0xFFRRGGBB) for the desired color
                fontSize = 23.sp,
            )
            Text(
                text = stringResource(textAvtor)
            )


        }
        Button(onClick = on

        ){
            Text(text = stringResource(R.string.nextnext),
                )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
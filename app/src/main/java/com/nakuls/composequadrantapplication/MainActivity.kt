package com.nakuls.composequadrantapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nakuls.composequadrantapplication.ui.theme.ComposeQuadrantApplicationTheme
import com.nakuls.composequadrantapplication.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantApplicationTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    ComposeQuadrants()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrants() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            ComposeQuadrant(
                stringResource(R.string.text_compose_heading),
                stringResource(R.string.text_compose_content),
                R.color.text_colour,
                Modifier.weight(1f))
            ComposeQuadrant(
                stringResource(R.string.image_compose_heading),
                stringResource(R.string.image_compose_content),
                R.color.image_colour,
                Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            ComposeQuadrant(
                stringResource(R.string.row_compose_heading),
                stringResource(R.string.row_compose_content),
                R.color.row_colour,
                Modifier.weight(1f))
            ComposeQuadrant(
                stringResource(R.string.column_compose_heading),
                stringResource(R.string.column_compose_content),
                R.color.column_colour,
                Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantsPreview(){
    ComposeQuadrants()
}

@Composable
fun ComposeQuadrant(
    heading: String,
    content: String,
    backgroundColor: Int,
    modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color(backgroundColor))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = heading,
            style = Typography.bodyLarge,
            modifier = modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantApplicationTheme {
        ComposeQuadrant(
            stringResource(R.string.text_compose_heading),
            stringResource(R.string.text_compose_content),
            R.color.text_colour
        )
    }
}
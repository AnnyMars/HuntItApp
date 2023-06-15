package com.example.composeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composeapp.MainViewModel
import com.example.composeapp.data.models.Goals
import com.example.composeapp.data.models.Resp
import com.example.composeapp.navigation.Screens

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val fixtures = viewModel.resp.observeAsState(emptyList()).value

    Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                content = {
                    items(fixtures) { fixture ->
                        FixtureCard(fixture)
                    }
                }
            )

            Button(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                onClick = {
                    navController.navigate(Screens.Web.route)
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = "Load More",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun FixtureCard(resp: Resp) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TeamBox(resp.teams.home.name, resp.teams.home.logo)
            Spacer(modifier = Modifier.width(16.dp))
            ScoreBox(goals = resp.goals)
            Spacer(modifier = Modifier.width(16.dp))
            TeamBox(resp.teams.away.name, resp.teams.away.logo)
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun TeamBox(name: String, painter: String) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(painter),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = name,
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ScoreBox(goals: Goals) {
    Box(
        modifier = Modifier
            .width(48.dp)
            .height(48.dp)
            .border(1.dp, Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${goals.home} : ${goals.away}",
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}
package net.ezra.ui.about

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.*
import net.ezra.R
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AboutScreen(navController: NavHostController) {
    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->
            // Handle result here if needed
        }

    var currentDateTime by remember { mutableStateOf("") }

    // Coroutine to fetch current date and time
    LaunchedEffect(Unit) {
        val timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask() {
            @SuppressLint("DiscouragedApi")
            override fun run() {
                GlobalScope.launch {
                    fetchDateTime { dateTime ->
                        currentDateTime = dateTime
                    }
                }
            }
        }, 0, 1000) // Update every 1 second (1000 ms)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffCCCCFF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = currentDateTime,
            modifier = Modifier.padding(7.dp),
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(6.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                LazyRow {
                    item {
                        androidx.compose.material3.Card(
                            modifier = Modifier
                                .width(800.dp)
                                .padding(15.dp)
                                .background(Color.White)
                                .fillMaxWidth()
                        ) {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.contact),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .width(800.dp)
                                        .height(200.dp)
                                        .fillMaxWidth()
                                )
                            }
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(7.dp)
                )
                LazyRow {
                    item {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_call_24),
                            contentDescription = "",
                        )

                        Spacer(
                            modifier = Modifier
                                .width(5.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.call),
                            fontSize = 24.sp,
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {

                                    val intent = Intent(Intent.ACTION_DIAL)
                                    intent.data = Uri.parse("tel:+254718367530")

                                    callLauncher.launch(intent)
                                }
                        )
                        Spacer(
                            modifier = Modifier
                                .width(5.dp)
                        )

                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                LazyRow {
                    item {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_mark_email_unread_24),
                        contentDescription = "",
                    )
                    Spacer(
                        modifier = Modifier
                            .width(5.dp)
                    )
                    Text(
                        text = "Epic events.KE@gmail.com",
                        modifier = Modifier
                            .padding(10.dp),
                        fontSize = 24.sp,

                        )
                }
            }
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                )
                LazyRow {
                    item {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_screen_search_desktop_24),
                            contentDescription = "",
                            modifier = Modifier
                                .height(30.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(5.dp)
                        )
                        Text(
                            text = "All social media(@Epic events.Kenya)",
                            modifier = Modifier
                                .padding(10.dp),
                            fontSize = 24.sp,
                        )
                    }
                }
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(800.dp)
                            .padding(15.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.mpesa),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(800.dp)
                                    .height(200.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(7.dp)
                )
                Column {
                    Text(
                        text = "Payments service; ",
                        modifier = Modifier
                            .padding(10.dp),
                        fontSize = 24.sp,
                    )
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                    )
                    Text(
                        text = "Send Money:",
                        modifier = Modifier
                            .padding(10.dp),
                        fontSize = 24.sp,
                    )
                    Spacer(
                        modifier = Modifier
                            .width(5.dp)
                    )
                    Text(
                        text = "-(+254)0718367530",
                                modifier = Modifier
                                .padding(10.dp),
                        fontSize = 19.sp,
                    )

                }


            }
        }
    }
}

// Function to fetch current date and time asynchronously
suspend fun fetchDateTime(onSuccess: (String) -> Unit) {
    try {
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        val dateTime = "$currentTime\n$currentDate"
        onSuccess(dateTime)
    } catch (e: Exception) {
        e.printStackTrace()
        // Handle error here
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AboutScreenPreviewLight() {
    AboutScreen(rememberNavController())
}

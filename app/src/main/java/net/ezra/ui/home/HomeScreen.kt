package net.ezra.ui.home






import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_SIGNUP
import net.ezra.navigation.ROUTE_VIEW_PROD
import net.ezra.navigation.ROUTE_VIEW_STUDENTS


data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }

    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(text = stringResource(id = R.string.Epic))
//                },
//                navigationIcon = @Composable {
//                    if (!isDrawerOpen) {
//                        IconButton(onClick = { isDrawerOpen = true }) {
//                            Icon(
//                                Icons.Default.Menu,
//                                contentDescription = "Menu",
//                                tint = Color.White
//                                )
//                        }
//                    }
//                },
//
//                actions = {
//                    IconButton(onClick = {
//                        navController.navigate(ROUTE_LOGIN) {
//                            popUpTo(ROUTE_HOME) { inclusive = true }
//                        }
//
//                    }) {
//                        Icon(
//                            imageVector = Icons.Filled.AccountCircle,
//                            contentDescription = null,
//                            tint = Color.White
//                        )
//                    }
//                },
//
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xff0FB06A),
//                    titleContentColor = Color.White,
//
//                )
//
//            )
//        },

        content = @Composable {
            Box(
                modifier = Modifier
                    .background(Color(0xffCCCCFF))
                    .fillMaxSize()
                    .fillMaxWidth()
                    .fillMaxHeight()


                    .clickable {
                        if (isDrawerOpen) {
                            isDrawerOpen = false
                        }
                    }

            ) {
                Image(
                    painter = painterResource(id = R.drawable.shane), contentDescription ="" ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .width(1000.dp)
                )
              LazyColumn (
                  modifier = Modifier
              ){
                  item {
                      Row (
                          modifier = Modifier
                              .padding(5.5.dp),
                          horizontalArrangement=Arrangement.Start,
                          verticalAlignment = Alignment.CenterVertically,
                      )
                      {
                            Card(
                                modifier = Modifier
                                    .width(900.dp)
                                    .fillMaxWidth()
                            ) {
                                Box {
                                    Image(painter = painterResource(id = R.drawable.top),
                                        contentDescription ="" ,
                                        modifier = Modifier
                                            .width(900.dp)
                                            .fillMaxWidth()
                                            .fillMaxHeight()

                                    )
                                    Spacer(
                                        modifier = Modifier
                                            .padding(1.dp)
                                    )
                                    Column {
                                        Text(
                                            text = "Welcome to Epic Events",
                                            fontSize = 21.sp,
                                            fontWeight = FontWeight.W900,
                                            color =Color(0xff1b4f72),
                                            fontStyle = FontStyle.Italic,
                                            modifier = Modifier
                                                .padding(65.dp)

                                        )
                                    }

                                }
                            }
                      }
                      Spacer(
                          modifier = Modifier
                              .padding(1.dp)
                      )
                      LazyRow {
                          item {
                              Card(
                                  modifier = Modifier
                                      .width(300.dp)
                                      .padding(20.dp)
                                      .fillMaxWidth()
                                      .background(Color.White)
                              ) {
                                  Box (){
                                      Image(painter = painterResource(id = R.drawable.birth),
                                          contentDescription ="",
                                          contentScale = ContentScale.Crop,
                                          modifier = Modifier
                                              .width(300.dp)
                                              .height(200.dp)
                                              .fillMaxWidth()

                                      )
                                      Spacer(
                                          modifier = Modifier
                                              .padding(40.dp)
                                      )
                                      Column {
//                                          Text(
//                                              text = "Birthday ceremonies",
//                                              fontSize = 30.sp,
//                                              fontWeight = FontWeight.W900,
//                                              color = Color(0xff1c7768 ),
//                                              modifier = Modifier
//                                                  .padding(65.dp)
//
//                                          )
                                      }
                                  }
                              }



                              Card (
                                  modifier = Modifier
                                      .width(300.dp)
                                      .padding(20.dp)
                                      .fillMaxWidth()
                                      .background(Color.White)
                              ){
                                 Box {
                                     Image(painter = painterResource(id = R.drawable.party),
                                         contentDescription ="" ,
                                         contentScale = ContentScale.Crop,
                                         modifier = Modifier
                                             .width(300.dp)
                                             .height(200.dp)
                                             .fillMaxWidth()
                                     )
                                     Spacer(
                                         modifier = Modifier
                                             .padding(40.dp)
                                     )
                                     Column {
                                         Text(
                                             text = "parties events",
                                             fontSize = 30.sp,
                                             fontWeight = FontWeight.W900,
                                             color = Color.White,
                                             modifier = Modifier
                                                 .padding(65.dp)

                                         )
                                     }
                                 }
                              }
                              Card (
                                  modifier = Modifier
                                      .width(300.dp)
                                      .padding(20.dp)
                                      .background(Color.White)
                                      .fillMaxWidth()
                              ){
                                 Box {
                                     Image(painter = painterResource(id = R.drawable.pinci),
                                         contentDescription = "",
                                         contentScale = ContentScale.Crop,
                                         modifier = Modifier
                                             .width(300.dp)
                                             .height(200.dp)
                                             .fillMaxWidth()
                                     )
                                     Spacer(
                                         modifier = Modifier
                                             .padding(40.dp)
                                     )
                                     Column {
                                         Text(
                                             text = "picnic events",
                                             fontSize = 30.sp,
                                             fontWeight = FontWeight.W900,
                                             color = Color.White,
                                             modifier = Modifier
                                                 .padding(65.dp)

                                         )
                                     }
                                 }
                              }
                              Card (
                                  modifier = Modifier
                                      .width(300.dp)
                                      .padding(20.dp)
                                      .background(Color.White)
                                      .fillMaxWidth()
                              ){
                                  Box {
                                      Image(painter = painterResource(id = R.drawable.wedding),
                                          contentDescription = "",
                                          contentScale = ContentScale.Crop,
                                          modifier = Modifier
                                              .width(300.dp)
                                              .height(200.dp)
                                              .fillMaxWidth()
                                      )
                                      Spacer(
                                          modifier = Modifier
                                              .padding(40.dp)
                                      )
                                      Column {
                                          Text(
                                              text = "Wedding ceremonies",
                                              fontSize = 30.sp,
                                              fontWeight = FontWeight.W900,
                                              color = Color.White,
                                              modifier = Modifier
                                                  .padding(65.dp)

                                          )
                                      }
                                  }
                              }
                              Card (
                                  modifier = Modifier
                                      .width(300.dp)
                                      .padding(20.dp)
                                      .background(Color.White)
                                      .fillMaxWidth()
                              ){
                                  Box {
                                      Image(painter = painterResource(id = R.drawable.baby),
                                          contentDescription = "",
                                          contentScale = ContentScale.Crop,
                                          modifier = Modifier
                                              .width(300.dp)
                                              .height(200.dp)
                                              .fillMaxWidth()
                                      )
                                      Spacer(
                                          modifier = Modifier
                                              .padding(40.dp)
                                      )
                                      Column {
                                          Text(
                                              text = "Babyshower ceremonies",
                                              fontSize = 30.sp,
                                              fontWeight = FontWeight.W900,
                                              color = Color.White,
                                              modifier = Modifier
                                                  .padding(60.dp)

                                          )
                                      }
                                  }
                              }
                              Card (
                                  modifier = Modifier
                                      .width(300.dp)
                                      .padding(20.dp)
                                      .background(Color.White)
                                      .fillMaxWidth()
                              ){
                                  Box {
                                      Image(painter = painterResource(id = R.drawable.grad),
                                          contentDescription = "",
                                          contentScale = ContentScale.Crop,
                                          modifier = Modifier
                                              .width(300.dp)
                                              .height(200.dp)
                                              .fillMaxWidth()
                                      )
                                      Spacer(
                                          modifier = Modifier
                                              .padding(40.dp)
                                      )
                                      Column {
                                          Text(
                                              text = "Graduation ceremonies",
                                              fontSize = 30.sp,
                                              fontWeight = FontWeight.W900,
                                              color = Color.White,
                                              modifier = Modifier
                                                  .padding(65.dp)

                                          )
                                      }
                                  }
                              }
                          }
                      }
                      Spacer(
                          modifier = Modifier
                              .padding(3.dp)
                      )
                      Column{
                          Text(
                              text = "A CREATIVE ORGANIZATION OF " ,
                              modifier = Modifier
                                  .padding(2.dp),
                              color = Color.Black,
                              fontSize =(16.sp)
                                  )
                      }
                      Spacer(
                          modifier = Modifier
                              .padding(1.dp)
                      )
                      Column{
                          Text(
                              text = "EVENT SPACE FOR INDEPENDENT INDIVIDUALS " ,
                              modifier = Modifier
                                  .padding(2.dp),
                              color = Color.Black,
                              fontSize =(16.sp)
                          )
                      }
                      Spacer(
                          modifier = Modifier
                              .padding(1.dp)
                      )
                      Column{
                          Text(
                              text = "OR BUSINESS AND THE COMMUNITY. " ,
                              modifier = Modifier
                                  .padding(2.dp),
                              color = Color.Black,
                              fontSize =(16.sp)
                          )
                      }
                      Spacer(
                          modifier = Modifier
                              .padding(2.2.dp)
                      )
                      Row {
                          Text(
                              text = "**For any Booking with us just!",
                              modifier = Modifier
                                  .padding(2.5.dp),
                              textAlign = TextAlign.Center,
                              color = Color.Blue,
                              fontSize =(18.sp)
                          )
                          Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_REGISTER) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            },
                        text = "Sign in ?",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                      }
                      Spacer(
                          modifier = Modifier
                              .padding(0.dp)
                      )
                      Row(modifier = Modifier
                          .padding(2.dp),
                          verticalAlignment = Alignment.CenterVertically,
                         horizontalArrangement = Arrangement.Center
                      ) {
                          Text(
                              text = "if you don't have an account!",
                              modifier = Modifier
                                  .padding(2.5.dp),
                              textAlign = TextAlign.Center,
                              color = MaterialTheme.colorScheme.onSurface
                          )
                          Spacer(
                              modifier = Modifier
                                  .padding(0.dp)
                          )
                          Text(
                              text = "or",
                              modifier = Modifier
                                  .padding(2.5.dp),
                              color = Color.Blue,
                              fontSize = (30.sp),
                              textAlign = TextAlign.Center,
                          )
                          Spacer(
                              modifier = Modifier
                                  .padding(4.dp)
                          )
                          Image(painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_down_24),
                              contentDescription = "",
                              modifier = Modifier
                                  .width(20.dp)
                                  .height(20.dp)
                          )

                      }




                  }
              }

//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color(0xff9AEDC9)),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//
//                    Text(
//                        text = stringResource(id = R.string.call),
//                        fontSize = 20.sp,
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .clickable {
//
//                                val intent = Intent(Intent.ACTION_DIAL)
//                                intent.data = Uri.parse("tel:+254796759850")
//
//                                callLauncher.launch(intent)
//                            }
//                    )
//
//                    Text(
//                        text = stringResource(id = R.string.developer),
//                        fontSize = 20.sp,
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_LOGIN) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Login Here",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_PRODUCT) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_STUDENTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Students",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_VIEW_PROD) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "view Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        text = "You're welcome",
//                        fontSize = 30.sp,
//                        color = Color.White
//                    )
//
//
//
//                }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


//             LazyColumn {
//                 item {
//                     LazyRow {
//                         item {
//                             Row {
//                                Card (
//                                    modifier = Modifier
//                                        .width(100.dp)
//                                        .padding(20.dp)
//                                        .fillMaxWidth()
//                                        .background(Color.White)
//                                ){
//                                      Box {
//                                        Image(painter = painterResource(id = R.drawable.party),
//                                            contentDescription ="",
//                                                    contentScale = ContentScale.Crop,
//                                                      modifier = Modifier
//                                                          .width(100.dp)
//                                                          .fillMaxWidth()
//                                        )
//                                          Column {
//                                              Text(text = "Party")
//                                          }
//                                      }
//                                }
//                             }
//                         }
//                     }
//                 }
//             }
//
//


//
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color(0xff9AEDC9)),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//
//                    Text(
//                        text = stringResource(id = R.string.call),
//                        fontSize = 20.sp,
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .clickable {
//
//                                val intent = Intent(Intent.ACTION_DIAL)
//                                intent.data = Uri.parse("tel:+254796759850")
//
//                                callLauncher.launch(intent)
//                            }
//                    )
//
//                    Text(
//                        text = stringResource(id = R.string.developer),
//                        fontSize = 20.sp,
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_LOGIN) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Login Here",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_PRODUCT) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_STUDENTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Students",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_VIEW_PROD) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "view Products",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        text = "You're welcome",
//                        fontSize = 30.sp,
//                        color = Color.White
//                    )
//
//
//
//                }

            }

        },

        bottomBar = { BottomBar(navController = navController) }







    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )
}

@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }

    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp)
            ,
        color = Color.LightGray,
//        elevation = 16.dp
    ) {
        Column {
            Text(
                text = "Drawer Item 1"

            )
            Text(
                text = "Drawer Item 2"
            )
            Text(
                text = "Drawer Item 3",
                modifier = Modifier.clickable {  }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = stringResource(id = R.string.developer))

        }
    }
}






@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color(0xff030303)


    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"", tint = Color.White)
        },
            label = { Text(text = "HOME",color =  Color.White) }, selected = (selectedIndex.value == 0), onClick = {

            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.AccountBox,"",tint = Color.White)
        },
            label = { Text(text = "LOGIN",color =  Color.White) }, selected = (selectedIndex.value == 1), onClick = {
               navController.navigate(ROUTE_LOGIN){
                   popUpTo(ROUTE_HOME) { inclusive = true }
               }



            })
//
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Info, "",tint = Color.White)
//        },
//            label = { Text(
//                text = "INFO",
//                color =  Color.White) },
//            selected = (selectedIndex.value == 2),
//            onClick = {
//                navController.navigate(ROUTE_VIEW_PROD) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//
//            })

    }
}
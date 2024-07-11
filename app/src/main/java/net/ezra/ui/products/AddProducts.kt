package net.ezra.ui.products

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.tasks.await
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_VIEW_PROD
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavController, onProductAdded: () -> Unit) {
    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productImageUri by remember { mutableStateOf<Uri?>(null) }

    // Track if fields are empty
    var productNameError by remember { mutableStateOf(false) }
    var productDescriptionError by remember { mutableStateOf(false) }
    var productPriceError by remember { mutableStateOf(false) }
    var productImageError by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            productImageUri = it
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = " View Prices & Interest ", fontSize = 30.sp, color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_HOME)
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color(0xffCCCCFF),
                )
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .background(Color(0xffCCCCFF))
                .fillMaxSize()
        ) {
            item {
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.party),
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
                                androidx.compose.material3.Text(
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
                }
                Spacer(
                    modifier = Modifier
                        .padding(0.0.dp)
                )
                Column {
                    Text(
                        text = "Party prices:",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "10,000-30,000 KSH"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "35,000-70,000 KSH"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "75,000-100,000 KSH"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Box() {
                            Image(
                                painter = painterResource(id = R.drawable.birth),
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
//
                            }
                        }
                    }
                }
                Column {
                    Text(
                        text = "Birthday price",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "10,000-30,000 KSH"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "35,000-55,000 KSH"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "60,000-85,000 KSH"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.pinci),
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
                                androidx.compose.material3.Text(
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
                }
                Column {
                    Text(
                        text = "Picnic Price",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "9,000-15,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "16,000-20,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "21,000-30,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.wedding),
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
                                androidx.compose.material3.Text(
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
                }
                Spacer(
                    modifier = Modifier
                        .padding(0.0.dp)
                )
                Column {
                    Text(
                        text = "Weeding Prices",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "300,000-750,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "760,000-,1,000,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "1,100,000 and above ")
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.baby),
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
                                androidx.compose.material3.Text(
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
                }
                Spacer(
                    modifier = Modifier
                        .padding(0.0.dp)
                )
                Column {
                    Text(
                        text = "Babyshower Prices",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "20,000-40,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "41,000-60,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "61,000-90,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.grad),
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
                                androidx.compose.material3.Text(
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
                Spacer(
                    modifier = Modifier
                        .padding(0.0.dp)
                )
                Column {
                    Text(
                        text = "Graduation Prices",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )

                Column {
                    Text(text = "100,000-300,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "310,000-650,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "650,000-890,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.5.dp)
                )
                Row {
                    Text(
                        text = "Personal Graduation",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(0.6.dp)
                )
                Column {
                    Text(text = "20,000-37,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "38,000-50,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "51,000-80,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.out),
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
                                androidx.compose.material3.Text(
                                    text = "Team outing",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.W900,
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(60.dp)

                                )
                            }
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(0.0.dp)
                )
                Column {
                    Text(
                        text = "Team outing Prices",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "20,000-39,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "40,000-55,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "56,000-70,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.conference),
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
                                androidx.compose.material3.Text(
                                    text = "conference ",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.W900,
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(60.dp)

                                )
                            }
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(0.0.dp)
                )
                Column {
                    Text(
                        text = "conference Prices",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "30,000-50,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "51,000-75,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "76,000-90,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "91,000-150,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(3.dp)
                )
                Column {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(20.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.festivals),
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
                                androidx.compose.material3.Text(
                                    text = "festivals events ",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.W900,
                                    color = Color.White,
                                    modifier = Modifier
                                        .padding(60.dp)

                                )
                            }
                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .padding(0.0.dp)
                )
                Column {
                    Text(
                        text = "festivals Prices",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(
                        text = "55,000-99,000"
                    )
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "100,000-200,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "211,000-690,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "700,000-990,000")
                }
                Spacer(
                    modifier = Modifier
                        .padding(1.6.dp)
                )
                Column {
                    Text(text = "1,000,000-7.9,000,000")
                }

































                Spacer(
                    modifier = Modifier
                        .padding(4.5.dp)
                )
                androidx.compose.material3.Button(
                    modifier = Modifier
                        .padding(9.dp)
                        .fillMaxWidth()
                        .width(400.dp)
                       ,

                    onClick = {
                        navController.navigate(ROUTE_DASHBOARD)
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xffaf7ac5)),
                    shape = CutCornerShape(10.dp),

                )
                {
                    Text(
                        text = "Booking",
                        modifier = Modifier,
                        fontSize = (19.sp),
                        fontWeight = FontWeight.Bold
                    )
                }


            }   //item
        }    //lazycolum
    }    //content

}
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xff9AEDC9))
//            ) {
//                item {
//                    if (productImageUri != null) {
//                        // Display selected image
//                        Image(
//                            painter = rememberImagePainter(productImageUri), // Using rememberImagePainter with Uri
//                            contentDescription = null,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(200.dp)
//                        )
//                    } else {
//                        // Display placeholder if no image selected
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(200.dp),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text("No Image Selected", modifier = Modifier.padding(8.dp))
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(16.dp))
//                    Button(onClick = { launcher.launch("image/*") }) {
//                        Text("Select Image")
//                    }
//                    Spacer(modifier = Modifier.height(16.dp))
//                    TextField(
//                        value = productName,
//                        onValueChange = { productName = it },
//                        label = { Text("Product Name") },
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    TextField(
//                        value = productDescription,
//                        onValueChange = { productDescription = it },
//                        label = { Text("Product Description") },
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    TextField(
//                        value = productPrice,
//                        onValueChange = { productPrice = it },
//                        label = { Text("Product Price") },
//                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                        keyboardActions = KeyboardActions(onDone = { /* Handle Done action */ }),
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    if (productNameError) {
//                        Text("Product Name is required", color = Color.Red)
//                    }
//                    if (productDescriptionError) {
//                        Text("Product Description is required", color = Color.Red)
//                    }
//                    if (productPriceError) {
//                        Text("Product Price is required", color = Color.Red)
//                    }
//                    if (productImageError) {
//                        Text("Product Image is required", color = Color.Red)
//                    }
//
//                    // Button to add product
//                    Button(
//                        onClick = {
//                            // Reset error flags
//                            productNameError = productName.isBlank()
//                            productDescriptionError = productDescription.isBlank()
//                            productPriceError = productPrice.isBlank()
//                            productImageError = productImageUri == null
//
//                            // Add product if all fields are filled
//                            if (!productNameError && !productDescriptionError && !productPriceError && !productImageError) {
//                                addProductToFirestore(
//                                    navController,
//                                    onProductAdded,
//                                    productName,
//                                    productDescription,
//                                    productPrice.toDouble(),
//                                    productImageUri
//                                )
//                            }
//                        },
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Text("Add Product")
//                    }
//                }
//            }


private fun addProductToFirestore(navController: NavController, onProductAdded: () -> Unit, productName: String, productDescription: String, productPrice: Double, productImageUri: Uri?) {
    if (productName.isEmpty() || productDescription.isEmpty() || productPrice.isNaN() || productImageUri == null) {
        // Validate input fields
        return
    }

    val productId = UUID.randomUUID().toString()

    val firestore = Firebase.firestore
    val productData = hashMapOf(
        "name" to productName,
        "description" to productDescription,
        "price" to productPrice,
        "imageUrl" to ""
    )

    firestore.collection("products").document(productId)
        .set(productData)
        .addOnSuccessListener {
            uploadImageToStorage(productId, productImageUri) { imageUrl ->
                firestore.collection("products").document(productId)
                    .update("imageUrl", imageUrl)
                    .addOnSuccessListener {
                        // Display toast message
                        Toast.makeText(
                            navController.context,
                            "Product added successfully!",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Navigate to another screen
                        navController.navigate(ROUTE_HOME)

                        // Invoke the onProductAdded callback
                        onProductAdded()
                    }
                    .addOnFailureListener { e ->
                        // Handle error updating product document
                    }
            }
        }
        .addOnFailureListener { e ->
            // Handle error adding product to Firestore
        }
}

private fun uploadImageToStorage(productId: String, imageUri: Uri?, onSuccess: (String) -> Unit) {
    if (imageUri == null) {
        onSuccess("")
        return
    }

    val storageRef = Firebase.storage.reference
    val imagesRef = storageRef.child("products/$productId.jpg")

    imagesRef.putFile(imageUri)
        .addOnSuccessListener { taskSnapshot ->
            imagesRef.downloadUrl
                .addOnSuccessListener { uri ->
                    onSuccess(uri.toString())
                }
                .addOnFailureListener {
                    // Handle failure to get download URL
                }
        }
        .addOnFailureListener {
            // Handle failure to upload image
        }
}


@file:Suppress("NAME_SHADOWING")

package net.ezra.ui.dashboard






import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_DASHBOARD
import java.util.UUID


var progressDialog: ProgressDialog? = null
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {
    val context = LocalContext.current


    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text ="Booking",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                       Icon(Icons.Filled.DateRange, "backIcon",tint = Color.White)
                   }
               },


                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff030303),
                    titleContentColor = Color.White,

                    )
            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffCCCCFF)),
                verticalArrangement = Arrangement.Center,
            ) {
                LazyColumn (

                ){
                    item {
                        Column(







                            horizontalAlignment = Alignment.CenterHorizontally
                        ){

                         

                            Spacer(modifier = Modifier.height(70.dp))


                            var photoUri: Uri? by remember { mutableStateOf(null) }
                            val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                                photoUri = uri
                            }

                            var Name by rememberSaveable {
                                mutableStateOf("")
                            }

                            var Budget by rememberSaveable {
                                mutableStateOf("")
                            }

                            var Email by rememberSaveable {
                                mutableStateOf("")
                            }

                            var location by rememberSaveable {
                                mutableStateOf("")
                            }

                            var phone by rememberSaveable {
                                mutableStateOf("")
                            }
                            var event by rememberSaveable {
                                mutableStateOf("")
                            }
                            var Date by rememberSaveable {
                                mutableStateOf("")
                            }
                            var capacity by rememberSaveable {
                                mutableStateOf("")
                            }
                            var Description by rememberSaveable {
                                mutableStateOf("")
                            }




                            OutlinedTextField(
                                value = Name,
                                onValueChange = { Name = it },
                                label = { Text(text = "Name") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )
                            OutlinedTextField(
                                value = Email,
                                onValueChange = { Email = it },
                                label = { Text(text = "Email") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = phone,
                                onValueChange = { phone = it },
                                label = { Text(text = "Phone Number") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = location,
                                onValueChange = { location = it },
                                label = { Text(text = " Your Location") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value =event,
                                onValueChange = { event = it },
                                label = { Text(text = " Type of event") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = Budget,
                                onValueChange = { Budget= it },
                                label = { Text(text = " Your Budget") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )
                            OutlinedTextField(
                                value = Date,
                                onValueChange = { Date= it },
                                label = { Text(text = "Event Date") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )
                            OutlinedTextField(
                                value = capacity,
                                onValueChange = { capacity= it },
                                label = { Text(text = "Capacity or Crowd") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )
                            OutlinedTextField(
                                value = Description,
                                onValueChange = { Description= it },
                                label = { Text(text = "Description") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )







                            if (photoUri != null) {
                                //Use Coil to display the selected image
                                val painter = rememberAsyncImagePainter(
                                    ImageRequest
                                        .Builder(LocalContext.current)
                                        .data(data = photoUri)
                                        .build()
                                )

                                Image(
                                    painter = painter,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .width(150.dp)
                                        .height(150.dp)
                                        .border(1.dp, Color.Gray),
                                    contentScale = ContentScale.Crop,

                                    )
                            } else {

                                OutlinedButton(
                                    onClick = {
                                        launcher.launch(
                                            PickVisualMediaRequest(
                                                //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                                //Or use .VideoOnly if you only want videos.
                                                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                            )
                                        )
                                    },
                                    colors = ButtonDefaults.buttonColors(Color(0xffaf7ac5)),
                                    shape = CutCornerShape(10.dp),
                                )
                                {
                           Text(
                               text = "Insert any image",
                               modifier = Modifier,
                               fontSize = (19.sp),
                               fontWeight = FontWeight.Bold
                           )
                                }
                            }


                            OutlinedButton(onClick = {
                                navController.navigate(ROUTE_ABOUT)

                                if (photoUri != null) {

                                    progressDialog = ProgressDialog(context)
                                    progressDialog?.setMessage("Save Booking...")
                                    progressDialog?.setCancelable(false)
                                    progressDialog?.show()

                                    photoUri?.let {

                                        uploadImageToFirebaseStorage(
                                            it,
                                            Name,
                                            Budget,
                                           event,
                                            Email,
                                            Date,
                                            location,
                                            phone,
                                            capacity,
                                            Description,
                                            context

                                        )

                                        Name = ""
                                        Budget = ""
                                        Email = ""
                                        location = ""
                                        event=""
                                        Date=""
                                        phone = ""
                                        capacity=""
                                        Description=""
                                        photoUri = null

                                    }
                                } else if (Budget == ""){

                                    Toast.makeText(context, "Please enter Budget", Toast.LENGTH_SHORT).show()
                                }
                                else if (Email == ""){
                                    Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
                                }
                                else if(Name == ""){
                                    Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show()
                                }
                                else if(phone == ""){
                                    Toast.makeText(context, "Please enter your phone number", Toast.LENGTH_SHORT).show()
                                }
                                else if(location == ""){
                                    Toast.makeText(context, "Please enter location", Toast.LENGTH_SHORT).show()
                                }
                                else if(event == ""){
                                    Toast.makeText(context, "Please enter type of event", Toast.LENGTH_SHORT).show()
                                }
                                else if(Date == ""){
                                    Toast.makeText(context, "Please enter Date of  the event", Toast.LENGTH_SHORT).show()
                                }
                                else if(capacity == ""){
                                    Toast.makeText(context, "Please enter Capacity of people", Toast.LENGTH_SHORT).show()
                                }
                                else if(Description == ""){
                                    Toast.makeText(context, "Please Describe type of event your want", Toast.LENGTH_SHORT).show()
                                }




                                else {
                                    Toast.makeText(context, "Please select an image", Toast.LENGTH_SHORT).show()
                                }



                            },
                                colors = ButtonDefaults.buttonColors(Color(0xffaf7ac5)),
                                shape = CutCornerShape(10.dp),
                                ) {

                                Text(
                                    text = "Save Booking",
                                    modifier = Modifier,
                                    fontSize = (19.sp),
                                    fontWeight = FontWeight.Bold
                                )


                            }











                        }
                    }
                }
            }

        })



}



fun uploadImageToFirebaseStorage(
    imageUri: Uri,
    Name: String,
    Budget: String,
    Email: String,
    location: String,
    phone: String,
    event: String,
    Date: String,
    capacity: String,
    Description: String,
    context: Context

) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(
                downloadUri.toString(),
                Name,
                Budget,
                Email,
                event,
                location,
                Date,
                phone,
                capacity,
                Description,
                context,


                )

        } else {

            progressDialog?.dismiss()

            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to upload image: ${task.exception?.message}")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked


                }
                .show()


        }
    }
}


fun saveToFirestore(
    imageUrl: String,
    Name: String,
    Budget: String,
    Email: String,
    location: String,
    phone: String,
    event: String,
    Date: String,
    capacity: String,
    Description: String,
    context: Context,



    ) {


    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "Name" to Name,
        "Budget" to Budget,
        "Email" to Email,
        "Event" to event,
        "location" to location,
        "phone" to phone,
        "Date" to Date,
        "capacity" to capacity,
        "Description" to Description



    )


    db.collection("users")
        .add(imageInfo)
        .addOnSuccessListener { documentReference ->

            progressDialog?.dismiss()

            // Show success dialog
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setTitle("Success")
                .setMessage("Data saved successfully!")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked
                }
                .setIcon(R.drawable.shane)
                .setCancelable(false)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            // Customize the dialog style (optional)
            val alertDialogStyle = alertDialog.window?.attributes
            alertDialog.window?.attributes = alertDialogStyle
        }
        .addOnFailureListener {

            progressDialog?.dismiss()


            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to save data")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked



                }
                .show()


        }
}






@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    DashboardScreen(rememberNavController())
}









//
//
//
//import android.annotation.SuppressLint
//import android.app.ProgressDialog
//import android.widget.Toast
//import androidx.activity.compose.BackHandler
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.CutCornerShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.MailOutline
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Refresh
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import com.google.firebase.Firebase
//import com.google.firebase.auth.EmailAuthProvider
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.firestore.ktx.toObject
//import net.ezra.navigation.ROUTE_LOGIN
//
//import com.google.firebase.firestore.SetOptions
//import com.google.firebase.firestore.firestore
//import net.ezra.navigation.ROUTE_ABOUT
//import net.ezra.navigation.ROUTE_ADD_STUDENTS
//import net.ezra.navigation.ROUTE_DASHBOARD
//import net.ezra.navigation.ROUTE_HOME
//import java.util.Date
//
//
//private var progressDialog: ProgressDialog? = null
//@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun DashboardScreen(navController: NavHostController)  {
//    var number by remember { mutableStateOf("") }
//    var Description by remember { mutableStateOf("") }
//    var event by remember { mutableStateOf("") }
//    var capacity by remember { mutableStateOf("") }
//    var Date by remember { mutableStateOf("") }
//    var name by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var location by remember { mutableStateOf("") }
//    var Budget by remember { mutableStateOf("") }
//    val currentUser = FirebaseAuth.getInstance().currentUser
//    val firestore = FirebaseFirestore.getInstance()
//    var user: User? by remember { mutableStateOf(null) }
//    var isLoading by remember { mutableStateOf(true) }
//    var studentCount by remember { mutableIntStateOf(0) }
//    var currentPassword by remember { mutableStateOf("") }
//    var newPassword by remember { mutableStateOf("") }
//    var confirmPassword by remember { mutableStateOf("") }
//
//    var loading by remember { mutableStateOf(false) }
//
//    val firestores = Firebase.firestore
//
//
//    val context = LocalContext.current
//
//    BackHandler {
//        navController.popBackStack()
//
//    }
//
//
//    // Fetch user details from Firestore
//    LaunchedEffect(key1 = currentUser?.uid) {
//        if (currentUser != null) {
//            val userDocRef = firestore.collection("users").document(currentUser.uid)
//            userDocRef.get()
//                .addOnSuccessListener { document ->
//                    if (document.exists()) {
//                        user = document.toObject<User>()
//                    }
//                    isLoading = false
//                }
//                .addOnFailureListener { e ->
//                    // Handle failure
//                    isLoading = false
//                }
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        firestores.collection("Client")
//            .get()
//            .addOnSuccessListener { result ->
//                studentCount = result.size()
//            }
//            .addOnFailureListener { exception ->
//                // Handle failures
//            }
//    }
//
//    Scaffold(
//        topBar = {
//            CenterAlignedTopAppBar(
//                title = {
//                    Text(text = "Booking", color = Color.White, fontSize = 30.sp)
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xff0FB06A),
//                    titleContentColor = Color.White,
//                ),
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(Icons.Filled.ArrowBack, "backIcon",tint = Color.White)
//                    }
//                },
//
//
//
//            )
//        }, content = {
//            LazyColumn {
//                item {
//                    Column {
//
//
//            OutlinedTextField(
//                value = name,
//                onValueChange = { name = it },
//                label = { Text("name") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = email,
//                onValueChange = { email= it },
//                label = { Text("email") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//
//            OutlinedTextField(
//                value = number,
//                onValueChange = { number= it },
//                label = { Text("Phone Number") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = location,
//                onValueChange = { location= it },
//                label = { Text(" Your Location") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = Budget,
//                onValueChange = { Budget= it },
//                label = { Text(" Your Budget") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = Date,
//                onValueChange = { Date= it },
//                label = { Text(" Date of the Event") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//
//            OutlinedTextField(
//                value = capacity,
//                onValueChange = { capacity= it },
//                label = { Text("Capacity of people") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//                        OutlinedTextField(
//                            value = event,
//                            onValueChange = {event= it },
//                            label = { Text("Type of Event") },
//                            modifier = Modifier.fillMaxWidth()
//                        )
//                        Spacer(modifier = Modifier.height(8.dp))
//
//
//
//                        OutlinedTextField(
//                            value = Description,
//                            onValueChange = {Description= it },
//                            label = { Text("Description of the Event") },
//                            modifier = Modifier.fillMaxWidth()
//                        )
//                        Spacer(modifier = Modifier.height(8.dp))
//
//
//
//                        androidx.compose.material3.Button(
//                            modifier = Modifier
//                                .padding(9.dp)
//                                .fillMaxWidth()
//                                .width(400.dp)
//                            ,
//
//                            onClick = {
//                                if (name.isBlank()){
//                                    error("Fill name")
//                                }else if (email.isBlank()){
//                                    error("Fill email")
//                                }else if (number.isBlank()){
//                                    error("Fill Phone number")
//                                }else if (location.isBlank()){
//                                    error("Fill location")
//                                }else if (Budget.isBlank()){
//                                    error("Fill your budget")
//                                }else if (Date.isBlank()){
//                                    error("Fill Date")
//                                }else if (capacity.isBlank()){
//                                    error("Fill capacity")
//                                }else if (event.isBlank()){
//                                    error("Fill event")
//                                }else if (Description.isBlank()){
//                                    error("Fill the Description space")
//                                }else{
//                                    isLoading=true
//                                    save Booking
//                                }
//
//
//                                navController.navigate(ROUTE_ABOUT)
//                            },
//                            colors = ButtonDefaults.buttonColors(Color(0xffaf7ac5)),
//                            shape = CutCornerShape(10.dp),
//
//                            )
//                        {
//                            Text(
//                                text = "save Booking",
//                                modifier = Modifier,
//                                fontSize = (19.sp),
//                                fontWeight = FontWeight.Bold
//                            )
//                        }
//
//
//                    }
//  }
//}
//
//
//
//        }   //content
//    )
//
//}
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
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun DashboardItem(item: DashboardItemData) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        shape = RoundedCornerShape(8.dp),
//        elevation = 8.dp,
//        backgroundColor = Color.White,
//        onClick = item.onClick
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = item.icon,
//                contentDescription = "Dashboard Icon",
//                tint = Color.Black,
//                modifier = Modifier.size(36.dp)
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Text(
//                text = item.title,
//                style = MaterialTheme.typography.subtitle1,
//                color = Color.Black
//            )
//            // Add a badge if the badge count is greater than 0
//            if (item.badgeCount > 0) {
//                Badge(count = item.badgeCount)
//            }
//        }
//    }
//}
//@Composable
//fun Badge(count: Int) {
//    Box(
//        modifier = Modifier
//            .padding(start = 8.dp)
//            .size(20.dp)
//            .clip(CircleShape)
//            .background(Color.Red),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = count.toString(),
//            style = MaterialTheme.typography.caption,
//            color = Color.White
//        )
//    }
//}
//data class DashboardItemData(
//    val title: String,
//    val icon: ImageVector,
//    val badgeCount: Int,
//    val onClick: () -> Unit
//)
//data class User(
//    val userId: String = "",
//    val school: String = "",
//    val name: String = ""
//)
//
//fun saveUserDetails(user: User, param: (Any) -> Unit) {
//    val firestore = FirebaseFirestore.getInstance()
//    firestore.collection("users").document(user.userId)
//        .set(user, SetOptions.merge())
//        .addOnSuccessListener {
//
//            progressDialog?.dismiss()
//            // Success message or navigation
//        }
//        .addOnFailureListener {
//
//            progressDialog?.dismiss()
//            // Handle failure
//        }
//}

package com.studynotes.phonebook

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class ContactDetailActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val contact = intent.getSerializableExtra("EXTRA_CONTACT") as? Contact
            Scaffold (
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            IconButton(onClick = {}) {
                                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                            }
                        },
                        title = {

                        }
                    )
                },
                content = {
                    DetailView(contact!!)
                }
            )
        }
    }
}

@Composable
fun DetailView(contact: Contact) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Box(
            modifier = Modifier
                .padding(top = 80.dp)
                .size(150.dp)
                .background(
                    color = colorResource(R.color.leading_box_icon),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = contact.firstName[0].uppercase(),
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(Modifier.height(22.dp))

        Text(
            "${contact.firstName} ${contact.lastName}",
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )

        Spacer(Modifier.height(12.dp))

        Text(contact.phone, fontSize = 18.sp, color = Color.Black)

        Spacer(Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            CustomIconButton(Icons.Default.Call) {
                callAction(context, contact.phone)
            }

            Spacer(Modifier.width(24.dp))

            CustomIconButton(Icons.Default.MailOutline) {
                messageAction(context, contact.phone)
            }

        }
    }

}

private fun callAction(context: Context, phoneNumber: String) {

    val intent = Intent(Intent.ACTION_DIAL)
    intent.setData(Uri.parse("tel:$phoneNumber"))
    context.startActivity(intent)


}

private fun messageAction(context: Context, phoneNumber: String) {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.setData(Uri.parse("smsto:$phoneNumber"))
    context.startActivity(intent)
}

@Composable
fun CustomIconButton(icon: ImageVector, clickAction: () -> Unit) {

    IconButton(
        onClick = clickAction
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(
                    color = Color(0xFFEBFAFF),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = "Icon button")
        }
    }


}
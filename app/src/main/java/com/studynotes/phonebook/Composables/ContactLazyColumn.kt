package com.studynotes.phonebook.Composables

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.studynotes.phonebook.Contact
import com.studynotes.phonebook.ContactDetailActivity
import com.studynotes.phonebook.R

@Composable
fun ContactLazyColumn(contacts: List<Contact>, onDelete: (Contact)-> Unit) {
    LazyColumn(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 5.dp)
    ) {
        items(contacts) {
            ContactItemCard(it, onDelete)
        }
    }
}

@Composable
fun ContactItemCard(contact: Contact, onDelete: (Contact)-> Unit) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 5.dp, bottom = 2.dp)
            .clickable {
                val intent = Intent(context, ContactDetailActivity::class.java)
                intent.putExtra("EXTRA_CONTACT", contact)
                context.startActivity(intent)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5FF),
            contentColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = colorResource(R.color.leading_box_icon),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contact.firstName[0].uppercase(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "${contact.firstName} ${contact.lastName}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Text(contact.phone, fontSize = 14.sp, color = Color.Black)
            }

            IconButton(
                onClick = {
                    onDelete(contact)
                },
                colors = IconButtonDefaults.iconButtonColors(Color.Black),
                modifier = Modifier.size(25.dp)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "")
            }

        }
    }

}


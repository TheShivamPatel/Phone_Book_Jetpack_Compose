package com.studynotes.phonebook.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.studynotes.phonebook.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {

    TopAppBar(
        modifier = Modifier.padding(0.dp),
        title = {
            Row (
                horizontalArrangement = Arrangement.Center
            ){
                Image(painter = painterResource(R.drawable.ic_phone_book), contentDescription = "phone book image", modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Phone Book", fontWeight = FontWeight.ExtraBold)
            }
        },
    )
}

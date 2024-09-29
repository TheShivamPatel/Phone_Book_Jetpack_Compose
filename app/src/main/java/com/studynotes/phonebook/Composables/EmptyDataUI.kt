package com.studynotes.phonebook.Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.studynotes.phonebook.R

@Preview
@Composable
fun EmptyDataUi(){

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(R.drawable.ic_phone_book), contentDescription = "Phone Book image")
        Spacer(Modifier.height(16.dp))
        Text("Welcome To Phone Book", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Text("Add your first contact!", fontSize = 16.sp, fontWeight = FontWeight.W200)
    }

}
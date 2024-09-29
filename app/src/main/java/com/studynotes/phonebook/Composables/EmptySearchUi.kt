package com.studynotes.phonebook.Composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun EmptySearchUi(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 100.dp)
    ){
        Text("Oops!", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        Text("Not found a contact related to your search", fontSize = 16.sp, fontWeight = FontWeight.W200)
    }
}
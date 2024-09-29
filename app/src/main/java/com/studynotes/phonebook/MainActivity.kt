package com.studynotes.phonebook

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.studynotes.phonebook.Composables.ContactLazyColumn
import com.studynotes.phonebook.Composables.EmptyDataUi
import com.studynotes.phonebook.Composables.EmptySearchUi
import com.studynotes.phonebook.Composables.FabAddContact
import com.studynotes.phonebook.Composables.SearchBox
import com.studynotes.phonebook.Composables.TopBar

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listOfContact by remember {
                mutableStateOf(mutableStateListOf<Contact>())
            }

            var searchValue by remember {
                mutableStateOf("")
            }

            val filteredContact = listOfContact.filter {
                it.firstName.contains(searchValue, ignoreCase = true) || it.phone.contains(
                    searchValue,
                    ignoreCase = true
                ) || it.lastName.contains(searchValue, ignoreCase = true)
            }

            val deleteContact: (Contact) -> Unit = { contact ->
                listOfContact.remove(contact)
            }


            Scaffold(
                topBar = {
                    TopBar()
                },
                content = {
                    if (listOfContact.isEmpty()) {
                        EmptyDataUi()
                    } else {
                        Column {
                            SearchBox(searchValue) {
                                searchValue = it
                            }
                            Spacer(Modifier.height(12.dp))
                            if (filteredContact.isEmpty()) {
                                EmptySearchUi()
                            } else {
                                ContactLazyColumn(filteredContact, deleteContact)
                            }
                        }
                    }
                    FabAddContact(listOfContact)
                }
            )
        }
    }
}

package com.studynotes.phonebook.Composables

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.studynotes.phonebook.Contact


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FabAddContact(mutableList: MutableList<Contact>) {

    val context = LocalContext.current

    var isBottomSheetOpen by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                isBottomSheetOpen = true
            },
            modifier = Modifier.padding(
                18.dp
            )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Search Icon",
            )
        }
    }

    if (isBottomSheetOpen)
        ModalBottomSheet(
            onDismissRequest = {
                isBottomSheetOpen = false
            }
        ) {

            Column {
                val firstName = bottomSheetTextField(
                    hint = "First Name",
                    leadingIcon = Icons.Default.Person,
                    keyboardType = KeyboardType.Text
                )
                val secondName = bottomSheetTextField(
                    hint = "Second Name",
                    leadingIcon = Icons.Default.Person,
                    keyboardType = KeyboardType.Text
                )
                val number = bottomSheetTextField(
                    hint = "Number ",
                    leadingIcon = Icons.Default.Phone,
                    keyboardType = KeyboardType.Phone
                )
                Spacer(Modifier.height(30.dp))
                Button(
                    onClick = {
                        if (firstName.isBlank() || secondName.isBlank() || number.isBlank()) {
                            Toast.makeText(
                                context,
                                "Please fill required filed",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val contact = Contact(firstName, secondName, number)
                            mutableList.add(contact)
                            isBottomSheetOpen = false
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Create Contact")
                }
            }
        }
}

@Composable
fun bottomSheetTextField(
    hint: String,
    leadingIcon: ImageVector,
    keyboardType: KeyboardType
): String {

    var isInputError by remember {
        mutableStateOf(false)
    }

    var text by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        placeholder = {
            Text(text = hint)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 12.dp),

        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "Search Icon",
                tint = Color.Gray
            )
        },
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        isError = isInputError
    )

    return text
}

package com.french.example.roomdemo.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.roomdemo.data.entities.Customer
import com.example.roomdemo.models.CustomerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCustomerDialog(customerViewModel: CustomerViewModel,
                      setShowDialog: (Boolean) -> Unit) {

    val nameTxtFieldError = remember { mutableStateOf("Enter valid customer name")}
    val ageTxtFieldError = remember { mutableStateOf("Enter valid customer age")}
    val emailTxtFieldError = remember { mutableStateOf("Enter valid customer email")}
    val nameTxtField = remember { mutableStateOf("")}
    val ageTxtField = remember { mutableStateOf("")}
    val emailTxtField = remember { mutableStateOf("")}

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "New Customer",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Icon(
                            imageVector = Icons.Filled.Cancel,
                            contentDescription = "",
                            tint = colorResource(android.R.color.darker_gray),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = if (nameTxtFieldError.value.isEmpty()) Color.Green else Color.Red
                                ),
                                shape = RoundedCornerShape(50)
                            ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.TextFields,
                                contentDescription = "",
                                tint = Color.Green,
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        },
                        placeholder = { Text(text = nameTxtFieldError.value) },
                        value = nameTxtField.value,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = {
                            nameTxtField.value = it
                        })

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = if (ageTxtFieldError.value.isEmpty()) Color.Green else Color.Red
                                ),
                                shape = RoundedCornerShape(50)
                            ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.TextFields,
                                contentDescription = "",
                                tint = Color.Green,
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        },
                        placeholder = { Text(text = ageTxtFieldError.value) },
                        value = ageTxtField.value,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            ageTxtField.value = it
                        })

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = if (emailTxtFieldError.value.isEmpty()) Color.Green else Color.Red
                                ),
                                shape = RoundedCornerShape(50)
                            ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.TextFields,
                                contentDescription = "",
                                tint = Color.Green,
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        },
                        placeholder = { Text(text = emailTxtFieldError.value) },
                        value = emailTxtField.value,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        onValueChange = {
                            emailTxtField.value = it
                        })

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                //reset error messages
                                nameTxtFieldError.value = ""
                                ageTxtFieldError.value = ""
                                emailTxtFieldError.value = ""

                                //validate name - not validating if duplicate name
                                if (!checkName(nameTxtField.value)) {
                                    nameTxtFieldError.value = "Invalid name"
                                }

                                //validate age
                                if (!checkAge(ageTxtField.value)) {
                                    ageTxtFieldError.value = "Age must be between 18 and 99"
                                }

                                //validate email
                                if (!checkEmail(emailTxtField.value)) {
                                    emailTxtFieldError.value = "Invalid email address"
                                }

                                if (nameTxtFieldError.value.isNotEmpty() ||
                                    ageTxtFieldError.value.isNotEmpty() ||
                                    emailTxtFieldError.value.isNotEmpty()) {
                                    return@Button
                                }

                                //create and insert customer
                                customerViewModel.insertCustomer(
                                    Customer(
                                        name = nameTxtField.value,
                                        age = ageTxtField.value.toInt(),
                                        emailId = emailTxtField.value
                                    )
                                )
                                setShowDialog(false)
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}//dialog

fun checkName(name: String): Boolean =
    name.split(' ').all { !it.isEmpty() && it[0].isUpperCase() }

fun checkAge(age: String): Boolean {

    age.toIntOrNull().let { num ->
        if (num == null) {
            return false
        } else return num in 18..99
    }
}

fun checkEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

package com.example.roomdemo.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roomdemo.models.CustomerViewModel
import com.french.example.roomdemo.ui.AddCustomerDialog
import kotlin.random.Random

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CustomerList(customerViewModel: CustomerViewModel) {

    val customerListState = customerViewModel.fetchAllCustomer().collectAsState(initial = emptyList())
    val customerList = customerListState.value

    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        AddCustomerDialog(customerViewModel, setShowDialog = { showDialog.value = it })
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            ExtendedFloatingActionButton(
                containerColor = Color.Red,
                text = {
                    Text(text = "Customer", color = Color.White)
                },
                onClick = {
                    showDialog.value = true
//                    val name = UUID.randomUUID().toString()
//                    customerViewModel.insertCustomer(
//                        Customer(
//                            name = name,
//                            age = 25,
//                            emailId = "xyz@gmail.com"
//                        ),
//                    )
                }, icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "image",
                        tint = Color.White
                    )
                })
        },
        content = {
            LazyColumn(
                //modifier = Modifier.padding(innerPadding),
                content = {
                items(customerList)
                 {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp), content = {
                            val color =
                                Color(
                                    Random.nextInt(256),
                                    Random.nextInt(256),
                                    Random.nextInt(256)
                                )
                            Box(
                                content = {
                                    Text(
                                        text = (it.name ?: "")[0].uppercase(),
                                        fontSize = 24.sp,
                                        color = color
                                    )
                                }, modifier = Modifier
                                    .size(80.dp)
                                    .border(width = 1.2.dp, color = color, shape = CircleShape),
                                contentAlignment = Alignment.Center
                            )
                            Spacer(modifier = Modifier.size(16.dp))
                            Column(
                                modifier = Modifier.weight(2F),
                                content = {
                                    Spacer(modifier = Modifier.size(8.dp))
                                    Text(
                                        text = it.name ?: "",
                                        color = color,
                                        fontSize = 16.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = "${it.age}",
                                        color = Color.Black,
                                        fontSize = 14.6.sp
                                    )
                                    Text(
                                        text = "${it.emailId}",
                                        color = Color.Gray,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                })
                            Spacer(modifier = Modifier.size(16.dp))
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "image",
                                tint = Color.Red, modifier = Modifier
                                    .size(30.dp)
                                    .clickable(onClick = {
                                        customerViewModel.deleteCustomerById(it.id)
                                    })
                            )
                        })
                }
            })
        })

}

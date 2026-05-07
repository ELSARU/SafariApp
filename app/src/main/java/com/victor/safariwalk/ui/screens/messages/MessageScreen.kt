package com.victor.safariwalk.ui.screens.messages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.victor.safariwalk.data.Message
import com.victor.safariwalk.data.models.MessageViewModel
import com.victor.safariwalk.data.repositories.MessageRepository

@Composable
fun MessageScreen(
    modifier: Modifier = Modifier,
    // Creating the ViewModel with the repository manually for now since DI isn't set up
    viewModel: MessageViewModel = MessageViewModel(MessageRepository())
) {
    val response by viewModel.response.observeAsState()
    val clientMessage = Message("REQ-101", "Request for product quotation")

    // Trigger communication once when screen opens
    LaunchedEffect(Unit) {
        viewModel.communicateWithCompany(clientMessage)
    }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Client: ${clientMessage.code} - ${clientMessage.content}")
        Spacer(modifier = Modifier.height(8.dp))
        
        response?.let { reply ->
            Text(text = "Company: ${reply.code} - ${reply.content}")
        }
    }
}

package com.csanad.littlelemon.composable

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.little_lemon.R
import com.example.little_lemon.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(navController: NavHostController, prefs: SharedPreferences) {
    val firstName = remember {
        mutableStateOf("")
    }
    val lastName = remember {
        mutableStateOf("")
    }
    val emailAddress = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp),
            alignment = Alignment.TopCenter
        )
        Text(
            text = "Let's get to know you", modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.little_lemon_primary_green))
                .padding(20.dp), textAlign = TextAlign.Center,
            color = colorResource(id = R.color.little_lemon_highlight_light),
            fontSize = 48.sp,
            lineHeight = 58.sp
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1.0f)
                .padding(20.dp), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Personal information".uppercase(),
                modifier = Modifier.padding(vertical = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            )
            TextField(
                value = firstName.value,
                onValueChange = { firstName.value = it },
                label = { Text(text = "First name*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )
            TextField(
                value = lastName.value,
                onValueChange = { lastName.value = it },
                label = { Text(text = "Last name*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )
            TextField(
                value = emailAddress.value,
                onValueChange = { emailAddress.value = it },
                label = { Text(text = "Email address*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
        }
        Button(
            onClick = {
                if (firstName.value.isNotBlank() && lastName.value.isNotBlank() && emailAddress.value.isNotBlank()) {
                    if (prefs.edit().putString("firstName", firstName.value)
                            .putString("lastName", lastName.value).putString("emailAddress", emailAddress.value)
                            .putBoolean("logged", true).commit()
                    ) {
                        navController.popBackStack(Screens.Onboarding.rout, true)
                        navController.navigate(Screens.Home.rout)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.little_lemon_primary_yellow),
                contentColor = colorResource(id = R.color.little_lemon_highlight_dark)
            ), shape = RoundedCornerShape(16.dp)
        ) { Text(text = "Register") }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun OnboardingPreview() {
//    LittleLemonTheme {
//        //Onboarding()
//    }
//}
package com.csanad.littlelemon.composable

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.little_lemon.R
import com.example.little_lemon.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavHostController, prefs: SharedPreferences) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
                .padding(end = 100.dp),
            alignment = Alignment.TopStart
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
                value = prefs.getString("firstName", "")!!,
                onValueChange = {},
                label = { Text(text = "First name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                readOnly = true
            )
            TextField(
                value = prefs.getString("lastName", "")!!,
                onValueChange = {},
                label = { Text(text = "Last name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                readOnly = true
            )
            TextField(
                value = prefs.getString("emailAddress", "")!!,
                onValueChange = {},
                label = { Text(text = "Email address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                readOnly = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.weight(1.0f))
        }
        Button(
            onClick = {
                if (prefs.edit().clear().commit()) {
                    navController.popBackStack(Screens.Home.rout, true)
                    navController.navigate(Screens.Onboarding.rout)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary_yellow),
                contentColor = colorResource(id = R.color.highlight_dark)
            ), shape = RoundedCornerShape(16.dp)
        ) { Text(text = "Log out") }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProfilePreview() {
//    LittleLemonTheme {
//        //Profile()
//    }
//}
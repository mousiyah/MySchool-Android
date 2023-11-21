package com.example.MySchool.Screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.vector.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import com.example.MySchool.Components.*
import com.example.MySchool.R
import com.example.MySchool.ViewModels.AuthenticationViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewModel = remember { AuthenticationViewModel() }

    val keyboardController = LocalSoftwareKeyboardController.current

    val padding = 16.dp

    Box (modifier = Modifier
        .fillMaxSize()
        .hideKeyboardOnTap(keyboardController)
        .padding(padding)) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {

            LoginBannerImage(
                imageResource = R.drawable.banner_school,
                contentDescription = stringResource(id = R.string.school_image)
            )

            Logo()

            VerticalSpacer(padding)

            CustomTextField(
                value = username,
                onValueChange = { username = it },
                label = stringResource(id = R.string.username),
                icon = R.drawable.ic_user
            )

            VerticalSpacer(padding)

            CustomTextField(
                value = password,
                onValueChange = { password = it },
                label = stringResource(id = R.string.password),
                icon = R.drawable.ic_password,
                isPassword = true
            )

            VerticalSpacer(padding)

            MainButton(
                stringResource(id = R.string.login),
                onClick = {
                    // Handle login button click here
                    val loginSuccess = viewModel.performLogin(username, password)
                    if (loginSuccess) {
                        // Navigate to Dashboard
                        onLoginSuccess.invoke()
                    }
                }
            )

            VerticalSpacer(padding)

            PasswordResetText()
        }
    }
}

@Composable
fun VerticalSpacer(padding: Dp) {
    Spacer(modifier = Modifier.height(padding))
}

@Composable
fun Logo() {
    val titleFont = FontFamily(Font(R.font.unicorn)) // Replace with your font file name
    Text(
        text = stringResource(id = R.string.app_name),
        style = TextStyle(
            fontFamily = titleFont,
            fontSize = 64.sp // Adjust the font size as needed
        ),
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun LoginBannerImage(imageResource: Int, contentDescription: String) {
    Box(modifier = Modifier.fillMaxWidth())
    Image(
        painter = painterResource(imageResource),
        contentDescription = contentDescription
        )
}

@Composable
fun PasswordResetText() {
    Row {
        Text(
            text = stringResource(id = R.string.forgot_password),
        )
        Text(
            text = stringResource(id = R.string.reset_password),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clickable { /* Handle Forgot Password action */ }
                .padding(start = 4.dp)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun Modifier.hideKeyboardOnTap(keyboardController: SoftwareKeyboardController?) =
    pointerInput(Unit) {
        detectTapGestures(onTap = { keyboardController?.hide() })
    }

package com.example.moviesstore.presentation.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.moviesstore.model.User
import com.example.moviesstore.ui.theme.GrayVeryLight

data class TextFieldState(
    val value: String, val keyboardType: KeyboardType = KeyboardType.Text, val error: String
)

@Composable
fun UserInfoFields(
    login: (User) -> Unit
) {
    val userInfo = remember {
        linkedMapOf<String, MutableState<TextFieldState>>().apply {
            put("email", mutableStateOf(TextFieldState("", KeyboardType.Email, "")))
            put("password", mutableStateOf(TextFieldState("", KeyboardType.Password, "")))
        }
    }
    val shape = RoundedCornerShape(5.dp)
    Column {
        userInfo.entries.forEachIndexed { index, (label, textFieldState) ->
            val textFieldStateValue = textFieldState.value
            var show by remember { mutableStateOf(textFieldStateValue.keyboardType != KeyboardType.Password) }
            OutlinedTextField(
                value = textFieldStateValue.value,
                onValueChange = {
                    userInfo[label]!!.value = userInfo[label]!!.value.copy(value = it)
                    userInfo[label]!!.value = userInfo[label]!!.value.copy(error = "")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = shape,
                visualTransformation = if (show) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = textFieldStateValue.keyboardType,
                    imeAction = if (index < userInfo.entries.size - 1) ImeAction.Next else ImeAction.Done,
                ),
                label = { Text(label.replaceFirstChar(Char::titlecase)) },
                trailingIcon = {
                    if (textFieldStateValue.keyboardType == KeyboardType.Password)
                        Icon(
                            imageVector = if (show) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .clickable { show = !show },
                        )

                },
                isError = textFieldStateValue.error.isNotEmpty(),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                ),
            )
            if (textFieldStateValue.error.isNotEmpty()) {
                Text(
                    textFieldStateValue.error,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.overline
                )
            } else {
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }
        }

        Box(Modifier.fillMaxWidth()) {
            Text(
                "Forget Password?",
                modifier = Modifier.align(Alignment.CenterEnd),
                color = GrayVeryLight,
                style = MaterialTheme.typography.overline
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val email = userInfo["email"]!!.value.value
                userInfo["email"]!!.value = userInfo["email"]!!.value.copy(
                    error = if (email.isEmpty())
                        "Field should not be empty"
                    else if (!isEmailValid(email))
                        "Email is not valid"
                    else
                        ""
                )

                val password = userInfo["password"]!!.value.value
                userInfo["password"]!!.value = userInfo["password"]!!.value.copy(
                    error = if (password.isEmpty())
                        "Field should not be empty"
                    else if (password.length < 8)
                        "password should contain more than 8 characters"
                    else if ("[!@#$&*~(\\]".none { it in  password})
                        "password should contain at least one special character"
                    else
                        ""
                )

                if (userInfo["password"]!!.value.error == "" && userInfo["email"]!!.value.error == "") {
                    login(
                        User(
                            password = password,
                            email = email,
                        )
                    )
                }

            }, shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.button
            )
        }
    }
}

const val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
fun isEmailValid(email: String): Boolean {
    return EMAIL_REGEX.toRegex().matches(email)
}

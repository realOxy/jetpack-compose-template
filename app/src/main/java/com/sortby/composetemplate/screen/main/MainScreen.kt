package com.sortby.composetemplate.screen.main

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.sortby.composetemplate.R
import com.sortby.composetemplate.ui.LocalSpacing
import com.sortby.composetemplate.ui.components.*
import com.sortby.composetemplate.ui.theme.LocalTheme
import androidx.compose.material3.LocalContentColor as LocalContentColor3

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val theme = LocalTheme.current
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(theme.topBar)
                    .statusBarsPadding()
                    .height(56.dp)
            ) {
                CompositionLocalProvider(
                    LocalContentColor provides theme.onTopBar,
                    LocalContentColor3 provides theme.onTopBar,
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = spacing.medium)
                    )
                }

            }
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(spacing.small),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(spacing.medium)
        ) {
            var textFieldValue by remember {
                mutableStateOf(TextFieldValue())
            }
            MaterialTextField(
                textFieldValue = textFieldValue,
                onValueChange = { textFieldValue = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Email",
                keyboardType = KeyboardType.Email
            )
            var textFieldPasswordValue by remember {
                mutableStateOf(TextFieldValue())
            }
            MaterialPasswordTextField(
                textFieldValue = textFieldPasswordValue,
                onValueChange = { textFieldPasswordValue = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Password"
            )
            MaterialButton(
                text = textFieldValue.text,
                modifier = Modifier.fillMaxWidth()
            ) {
                Toast.makeText(context, "Button clicked!", Toast.LENGTH_SHORT).show()
            }
            MaterialTextButton(
                text = textFieldPasswordValue.text,
                modifier = Modifier.fillMaxWidth()
            ) {
                Toast.makeText(context, "Text Button clicked!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
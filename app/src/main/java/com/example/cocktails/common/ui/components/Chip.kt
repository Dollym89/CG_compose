package com.example.cocktails.common.ui.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
    selectedTextColor: Color = MaterialTheme.colors.onPrimary,
    text: String?,
    btnState: ButtonState = ButtonState.IDLE,
    onBtnSelected: (Boolean) -> Unit,
) {
    var buttonState: ButtonState by remember {
        mutableStateOf(btnState)
    }

    val shape = RoundedCornerShape(corner = CornerSize(12.dp))

    val transition = updateTransition(
        targetState = buttonState,
        label = "JoinButtonTransition"
    )

    val duration = 600
    val buttonBackgroundColor: Color by transition.animateColor(
        transitionSpec = { tween(duration) },
        label = "Button Background Color"
    ) { state ->
        when (state) {
            ButtonState.IDLE -> {
                Color.Transparent
            }
            ButtonState.PRESSED -> {
                color
            }
        }
    }
//    val buttonWidth: Dp by transition.animateDp(
//        transitionSpec = { tween(duration) },
//        label = "Button Width"
//    ) { state ->
//        when (state) {
//            ButtonState.IDLE -> 70.dp
//            ButtonState.PRESSED -> 32.dp
//        }
//    }
//    val textMaxWidth: Dp by transition.animateDp(
//        transitionSpec = { tween(duration) },
//        label = "Text Max Width"
//    ) { state ->
//        when (state) {
//            ButtonState.IDLE -> 40.dp
//            ButtonState.PRESSED -> 0.dp
//        }
//    }

    val buttonTextColor: Color by animateColorAsState(
        if (buttonState == ButtonState.PRESSED) {
            selectedTextColor
        } else {
            color
        }
    )

    Row(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .clip(shape)
            .wrapContentWidth()
            .background(buttonBackgroundColor)
            .border(BorderStroke(2.dp, color), shape = shape)
            .clickable {
                buttonState = if (buttonState == ButtonState.IDLE) {
                    onBtnSelected.invoke(true)
                    ButtonState.PRESSED
                } else {
                    onBtnSelected.invoke(false)
                    ButtonState.IDLE
                }
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        text?.let {
            Text(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                text = it,
                color = buttonTextColor,
                style = MaterialTheme.typography.body2,
                maxLines = 1,
            )
        }
    }
}

enum class ButtonState {
    IDLE,
    PRESSED
}

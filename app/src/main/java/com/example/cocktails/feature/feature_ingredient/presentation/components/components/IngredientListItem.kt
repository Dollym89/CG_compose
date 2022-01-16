package com.example.cocktails.feature.feature_ingredient.presentation.components.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.cocktails.BuildConfig
import com.example.cocktails.common.ui.theme.space
import com.example.cocktails.feature.feature_ingredient.domain.model.Ingredient

@ExperimentalCoilApi
@Composable
fun IngredientListItem(
    ingredient: Ingredient,
    onItemClick: (Ingredient) -> Unit
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onItemClick(ingredient) },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = rememberImagePainter(
                    data = BuildConfig.INGREDIENT_FULL_IMG_URL + ingredient.imgFileName,
                    builder = { crossfade(true) },
                ),
                contentScale = ContentScale.Crop,
                contentDescription = "Ingredient Img"
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = ingredient.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
                    .padding(horizontal = MaterialTheme.space.tiny),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

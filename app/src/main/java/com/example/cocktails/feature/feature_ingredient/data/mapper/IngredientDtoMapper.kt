package com.example.cocktails.feature.feature_ingredient.data.mapper

import com.example.cocktails.common.data.Mapper
import com.example.cocktails.feature.feature_ingredient.data.local.entity.IngredientEntity
import com.example.cocktails.feature.feature_ingredient.data.remote.dto.IngredientDto

object IngredientDtoMapper : Mapper<IngredientDto, IngredientEntity>() {

    override fun IngredientDto.convert(): IngredientEntity {
        return IngredientEntity(
            id = id,
            name = name,
            nameGrouped = nameGrouped,
            nameModif = nameModif,
            voltage = voltage, // only for alcoholic
            preparation = preparation, // only for non alcoholic
            desc = desc,
            imgFileName = imgFileName,
            videoUrl = videoUrl,
            websiteUrl = websiteUrl,
            tasteFK = tasteFK,
            numShowed = numShowed,
            dataCol = dataCol,
            categoryFK = categoryFK,
            numKcal = numKcal,
            flags = flags,
            type = type
        )
    }
}

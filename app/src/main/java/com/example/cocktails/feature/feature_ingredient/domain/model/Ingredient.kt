package com.example.cocktails.feature.feature_ingredient.domain.model

data class Ingredient(
    val id: Long,
    val name: String,
    val nameGrouped: String,
    val nameModif: String,
    val voltage: Double = -1.0, // only for alcoholic
    val preparation: String = "", // only for non alcoholic
    val desc: String,
    val imgFileName: String,
    val videoUrl: String,
    val websiteUrl: String,
    val tasteFK: Long,
    val numShowed: Long,
    val dataCol: String,
    val categoryFK: Long,
    val numKcal: Double,
    val flags: String,
    val type: Long
)

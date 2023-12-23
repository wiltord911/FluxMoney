package com.avatarcode.fluxmoney.ui.domain

import java.time.LocalDate

data class Transaction(
    val userName : String,
    val amount : Double,
    val date : LocalDate,
    val statut : String
)

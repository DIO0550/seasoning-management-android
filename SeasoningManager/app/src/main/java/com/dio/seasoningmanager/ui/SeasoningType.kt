package com.dio.seasoningmanager.ui

public enum class SeasoningType(val code: Int, val type: String) {
    MAYONNAISE(0, "マヨネーズ"),
    KETCHUP(1,  "ケチャップ"),
    SAUCE(2, "ソース"),
    PONZU(3, "ポンズ"),
    OTHER(9999, "その他")
}
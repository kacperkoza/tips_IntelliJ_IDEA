package com.example.tips_IntelliJ_IDEA.offer

interface AccountStatusClient {

    fun getAccountStatus(accountId: String): AccountStatus
}

enum class AccountStatus {
    TO_ACTIVATE,
    BLOCKED,
    ACTIVE,
}

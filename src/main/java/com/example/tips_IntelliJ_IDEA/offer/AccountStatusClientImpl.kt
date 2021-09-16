package com.example.tips_IntelliJ_IDEA.offer

import org.springframework.stereotype.Component

@Component
class AccountStatusClientImpl : AccountStatusClient {

    override fun getAccountStatus(accountId: String): AccountStatus {
        return AccountStatus.ACTIVE
    }
}

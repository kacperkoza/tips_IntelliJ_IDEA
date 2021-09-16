package com.example.tips_IntelliJ_IDEA.offer

import org.springframework.stereotype.Repository
import java.net.URI

@Repository
class InMemoryRepository : OffersRepository {

    override fun getOffers(): List<Offer> {
        return listOf(
            Offer(1L, "test", URI("https://google.pl")),
            Offer(2L, "test", URI("https://google.pl")),
            Offer(3L, "test", URI("https://google.pl")),
            Offer(4L, "test", URI("https://google.pl")),
            Offer(5L, "test", URI("https://google.pl")),
            Offer(6L, "test", URI("https://google.pl")),
            Offer(7L, "test", URI("https://google.pl")),
            Offer(8L, "test", URI("https://google.pl")),
        )

    }

    override fun addOffer(accountId: String, offer: Offer) {

    }
}

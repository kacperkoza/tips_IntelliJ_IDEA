package com.example.tips_IntelliJ_IDEA.offer;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OffersService {

    private final OffersRepository offersRepository;
    private final AccountStatusClient accountStatusClient;

    public OffersService(OffersRepository offersRepository, AccountStatusClient accountStatusClient) {
        this.offersRepository = offersRepository;
        this.accountStatusClient = accountStatusClient;
    }

    public List<Offer> getOffers(Integer limit, Integer offset) {
        validate(limit, offset);
        List<Offer> offers = offersRepository.getOffers();
        return getOffersPaginated(limit, offset, offers);
    }


    public void add(Offer offer, String accountId) {
        if (List.of(AccountStatus.TO_ACTIVATE, AccountStatus.BLOCKED).contains(accountStatusClient.getAccountStatus(accountId))) {
            throw new IncorrectAccountStatusException();
        }
        offersRepository.addOffer(accountId, offer);
    }

    private void validate(Integer limit, Integer offset) {
        if (limit != null && limit < 0 || offset != null && offset < 0) {
            throw new InvalidPaginationException();
        }
    }

    private List<Offer> getOffersPaginated(Integer limit, Integer offset, List<Offer> offers) {
        List<Offer> offersPaginated = offers;
        if (offset != null && limit != null) {
            offersPaginated = offers.stream().skip(offset).limit(limit).collect(Collectors.toList());
        } else if (offset != null) {
            offersPaginated = offers.stream().skip(offset).collect(Collectors.toList());
        } else if (limit != null) {
            offersPaginated = offers.stream().limit(limit).collect(Collectors.toList());
        }
        return offersPaginated;
    }

}

class InvalidPaginationException extends RuntimeException {

}

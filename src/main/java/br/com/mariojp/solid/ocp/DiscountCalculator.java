package br.com.mariojp.solid.ocp;

import java.util.EnumMap;
import java.util.Map;

public class DiscountCalculator {
    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator() {
        this.policies = new EnumMap<>(CustomerType.class);
        policies.put(CustomerType.REGULAR, new RegularPolicy());
        policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        policies.put(CustomerType.PARTNER, new PartnerPolicy());
    }


    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.get(type);
        if (policy != null) {
            return policy.apply(amount);
        }
        return amount;
    }
}

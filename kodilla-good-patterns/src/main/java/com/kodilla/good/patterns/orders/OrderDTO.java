package com.kodilla.good.patterns.orders;

import java.util.Objects;

public class OrderDTO {
    private final long id;
    private final User user;
    private final boolean isOrdered;

    public OrderDTO(long id, User user, boolean isOrdered) {
        this.id = id;
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return id == orderDTO.id &&
                isOrdered == orderDTO.isOrdered &&
                Objects.equals(user, orderDTO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, isOrdered);
    }
}

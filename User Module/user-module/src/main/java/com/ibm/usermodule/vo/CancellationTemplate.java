package com.ibm.usermodule.vo;

public class CancellationTemplate {

    private BookingValueObject booking;

    private CancellationValueObject cancellation;

    public CancellationTemplate() {
    }

    public CancellationValueObject getCancellation() {
        return cancellation;
    }

    public void setCancellation(CancellationValueObject cancellation) {
        this.cancellation = cancellation;
    }

    public BookingValueObject getBooking() {
        return booking;
    }

    public void setBooking(BookingValueObject booking) {
        this.booking = booking;
    }
    
}

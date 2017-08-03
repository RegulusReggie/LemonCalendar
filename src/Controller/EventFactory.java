package Controller;

import Entity.Event;

import java.util.Random;

public class EventFactory {
    private EventFactory() {}

    public static Event getEventById(String id, int year, int month) {
        Random rand = new Random();
        return new Event(id, year, month, rand.nextInt(28) + 1, id);
    }
}

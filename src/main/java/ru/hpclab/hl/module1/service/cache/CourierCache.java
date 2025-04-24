package ru.hpclab.hl.module1.service.cache;

import ru.hpclab.hl.module1.dto.CourierDTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CourierCache {

    private static final Map<Long, CourierDTO> cache = new HashMap<>();

    public static Optional<CourierDTO> get(Long id) {
        return Optional.ofNullable(cache.get(id));
    }

    public static void put(CourierDTO courier) {
        if (courier != null && courier.getId() != null) {
            cache.put(courier.getId(), courier);
        }
    }

    public static void putAll(Collection<CourierDTO> couriers) {
        for (CourierDTO courier : couriers) {
            if (courier != null && courier.getId() != null) {
                cache.put(courier.getId(), courier);
            }
        }
    }

    public static Collection<CourierDTO> getAll() {
        return cache.values();
    }

    public static void remove(Long id) {
        cache.remove(id);
    }

    public static int size() {
        return cache.size();
    }

    public static void clear() {
        cache.clear();
    }

    public static boolean contains(Long id) {
        return cache.containsKey(id);
    }
}

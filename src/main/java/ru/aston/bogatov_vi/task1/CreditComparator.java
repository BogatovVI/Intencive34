package ru.aston.bogatov_vi.task1;

import java.util.Comparator;

public class CreditComparator implements Comparator<Credit> {
    @Override
    public int compare(Credit o1, Credit o2) {
        return o1.getUser().getSourName().compareTo(o2.getUser().getSourName());
    }
}

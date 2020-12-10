package model;

import java.util.ArrayList;

public interface Show {
    void showByTeam(String path);

    void showAll(String path);

    void sort(String path);

    ArrayList<?> csvToObject(String path);
}

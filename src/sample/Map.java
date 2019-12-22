package sample;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


class Map {
    public static List<Edge> edge = new ArrayList<>();

    static void addEdge(String place1, String place2, int backup) {//Добавить связь между двумя районами
        backup = -1;
        edge.add(new Edge(place1, place2, backup));
    }

    boolean nullable() {// проверка на пустоту списка edge
        if (edge.size() == 0) {
            System.out.println("Нету возможных точек");
            return true;
        }
        return false;
    }

    static void addBackup(String place1, String place2, int backup) {//Добавить информацию о пробке
        for (Edge u : edge) {
            if (u.getPoint1().equals(place1) && u.getPoint2().equals(place2)) {
                if (backup > 10) {
                    System.out.println("Максимальный бал пробки составляет 10");
                    break;
                }
                u.setBackup(backup);
            }
        }
    }

    static void addBackup2(String place1, String place2, int backup) {//Добавить информацию о пробке
        for (Edge u : edge) {
            if (u.getPoint1().equals(place1) && u.getPoint2().equals(place2)) {
                if (backup > 10) {
                    System.out.println("Максимальный бал пробки составляет 10");
                    break;
                }
                u.setBackup(backup);
            }
        }
    }

    void generatePath(String place1, String place2) {//Поиск маршрута
        int g = 0;
        LinkedList Way = new LinkedList();
        for(Edge e: edge){
            if (e.getPoint1().equals(place1) && e.getPoint2().equals(place2)) {
                System.out.println("Пусть который нужно пройти [" + place1 + ", " + place2 + "] Пробка составляет " + e.getBackup() / edge.size());
                return;
            }
        }
        for (Edge e : edge) {
            if (e.getPoint1().equals(place1)) {
                Way.add(place1);
                place1 = e.getPoint2();
                g += e.getBackup();
                if (e.getPoint2().equals(place2)) {
                    Way.add(place2);
                    System.out.println("Пусть который нужно пройти " + Way + "Пробка составляет " + g / edge.size());
                }
            }

        }

    }
}

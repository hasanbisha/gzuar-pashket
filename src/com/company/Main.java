package com.company;

import java.util.ArrayList;

class Helpers {
    static boolean isPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Gift {
    private String gift;
    private String id;

    Gift(String id, String gift) {
        // this.setId(this.generateId());
        this.setId(id);
        this.setGift(gift);
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String getGift() {
        return gift;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private String generateId() {
        int min = 1;
        int max = 1000;
        return Integer.toString(min + (int)(Math.random() * ((max - min) + 1)));
    }

    @Override
    public String toString() {
        return "Gift{" +
                "gift='" + this.getGift() + '\'' +
                ", id='" + this.getId() + '\'' +
                '}';
    }
}

class SantaClaus {
    private ArrayList<Gift> gifts = new ArrayList<Gift>();

    SantaClaus() {
        Gift e36 = new Gift("1", "e36 m3");
        Gift rx7 = new Gift("2", "rx7");
        Gift gtr = new Gift("3", "gtr");
        Gift supra = new Gift("4", "supra");
        Gift s15 = new Gift("5", "s15");
        Gift evo = new Gift("6", "evo");
        Gift civic = new Gift("7", "civic");
        this.gifts.add(e36);
        this.gifts.add(rx7);
        this.gifts.add(gtr);
        this.gifts.add(supra);
        this.gifts.add(s15);
        this.gifts.add(evo);
        this.gifts.add(civic);
    }

    public ArrayList<Gift> sortById()
    {
        ArrayList<Gift> clonedGifts = (ArrayList<Gift>) this.getGifts().clone();
        clonedGifts.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        return clonedGifts;
    }

    public ArrayList<Gift> sortByGift()
    {
        ArrayList<Gift> clonedGifts = (ArrayList<Gift>) this.getGifts().clone();
        clonedGifts.sort((o1, o2) -> o1.getGift().compareTo(o2.getGift()));
        return clonedGifts;
    }

    public boolean binarySearch(String id) {
        ArrayList<Gift> sortedList = this.sortById();

        int low = 0;
        int high = sortedList.size() - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            Gift gift = sortedList.get(middle);
            if (Integer.parseInt(gift.getId()) < Integer.parseInt(id)) {
                low = middle + 1;
            } else if (Integer.parseInt(gift.getId()) > Integer.parseInt(id)) {
                high = middle -1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int countPalindromes() {
        int count = 0;
        for (Gift gift : this.getGifts()) {
            if (Helpers.isPalindrome(gift.getGift())) {
                count++;
            }
        }
        return count;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }
}

public class Main {

    public static void main(String[] args) {
        SantaClaus santaClaus = new SantaClaus();
        System.out.println(santaClaus.getGifts());
        System.out.println(santaClaus.countPalindromes());
        System.out.println(santaClaus.sortByGift());
        System.out.println(santaClaus.sortById());
        System.out.println(santaClaus.binarySearch("8"));
        System.out.println("Gzuar pashket");
    }
}

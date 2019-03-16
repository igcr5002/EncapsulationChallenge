package com.company;

public class Printer {

    private int tonerLevel = 100;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, int pagesPrinted, boolean isDuplex) {
        if (tonerLevel<=100 || tonerLevel>0) {
            this.tonerLevel = tonerLevel;
        }
        this.pagesPrinted = pagesPrinted;
        this.isDuplex = isDuplex;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public void addToner (int toner) {

        if(tonerLevel+toner<=100) {
            tonerLevel += toner;
            System.out.println(toner + "% toner added. Current level of toner in printer is " + tonerLevel + "%");
        } else {
            int tonerAdded = 100-tonerLevel;
            tonerLevel=100;
            System.out.println((tonerAdded)+"% toner added. Current level of toner in printer is 100%. Unused toner = "+ (toner-tonerAdded) + "%");
        }

    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public void printPages(int pages) {

         if (tonerLevel - 0.1 * pages < 0) {

            System.out.println("Please add more toner! Toner is available to print only " + tonerLevel*10+ " pages.");
             System.out.println("Printer will print available pages!");
             pages = tonerLevel*10;
        }

         tonerLevel -= 0.1*pages;
        if(isDuplex) {
            if (pages % 2==0) {
                pagesPrinted += pages/2;
                System.out.println((pages/2) + " pages printed. Total pages printed: " + pagesPrinted);
                System.out.println("Remaining toner level: " + tonerLevel + "%");
            } else {
                pagesPrinted += pages/2+1;
                System.out.println((pages/2+1) + " pages printed. Total pages printed: " + pagesPrinted);
                System.out.println("Remaining toner level: " + tonerLevel + "%");
            }
        } else {

            pagesPrinted += pages;
            System.out.println(pages + " pages printed. Total printed pages: " + pagesPrinted);
            System.out.println("Remaining toner level: " + tonerLevel + "%");
        }
        if (tonerLevel == 0) {

            System.out.println("Printer is out of toner! Please refill!  ");
        }

    }

}

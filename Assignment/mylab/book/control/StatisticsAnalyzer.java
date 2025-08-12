package mylab.book.control;

import mylab.book.entity.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();

        for (Publication p : publications) {
            String type = getPublicationType(p);
            sum.put(type, sum.getOrDefault(type, 0) + p.getPrice());
            cnt.put(type, cnt.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avg = new HashMap<>();
        for (String t : sum.keySet()) {
            avg.put(t, sum.get(t) / (double) cnt.get(t));
        }
        return avg;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> count = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            count.put(type, count.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> ratio = new HashMap<>();
        int total = publications.length;
        for (String t : count.keySet()) {
            ratio.put(t, 100.0 * count.get(t) / total);
        }
        return ratio;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int total = publications.length;
        int hit = 0;
        for (Publication p : publications) {
            if (p.getPublishDate() != null && p.getPublishDate().startsWith(year)) hit++;
        }
        return 100.0 * hit / total;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        if (pub instanceof Magazine) return "����";
        if (pub instanceof ReferenceBook) return "����";
        return "��Ÿ";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat money = new DecimalFormat("#,###");
        DecimalFormat pct = new DecimalFormat("0.00");

        System.out.println("===== ���ǹ� ��� �м� =====");

        System.out.println("1. Ÿ�Ժ� ��� ����:");
        Map<String, Double> avg = calculateAveragePriceByType(publications);
        // ���� ������ ���
        System.out.println("   - �Ҽ�: " + money.format(Math.round(avg.getOrDefault("�Ҽ�", 0.0))) + "��");
        System.out.println("   - ����: " + money.format(Math.round(avg.getOrDefault("����", 0.0))) + "��");
        System.out.println("   - ����: " + money.format(Math.round(avg.getOrDefault("����", 0.0))) + "��");
        System.out.println();

        System.out.println("2. ���ǹ� ���� ����:");
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        System.out.println("   - �Ҽ�: " + pct.format(dist.getOrDefault("�Ҽ�", 0.0)) + "%");
        System.out.println("   - ����: " + pct.format(dist.getOrDefault("����", 0.0)) + "%");
        System.out.println("   - ����: " + pct.format(dist.getOrDefault("����", 0.0)) + "%");
        System.out.println();

        System.out.println("3. 2007�⿡ ���ǵ� ���ǹ� ����: "
                + pct.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}

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
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat money = new DecimalFormat("#,###");
        DecimalFormat pct = new DecimalFormat("0.00");

        System.out.println("===== 출판물 통계 분석 =====");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avg = calculateAveragePriceByType(publications);
        // 지정 순서로 출력
        System.out.println("   - 소설: " + money.format(Math.round(avg.getOrDefault("소설", 0.0))) + "원");
        System.out.println("   - 참고서: " + money.format(Math.round(avg.getOrDefault("참고서", 0.0))) + "원");
        System.out.println("   - 잡지: " + money.format(Math.round(avg.getOrDefault("잡지", 0.0))) + "원");
        System.out.println();

        System.out.println("2. 출판물 유형 분포:");
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        System.out.println("   - 소설: " + pct.format(dist.getOrDefault("소설", 0.0)) + "%");
        System.out.println("   - 참고서: " + pct.format(dist.getOrDefault("참고서", 0.0)) + "%");
        System.out.println("   - 잡지: " + pct.format(dist.getOrDefault("잡지", 0.0)) + "%");
        System.out.println();

        System.out.println("3. 2007년에 출판된 출판물 비율: "
                + pct.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}

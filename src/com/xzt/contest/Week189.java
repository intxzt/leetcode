package com.xzt.contest;

import java.util.*;

public class Week189 {
    /**
     * 5412. 在既定时间做作业的学生人数
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) res++;
        }
        return res;
    }

    /**
     * 5413. 重新排列句子中的单词
     * @param text
     * @return
     */
    public String arrangeWords(String text) {
        String[] s = text.split(" ");
        s[0] = s[0].toLowerCase();
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Arrays.sort(s, comparator);
        s[0] = s[0].substring(0, 1).toUpperCase() + s[0].substring(1);
        return Arrays.toString(s).replace("[", "").replace("]", "").replaceAll(",", "");
    }

    /**
     * 5414. 收藏清单
     * @param favoriteCompanies
     * @return
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> list = new ArrayList<>();
        List<Set<String>> cur = new ArrayList<>();
        favoriteCompanies.forEach(l -> cur.add((new HashSet<>(l))));
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i != j && cur.get(j).containsAll(cur.get(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     *5415. 圆形靶内的最大飞镖数量
     *
     * @param points
     * @param r
     * @return
     */
    public static int numPoints(int[][] points, int r) {
        int res = points.length > 0 ? 1 : 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double[] doubles = _getCircleCenter(points[i][0], points[i][1], points[j][0], points[j][1], r);
                if (doubles == null) continue;
                int ans1 = 2;
                int ans2 = 2;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) continue;
                    if (_getDistance(doubles[0], doubles[1], points[k][0], points[k][1]) <= r) {
                        ans1++;
                    }
                    if (_getDistance(doubles[2], doubles[3], points[k][0], points[k][1]) <= r) {
                        ans2++;
                    }
                }
                res = Math.max(res, Math.max(ans1, ans2));
            }
        }
        return res;
    }

    private static double _getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static double[] _getCircleCenter(int x1, int y1, int x2, int y2, int r) {
        if (_getDistance(x1, y1, x2, y2) > 2 * r) {
            return null;
        }
        if (x1 == x2) {
            double[] d = new double[4];
            d[1] = (y1 + y2) * 1.0 / 2;
            d[0] = Math.sqrt(r * r - (d[1] - y1) * (d[1] - y1)) + x1;
            d[2] = -Math.sqrt(r * r - (d[1] - y1) * (d[1] - y1)) + x1;
            d[3] = d[1];
            return d;
        }
        double c1 = (x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1) * 1.0 / (2 * (x2 - x1));
        double c2 = (y2 - y1) * 1.0 / (x2 - x1);  //斜率
        double A = (c2 * c2 + 1);
        double B = (2 * x1 * c2 - 2 * c1 * c2 - 2 * y1);
        double C = x1 * x1 - 2 * x1 * c1 + c1 * c1 + y1 * y1 - r * r;
        double[] d = new double[4];
        d[1] = (-B + Math.sqrt(B * B - 4 * A * C)) / (2 * A);
        d[0] = c1 - c2 * d[1];
        d[3] = (-B - Math.sqrt(B * B - 4 * A * C)) / (2 * A);
        d[2] = c1 - c2 * d[3];
        return d;
    }
}

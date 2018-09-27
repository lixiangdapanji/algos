import java.util.HashMap;
import java.util.Map;

public class _0149MaxPointsonaLine {
        public int maxPoints(Point[] points) {
            int n = points.length;
            int res = 0;

            for (int i = 0; i < n; i++) {
                Map<Point, Integer> map = new HashMap<>();
                int same = 1;
                int pointsMax = 0;
                for (int j = i + 1; j < n; j++) {
                    Point p1 = points[i];
                    Point p2 = points[j];
                    if (p1.x == p2.x && p1.y == p2.y) {
                        same++;
                    } else {
                        Point k = getSlope(p1, p2);
                        if (!map.containsKey(k)) {
                            map.put(k, 1);
                        } else {
                            map.put(k, map.get(k) + 1);
                        }

                        pointsMax = Math.max(pointsMax, map.get(k));
                    }
                }
                res = Math.max(res, pointsMax + same);
            }
            return res;
        }

        private Point getSlope(Point p1, Point p2) {
            int dx = p2.x - p1.x;
            int dy = p2.y - p1.y;

            if (dy == 0) {
                return new Point(p1.y, 0);
            }
            if (dx == 0) {
                return new Point(0, p1.x);
            }

            int d = gcd(dx, dy);
            return new Point(dy / d, dx / d);
        }

        private int gcd(int m, int n) {
            return n == 0 ? m : gcd(n, m % n);
        }

}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    @Override
    public boolean equals(Object that) {
        return that != null && that instanceof Point
                && ((Point)that).x == x && ((Point)that).y == y;
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }
}

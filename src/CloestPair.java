//import static java.lang.Math.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class CloestPair {
//	// 坐标点
//	static class Point {
//		public Point() {
//		}
//
//		public Point(double x, double y) {
//			this.x = x;
//			this.y = y;
//		}
//		double x;
//		double y;
//	}
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			int n = scanner.nextInt();
//			Point[] ps = new Point[n];
//			for (int i = 0; i < n; i++) {
//				double x = scanner.nextDouble();
//				double y = scanner.nextDouble();
//				ps[i] = new Point(x, y);
//			}
//			// 按照X轴坐标升序排序
//			Arrays.sort(ps, new Comparator() {
//				@Override
//				public int compare(Point o1, Point o2) {
//					if (o1.x < o2.x)
//						return -1;
//					if (o1.x > o2.x)
//						return 1;
//					if (o1.y < o2.y)
//						return -1;
//					if (o1.y > o2.y)
//						return 1;
//					return 0;
//				}
//			});
//			double minDis = minDistance(ps, 0, n - 1);
//			System.out.println(minDis);
//		}
//
//	}
//
//	/**
//	 * 点对之间的最小距离
//	 *
//	 * @param ps
//	 * @param l
//	 * @param r
//	 * @return
//	 */
//	public static double minDistance(Point[] ps, int l, int r) {
//		/**
//		 * 同一个点,不存在点对,距离不能取0,返回最大值
//		 */
//		if (l == r) {
//			return Double.MAX_VALUE;
//		}
//		if (l + 1 == r) {
//			return distance(ps[l], ps[r]);
//		}
//		int center = l + (r - l) / 2;
//		double dis1 = minDistance(ps, l, center);
//		double dis2 = minDistance(ps, center + 1, r);
//		double minDis = min(dis1, dis2);
//		ArrayList nearPoints = new ArrayList<>();
//		// 选出距离中间线小于minDis的点
//		for (Point p : ps) {
//			if (abs(ps[center].x - p.x) <= minDis) {
//				nearPoints.add(p);
//			}
//		}
//		// 按照Y轴升序排序
//		Collections.sort(nearPoints, new Comparator() {
//			@Override
//			public int compare(Point o1, Point o2) {
//				if (o1.y < o2.y)
//					return -1;
//				if (o1.y > o2.y)
//					return 1;
//				if (o1.x < o2.x)
//					return -1;
//				if (o1.x > o2.x)
//					return 1;
//				return 0;
//			}
//		});
//		for (int i = 0; i < nearPoints.size(); i++) {
//			for (int j = i + 1; j < nearPoints.size(); j++) {
//				if (nearPoints.get(j).y - nearPoints.get(i).y > minDis) {
//					break;// 元素y+1离元素i更远,没必要继续比较
//				}
//				double d = distance(nearPoints.get(j), nearPoints.get(i));
//				if (d < minDis) {
//					minDis = d;
//				}
//			}
//		}
//		return minDis;
//	}
//
//	public static double distance(Point p1, Point p2) {
//		if (p1 == p2)
//			return 0;
//		return sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2));
//	}
//
//}

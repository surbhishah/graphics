package fillAlgorithms;

import graphics.Point;

import java.util.Collections;
import java.util.LinkedList;

import lines.Line;
import shapes.Polygon;
public class ScanLineFillY implements ScanLineFill {
	public void fill(Polygon polygon) {
		EdgeRecord[] edgeRecords = createInitialEdgeRecords(polygon);
		LinkedList<EdgeRecord> edgeTable[] = createEdgeTable(edgeRecords,
				polygon);
		printEdgeRecords(edgeRecords);
		printEdgeTable(edgeTable);
		scanFill(edgeTable);
	}

	private EdgeRecord[] createInitialEdgeRecords(Polygon polygon) {
		Point vertices[] = polygon.vertices;
		int n = vertices.length;
		double xmin, increment;
		int ymax, ymin;
		Point current, next, nextToNext;
		EdgeRecord edgeRecords[] = new EdgeRecord[n];
		for (int i = 0; i < n; i++) {
			current = vertices[i];
			next = vertices[(i + 1) % n];
			nextToNext = vertices[(i + 2) % n];

			// xmin = x value of coordinate with minimum y value
			xmin = (current.y < next.y) ? current.x : next.x;
			// ymax = y value of coordinate with max y value
			ymax = (current.y < next.y) ? next.y : current.y;
			// ymin = y value of coordinate with minimum y value
			ymin = (current.y < next.y) ? current.y : next.y;

			increment = 1 / getSlope(current, next);

			if (current.y != next.y) {
				if (current.y < next.y && next.y < nextToNext.y) {
					// increasing
					if (edgeRecords[i] == null)
						edgeRecords[i] = new EdgeRecord(xmin, ymax - 1, ymin,
								increment);

				} else if (current.y > next.y && next.y > nextToNext.y) {
					// decreasing
					if (edgeRecords[i] == null)
						edgeRecords[i] = new EdgeRecord(xmin, ymax, ymin,
								increment);

					if (edgeRecords[(i + 1) % n] == null) {
						double xmin_nextEdge = (next.y < nextToNext.y) ? next.x
								: nextToNext.x;
						int ymin_nextEdge = (next.y < nextToNext.y) ? next.y
								: nextToNext.y;
						int ymax_nextEdge = (next.y < nextToNext.y) ? nextToNext.y
								: next.y;
						edgeRecords[(i + 1) % n] = new EdgeRecord(
								xmin_nextEdge, ymax_nextEdge - 1,
								ymin_nextEdge, 1 / getSlope(next, nextToNext));
					}

				} else {
					if (edgeRecords[i] == null)

						edgeRecords[i] = new EdgeRecord(xmin, ymax, ymin,
								increment);

				}

			}

		}
		return edgeRecords;
	}

	private void printEdgeRecords(EdgeRecord edgeRecords[]) {
		System.out.println("(xmin,ymin, ymax, increment)");
		for (int i = 0; i < edgeRecords.length; i++) {
			if (edgeRecords[i] != null)
				System.out.println("EdgeRecord " + i
						+ edgeRecords[i].toString());
		}
	}

	private LinkedList<EdgeRecord>[] createEdgeTable(EdgeRecord edgeRecords[],
			Polygon polygon) {
		int ymaxPolygon = getYmax(polygon);
		int yminPolygon = getYmin(polygon);
		LinkedList<EdgeRecord>[] edgeTable = new LinkedList[ymaxPolygon
				- yminPolygon + 1];
		// initialize the linked lists
		for (int i = 0; i < edgeTable.length; i++) {
			edgeTable[i] = new LinkedList<EdgeRecord>();
		}
		for (int i = 0; i < edgeRecords.length; i++) {
			if (edgeRecords[i] != null) {
				// Add the edge record to the linked list at location ymin -
				// yminPolygon
				edgeTable[edgeRecords[i].ymin - yminPolygon]
						.add(edgeRecords[i]);
			}
		}
		return edgeTable;

	}

	private void scanFill(LinkedList<EdgeRecord>[] edgeTable) {
		LinkedList<EdgeRecord> scanLineList = new LinkedList<EdgeRecord>();
		for (int i = 0; i < edgeTable.length; i++) {
			// Merge the scanlinelist with the edgeRecords of ymin
			for (int j = 0; j < edgeTable[i].size(); j++) {
				scanLineList.add(edgeTable[i].get(j));
			}
			// Sort the scanlinelist on increasing xmin
			Collections.sort(scanLineList);
			// Fill the color between pair of points
			fillColor(scanLineList,y );
		}
	}

	private void fillColor(LinkedList<EdgeRecord> list, int y) {
		EdgeRecord edgeRecord1, edgeRecord2;
		Line line;
		for (int i = 0; i < list.size() ; i+=2) {
			edgeRecord1 = list.get(i);
			edgeRecord2 = list.get(i+1);
			line = new Line(new Point(edgeRecord1.xmin, ), new Point(edgeRecord2.xmin, ));
		}
	}

	private double getSlope(Point p1, Point p2) {
		if (p1.x == p2.x) {
			return Double.POSITIVE_INFINITY;
		} else {
			return (double) (p1.y - p2.y) / (p1.x - p2.x);
		}
	}

	private void printEdgeTable(LinkedList<EdgeRecord>[] edgeTable) {

		for (int i = 0; i < edgeTable.length; i++) {
			if (edgeTable[i] != null) {
				System.out.println("LinkedList No : " + i + "\n");
				printEdgeList(edgeTable[i]);
			}
		}
	}

	private void printEdgeList(LinkedList<EdgeRecord> list) {

		EdgeRecord edgeRecord;
		for (int i = 0; i < list.size(); i++) {
			edgeRecord = list.get(i);
			System.out.println("EdgeRecord " + i + edgeRecord.toString());

		}
	}

	private int getYmax(Polygon polygon) {
		int max = polygon.vertices[0].y;
		for (int i = 1; i < polygon.vertices.length; i++) {
			if (polygon.vertices[i].y > max) {
				max = polygon.vertices[i].y;
			}
		}
		return max;

	}

	private int getYmin(Polygon polygon) {
		int min = polygon.vertices[0].y;
		;
		for (int i = 1; i < polygon.vertices.length; i++) {
			if (polygon.vertices[i].y < min) {
				min = polygon.vertices[i].y;
			}
		}
		return min;
	}
}

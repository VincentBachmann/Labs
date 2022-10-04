import java.util.ArrayList;
	import java.util.List;

	

public class MazeCoordinates
{

		List<Integer> startCords = new ArrayList<Integer>();
		List<Integer> endCords = new ArrayList<Integer>();
		
		public void addStart(int row, int column) {
			startCords.add(row);
			startCords.add(column);
		}

		public void addEnd(int rowEnd, int columnEnd) {
			endCords.add(rowEnd);
			endCords.add(columnEnd);
		}

		public boolean isEmpty() {
			return startCords.isEmpty();
		}
		
		public int getStartCordRow() {
			return startCords.get(0);
		}
		
		public int getStartCordCol() {
			return startCords.get(1);
		}
		
		public int getStartRow() {
			int startRow = startCords.get(0);
			startCords.remove(0);
			return startRow;
			}
		
		public int getStartColumn() {
			int startColumn = startCords.get(0);
			startCords.remove(0);
			return startColumn;
		}
		
		public int getEndRow() {
			int endRow = endCords.get(0);
			endCords.remove(0);
			return endRow;
		}
		
		public int getEndColumn() {
			int endColumn = endCords.get(0);
			endCords.remove(0);
			return endColumn;
		}
	}


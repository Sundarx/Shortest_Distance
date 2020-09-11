//SUNDAR RAJ
public class ShortestDistance
{
	public static void main(String[] args)
	{
		// row index number and column index number represents vertex
		// number, and the number recorded in the array is the weight
		// of the edge between the two respective vertices
		int[][] graph ={{0, 3, 15, 4, 0, 0},
						{0, 0, 5, 0, 8, 12},
						{0, 0, 0, 0, 2, 0},
						{0, 0, 0, 0, 0, 0},
						{0, 0, 3, 0, 0, 8},
						{0, 0, 0, 7, 0, 0}};

		shortestPath(graph, 0);
	}

	public static void shortestPath(int[][] graph, int start)
	{
		int[] shortestDistance = new int[6];
		boolean[] distanceFound = new boolean[6];

		for(int i = 0; i < 6; i++)
		{
			shortestDistance[i] = Integer.MAX_VALUE;
			distanceFound[i] = false;
		}

		shortestDistance[start] = 0;

		for(int j = 0; j < 6 - 1; j++)
		{
			int index = minDistance(shortestDistance, distanceFound);
			distanceFound[index] = true;

			for(int i = 0; i < 6; i++)
			{
				if (distanceFound[i] == false && graph[index][i] > 0 &&
					shortestDistance[index] < Integer.MAX_VALUE &&
					shortestDistance[index] + graph[index][i] < shortestDistance[i])
				{
					shortestDistance[i] = shortestDistance[index] + graph[index][i];
				}
			}
		}

		printShortestDistance(shortestDistance);
	}

	public static int minDistance(int[] shortestDistance, boolean distanceFound[])
	{
		int min = Integer.MAX_VALUE;
		int indexOfMin = 0;

		for(int i = 0; i < 6; i++)
		{
			if(distanceFound[i] == false && shortestDistance[i] <= min)
			{
				min = shortestDistance[i];
				indexOfMin = i;
			}
		}
		return indexOfMin;
	}

	public static void printShortestDistance(int[] shortestDistance)
	{
		for (int i = 1; i < 6; i++)
		{
			System.out.println("Shortest distance from 0 to " + i
							 + ": " + shortestDistance[i]);
		}
	}
}